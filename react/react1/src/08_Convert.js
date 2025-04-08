import { useState } from "react";

/*
미터를 입력해서 변환을 클릭하면 cm로 변환되는 코드를 작성하세요.
*/
function Convert(){
	let [amount , setAmount] = useState(0);
	let [res, setRes] = useState(0);

	function convert(){
		setRes(amount*100);
	}
	return(
		<div>
			<div>
				<input type="number" onChange={(e)=>setAmount(e.target.value)}/> 
				<button onClick={convert}>변환</button>
			</div>
			<input type="number" disabled value={res} />
		</div>
	)
}

export default Convert;