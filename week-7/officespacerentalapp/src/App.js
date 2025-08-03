import React from 'react';
import './App.css';

function App() {
  // Define JSX element for heading
  const element = "Office Space";
  
  // JSX attribute for image
  const jsxatt = <img src="https://www.lakdi.com/cdn/shop/files/1_5f993173-41da-46c9-a37f-5e410499bc5e.webp?v=1753444510" width="25%" height="25%" alt="Office Space"/>;
  
  // Array of office objects
  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Infosys", Rent: 75000, Address: "Bangalore" },
    { Name: "TCS", Rent: 65000, Address: "Mumbai" },
    { Name: "Wipro", Rent: 55000, Address: "Hyderabad" }
  ];

  // Function to determine text color based on rent
  const getRentColor = (rent) => {
    return rent <= 60000 ? 'red' : 'green';
  };

  return (
    <div className="App">
      {/* Display heading */}
      <h1>{element}, at Affordable Range</h1>
      
      {/* Display image */}
      {jsxatt}
      
      {/* Loop through offices array */}
      {offices.map((office, index) => (
        <div key={index} className="office-card">
          <h1>Name: {office.Name}</h1>
          <h3 style={{ color: getRentColor(office.Rent) }}>
            Rent: Rs. {office.Rent}
          </h3>
          <h3>Address: {office.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;