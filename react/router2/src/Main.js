import { useState } from "react";

function Main(){
	let [data, setData] = useState("");

	fetch("/api/test")
	.then(res=>res.text())
	.then(res=>setData(res));

	return(
		<div>
			<h1>메인</h1>
			<h2>{data}</h2>
		</div>
	)
}

export default Main;