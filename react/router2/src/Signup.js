import { useState } from "react";
import { useNavigate } from "react-router-dom";


function Signup(){
	const navigate = useNavigate();

	let [data, setData] = useState({
		me_id : '',
		me_pw : '',
		me_pw2 : '',
		me_email : ''
	});

	const checkRegex = e =>{
		//유효성 검사 
		if(data.me_id === ''){
			alert("아이디는 필수항목입니다.");
			return false;
		}
		if(data.me_pw === ''){
			alert("비번은 필수항목입니다.");
			return false;
		}
		if(data.me_pw !== data.me_pw2){
			alert("비번과 비번확인이 일치하지 않습니다.");
			return false;
		}
		if(data.me_email === ''){
			alert("이메일은 필수항목입니다.");
			return false;
		}
		return true;
	}

	const clearData = e =>{
		setData({
			me_id : '',
			me_pw : '',
			me_pw2: '',
			me_email : ''
		})
	}

	const submit = function (e){
		e.preventDefault();
		
		if(!checkRegex()){
			return;
		}

		fetch("/api/react/signup",{
			method : "post",
			body : JSON.stringify(data),
			headers : {
				"Content-type" : "application/json"
			}
		})
		.then(res=>res.json())
		.then(res=>{
			if(res){
				//alert("회원 가입이 완료되었습니다.");
				navigate("/", {
					state : {
						res : res
					}
				});
			}
			else{
				alert("회원 가입에 실패했습니다.")
				clearData();
			}
		});

	}

	const change = e =>{
		setData({
			...data,
			[e.target.name] : e.target.value
		})
	}
	return (
		<div className="container">
			<h1>회원가입</h1>
			<form onSubmit={submit}>
				<div className="mb-3 mt-3">
					<label htmlFor="id" className="form-label">아이디:</label>
					<input type="text" className="form-control" id="id" placeholder="아이디를 입력하세요." value={data.me_id} name="me_id" onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw" className="form-label">비번:</label>
					<input type="password" className="form-control" id="pw" placeholder="비밀번호를 입력하세요."value={data.me_pw}  name="me_pw" onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw2" className="form-label">비번확인:</label>
					<input type="password" className="form-control" id="pw2" placeholder="비번확인을 입력하세요."value={data.me_pw2}  name="me_pw2" onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="email" className="form-label">이메일:</label>
					<input type="email" className="form-control" id="email" placeholder="이메일을 입력하세요."value={data.me_email}  name="me_email" onChange={change}/>
				</div>
				<button className="btn btn-outline-success col-12">회원가입</button>
			</form>
		</div>
	)
}

export default Signup;