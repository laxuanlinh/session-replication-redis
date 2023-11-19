import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [result, setResult] = useState("")
  const [result2, setResult2] = useState("")

  const handleClick = () => {
    fetch('http://localhost:8080/test', {credentials: 'include'})
    .then(response => response.json())
    .then(response => setResult(response.message))
    .catch(error => console.error(error));
  }

  const handleClick2 = () => {
    fetch('http://localhost:8081/test-two', {credentials: 'include'})
    .then(response => response.json())
    .then(response => setResult(response.message))
    .catch(error => console.error(error));
  }

  return (
    <>
      <button onClick={handleClick}>Click me</button>
      <p>{result}</p>

      <button onClick={handleClick2}>Click me 2</button>
      <p>{result2}</p>
    </>
  )
}

export default App
