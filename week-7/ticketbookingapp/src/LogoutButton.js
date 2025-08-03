function LogoutButton(props) {
  return (
    <button onClick={props.onClick} className="auth-button">
      Logout
    </button>
  );
}

export default LogoutButton;