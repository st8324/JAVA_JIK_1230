import { useState } from 'react';
import './App.css';
import Button from './Button';
import ToDoList from './ToDoList'

function App() {

  let [num, setNum] = useState(1);

  function leftClick(){
    setNum(--num);
  }
  function rightClick(){
    setNum(++num);
  }
  return (
    <div>
      <button onClick={leftClick} className="btn" >-</button>
      <span>{num}</span>
      <Button click={rightClick} className={"btn"} text={"+"} />
      <hr/>
      <Button className={"btn"}/>
      <ToDoList/>
    </div>
  );
}

export default App;
