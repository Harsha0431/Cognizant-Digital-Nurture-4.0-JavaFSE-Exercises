import { useState } from "react"
import Greeting from "./Greeting"

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <Greeting />
    </div>
  )
}

export default App
