import { useState } from "react";

/*
버튼을 클릭하면 인풋창에 있는 내용이 h1태그안에 들어가도록 작성
*/
function StateSample3(){
	let [text, setText] = useState("");
	let [result, setResult] = useState("내용을 입력하세요.");
	return (
		<div>
			<input type="text" onChange={(e)=>setText(e.target.value)} />
			<button onClick={()=>setResult(text)}>등록</button>
			<h1>{result}</h1>
		</div>
	)
}

export default StateSample3;