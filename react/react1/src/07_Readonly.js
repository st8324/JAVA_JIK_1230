import { useState } from "react";

/*
읽기 버튼을 클릭하면 입력창이 읽기전용으로 변경되고 버튼 글자가 쓰기로 변경
쓰기 버튼을 클릭하면 입력창이 쓸수 있도록 변경되고 버튼 글자가 읽기로 변경
*/
function ReadOnly(){
	let [readOnly, isReadOnly] = useState(false);
	let [text, setText] = useState("읽기");

	function toggle(){
		isReadOnly(!readOnly);
		if(readOnly){
			setText("읽기");
		}else{
			setText("쓰기");
		}
	}

	return (
		<div>
			<input readOnly={readOnly}/>
			<button onClick={toggle}>{text}</button>
		</div>
	)
}

export default ReadOnly;