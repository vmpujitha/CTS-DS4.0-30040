function GuestGreeting() {
  return <h1>Please sign up.</h1>;
}

function UserGreeting() {
  return <h1>Welcome back</h1>;
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  return isLoggedIn ? <UserGreeting /> : <GuestGreeting />;
}

export default Greeting;