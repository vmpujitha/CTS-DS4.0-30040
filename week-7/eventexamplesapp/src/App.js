import React, { Component } from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  incrementCount = () => {
    this.setState(prevState => ({
      count: prevState.count + 1
    }));
    this.sayHello();
  }

  decrementCount = () => {
    this.setState(prevState => ({
      count: prevState.count - 1
    }));
  }

  sayHello = () => {
    alert("Hello! The counter was incremented.");
  }

  sayWelcome = () => {
    alert("welcome");
  }

  handleClick = () => {
    alert("I was clicked");
  }

  render() {
    return (
      <div className="App">
        <div className="button-group">
          <button onClick={this.incrementCount}>Increment</button>
          <button onClick={this.decrementCount}>Decrement</button>
          <button onClick={this.sayWelcome}>Say welcome</button>
          <button onClick={this.handleClick}>Click on me</button>
        </div>
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;