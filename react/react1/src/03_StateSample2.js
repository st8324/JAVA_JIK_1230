import { useState } from "react";

/*
input태그에 값을 입력받아 h1태그에 출력하는 작업
*/
function StateSample2(){
	let [text, setText] = useState("");
	return (
		<div>
			<input type="text" onChange={(e)=>setText(e.target.value)} />
			<h1>{text}</h1>
		</div>
	)
}

export default StateSample2;