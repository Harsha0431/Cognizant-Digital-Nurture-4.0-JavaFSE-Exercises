import { useState } from "react";
import './App.css';

export default function App() {
  const [count, setCount] = useState(0);

  const handleIncrement = () => {
    setCount(count + 1);
    alert("Hello! Member1");
  }



  return (
    <div className="body__container">
      <h2>{count}</h2>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={() => setCount(count - 1)}>Decrement</button>
      <button onClick={() => {
        alert("welcome");
      }}>Say Hello</button>
      <button onClick={() => {
        alert("I was clicked");
      }}>Click on me</button>
      <CurrencyConverter />
    </div>
  )
}


function CurrencyConverter() {
  const [value, setValue] = useState(0);
  const [currency, setCurrency] = useState('');

  const handleCurrencyFromSubmit = (e) => {
    e.preventDefault();
    const euro_1_rupee = 99;
    const rupees = value * euro_1_rupee;
    alert("Converting Euro to Rupees, amount is ₹" + rupees);
  }

  return (
    <div>
      <h1 style={{ color: 'green' }}>Currency Converter</h1>
      <form onSubmit={handleCurrencyFromSubmit}>
        <input type="number" value={value} onChange={(e) => setValue(e.target.value)} />
        <textarea readOnly defaultValue={"Euro"} onChange={(e) => setCurrency(e.target.value)} />
        <span>One Euro is 99 rupees</span>
        <input type="submit" value="Convert" />
      </form>
    </div>
  )
}