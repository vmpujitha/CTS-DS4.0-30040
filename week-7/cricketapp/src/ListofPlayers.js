import React from 'react';

const ListofPlayers = ({ players }) => {
    // Filter players with score <= 70 using arrow function
    const players70 = players.filter(item => item.score <= 70);
    
    return (
        <div>
            <h2>All Players</h2>
            <ul>
                {players.map((item) => (
                    <div key={item.name}>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                ))}
            </ul>
            
            <h2>Players with Score ≤ 70</h2>
            <ul>
                {players70.map((item) => (
                    <div key={item.name}>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                ))}
            </ul>
        </div>
    );
};

export default ListofPlayers;