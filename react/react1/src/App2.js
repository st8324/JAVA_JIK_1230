import { useState } from "react";

/*

*/
function App2(){
	let [hobby, setHobby] = useState("");

	function change(e){
		let {value, name, checked} = e.target;
		setHobby(value);
	}
	return (
		<div>
			<label>
				<input type="radio" value={"독서"} name="hobby" onClick={change}/> 독서
			</label>
			<label>
				<input type="radio" value={"운동"} name="hobby" onClick={change}/> 운동
			</label>
			<label>
				<input type="radio" value={"음악 감상"} name="hobby" onClick={change}/> 음악 감상
			</label>
			<h1>{hobby}</h1>
		</div>
	)
}

export default App2;