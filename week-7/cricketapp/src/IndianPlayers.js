import React from 'react';

export function OddPlayers({ players }) {
    const [first,, third,, fifth] = players;
    return (
        <div>
            <h2># Odd Players</h2>
            <ul>
                <li>First : {first}</li>
                <li>Third : {third}</li>
                <li>Fifth : {fifth}</li>
            </ul>
        </div>
    );
}

export function EvenPlayers({ players }) {
    const [,second,,fourth,,sixth] = players;
    return (
        <div>
            <h2>## Even Players</h2>
            <ul>
                <li>Second : {second}</li>
                <li>Fourth : {fourth}</li>
                <li>Sixth : {sixth}</li>
            </ul>
        </div>
    );
}

export const IndianPlayers = () => {
    const T20Players = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];
    const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
    const mergedPlayers = [...T20Players.slice(0, 3), ...RanjiTrophyPlayers];
    
    return (
        <div>
            <OddPlayers players={T20Players} />
            <hr />
            <EvenPlayers players={T20Players} />
            <hr />
            <h2>## List of Indian Players Merged:</h2>
            <ul>
                {mergedPlayers.map((player, index) => (
                    <li key={index}>Mr. {player}</li>
                ))}
            </ul>
        </div>
    );
};

export default IndianPlayers;