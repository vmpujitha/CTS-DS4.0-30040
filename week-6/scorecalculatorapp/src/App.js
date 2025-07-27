import React from 'react';
import { CalculateScore } from './components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name={"JVM PUJITHA"}
        School={"St.Anns High School"}
        total={285}
        goal={3}
      />
    </div>
  );
}

export default App;