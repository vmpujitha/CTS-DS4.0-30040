function LoginButton(props) {
  return (
    <button onClick={props.onClick} className="auth-button">
      Login
    </button>
  );
}

export default LoginButton;