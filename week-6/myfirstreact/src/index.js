// src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App'; // Make sure this path is correct

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App /> {/* Make sure you're rendering the App component */}
  </React.StrictMode>
);