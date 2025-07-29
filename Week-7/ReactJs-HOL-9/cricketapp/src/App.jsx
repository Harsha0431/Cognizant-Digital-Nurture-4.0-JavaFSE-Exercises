import { useState } from "react";
import ListOfIndianPlayers from "./components/IndianPlayers";
import ListPlayers from "./components/ListofPlayers";

function App() {
  const [flag, setFlag] = useState(true);

  const buttons = [
    {
      title: "Show Players List (Players and their scores, Players having scores less than 70)",
      value: true
    },
    {
      title: "Show Indian Players (Odd, Even, Merged)",
      value: false
    }
  ]

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'center', marginTop: '20px' }}>
        <div style={{ display: 'flex', border: '1px solid #ccc' }}>
          {buttons.map((btn, index) => (
            <button
              key={index}
              onClick={() => setFlag(btn.value)}
              style={{
                backgroundColor: flag === btn.value ? 'blue' : 'lightblue',
                color: flag === btn.value ? 'white' : 'black',
                padding: '10px 20px',
                border: 'none',
                borderLeft: index !== 0 ? '1px solid white' : 'none',
                cursor: 'pointer'
              }}
            >
              {btn.title}
            </button>
          ))}
        </div>
      </div>
      <div>
        {
          flag ?
          <ListPlayers />:
          <ListOfIndianPlayers />
        }
      </div>
    </div>
  )
}

export default App
