import React, { Component } from 'react';
import './App.css';
import Greeting from './Greeting';
import LoginButton from './LoginButton';
import LogoutButton from './LogoutButton';
import FlightDetails from './FlightDetails';
import BookingForm from './BookingForm';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogoutClick = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    let button;
    let content;

    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />;
      content = <BookingForm />;
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />;
      content = <FlightDetails />;
    }

    return (
      <div className="App">
        <Greeting isLoggedIn={isLoggedIn} />
        {button}
        {content}
      </div>
    );
  }
}

export default App;