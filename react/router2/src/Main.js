import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

function Main(){
	let [data, setData] = useState("");
	const location = useLocation();
	useEffect(()=>{
		let isSignup = false;
		if(location.state != null){
			isSignup = location.state.res;
		}
	
		if(isSignup === true){
			alert("회원가입에 성공했습니다.");
			location.state = null;
		}
	}, [location.state]);
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