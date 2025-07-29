
export default function ListPlayers() {
    const players = [
        { name: "Jack", score: 50 },
        { name: "Michael", score: 70 },
        { name: "John", score: 40 },
        { name: "Ann", score: 61 },
        { name: "Elisabeth", score: 61 },
        { name: "Sachin", score: 95 },
        { name: "Dhoni", score: 100 },
        { name: "Virat", score: 84 },
        { name: "Jadeja", score: 64 },
        { name: "Raina", score: 75 },
        { name: "Rohit", score: 80 }
    ]

    return (
        <div>
            <div style={{ borderBottom: '2px solid black'}}>
                <h1>List of Players</h1>
                <ul>
                    {players.map((player, index) => (
                        <li key={index}>
                            Mr. {player.name} {player.score}
                        </li>
                    ))}
                </ul>
            </div>

            <div>
                <h1>List of Players having Scores Less than 70</h1>
                <ul>
                    {players.filter(player => player.score <= 70).map((player, index) => (
                        <li key={index}>
                            Mr. {player.name} {player.score}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    )
}
