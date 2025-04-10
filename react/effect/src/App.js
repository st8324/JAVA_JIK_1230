import { useEffect, useState } from "react";

function App() {
  let [num, setNum] = useState(0);
  let [num2, setNum2] = useState(0);

  //랜더링이 실행될때마다 다시 실행됨
  console.log("App 실행");
  
  useEffect(()=>{
    console.log("처음 렌더링할 때만 실행");
    //[]이면 처음 렌더링 될때만 실행
  }, []);
  
  useEffect(()=>{
    console.log("num가 바뀔때만 실행");
    //[num]이면 num이 바뀌고 렌더링 될때만 실행
  }, [num]);

  return (
    <div>
      <button onClick={(e)=>setNum(++num)}>+</button>    
      <div>{num}</div>
      <button onClick={(e)=>setNum2(++num2)}>+</button>    
      <div>{num2}</div>
    </div>
  );
}

export default App;
