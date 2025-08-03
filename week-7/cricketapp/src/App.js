import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
    const [flag, setFlag] = useState(true);
    
    const players = [
        { name: 'Jack', score: 50 },
        { name: 'Michael', score: 70 },
        { name: 'John', score: 40 },
        { name: 'Ann', score: 61 },
        { name: 'Elisabeth', score: 61 },
        { name: 'Sachin', score: 95 },
        { name: 'Dhoni', score: 100 },
        { name: 'Virat', score: 84 },
        { name: 'Jadeja', score: 64 },
        { name: 'Raina', score: 75 },
        { name: 'Rohit', score: 80 }
    ];
    
    return (
        <div className="App">
            <button onClick={() => setFlag(!flag)}>
                Toggle View ({flag ? 'ListofPlayers' : 'IndianPlayers'})
            </button>
            
            {flag ? (
                <ListofPlayers players={players} />
            ) : (
                <IndianPlayers />
            )}
        </div>
    );
}

export default App;