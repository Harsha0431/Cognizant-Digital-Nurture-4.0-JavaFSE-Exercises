import { About } from "./About"
import { Contact } from "./Contact"
import { Home } from "./Home"

function App() {

  return (
    <div style={{ display: 'flex', justifyContent: 'center', flexDirection: 'column', flex: 1, textAlign: 'center' }}>
      <Home />
      <About />
      <Contact />
    </div>
  )
}

export default App
