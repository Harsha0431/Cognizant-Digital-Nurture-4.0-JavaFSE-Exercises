import { IndianPlayers } from "./PlayersList";

function OddPlayers({ players }) {
    const [first, third, fifth] = players;

    return (
        <ul>
            <li>First: {first}</li>
            <li>Third: {third}</li>
            <li>Fifth: {fifth}</li>
        </ul>
    )
}

function EvenPlayers({ players }) {
    const [second, fourth, fifth] = players;

    return (
        <ul>
            <li>Second: {second}</li>
            <li>Fourth: {fourth}</li>
            <li>Fifth: {fifth}</li>
        </ul>
    )
}


export default function ListOfIndianPlayers() {
    const playersList = [
        'Sachin 1',
        'Dhoni 2',
        'Virat 3',
        'Rohit 4',
        'Yuvaraj 5',
        'Raina 6'
    ]
    return (
        <div>
            <div style={{ borderBottom: '2px solid black' }}>
                <h1>Odd Players</h1>
                <OddPlayers players={playersList.filter((_, ind) => ind % 2 == 0)} />
            </div>

            <div style={{ borderBottom: '2px solid black' }}>
                <h1>Even Players</h1>
                <EvenPlayers players={playersList.filter((_, ind) => ind % 2 == 1)} />
            </div>

            <div>
                <h1>List of Indian Players Merged</h1>
                <ul>
                    {
                        IndianPlayers.map(player =>
                            <li key={player}>Mr. {player}</li>
                        )
                    }
                </ul>
            </div>
        </div>
    )
}
