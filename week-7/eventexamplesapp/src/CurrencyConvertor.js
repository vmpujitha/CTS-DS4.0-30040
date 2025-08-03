import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: 'Euro'
    };
  }

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value
    });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    const euroAmount = parseFloat(this.state.amount) * 80; // Convert Euro to INR
    alert(`Converting to Euro Amount is ${euroAmount}`);
    this.setState({ amount: '' });
  }

  render() {
    return (
      <div className="currency-convertor">
        <h1>Currency Convertor!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label>Amount: </label>
            <input 
              type="number" 
              name="amount" 
              value={this.state.amount} 
              onChange={this.handleChange} 
            />
          </div>
          <div className="form-group">
            <label>Currency: </label>
            <select 
              name="currency" 
              value={this.state.currency} 
              onChange={this.handleChange}
            >
              <option value="Euro">Euro</option>
            </select>
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;