import { useState } from "react";

function Page2({func}){
	let [title, setTitle] = useState("");
	let [writer, setWriter] = useState("");
	let [content, setContent] = useState("");
	function submit(e){
		e.preventDefault();
		let obj = {
			title, //title : title
			writer,
			content, 
		}
		func(obj);
		setTitle("");
		setWriter("");
		setContent("");
	}
	return(
		<div>
			<h1>게시글 등록</h1>
			{/* form태그를 만들어서 제목, 내용, 작성자를 입력하는 화면을 구성하고,
				게시글 등록을 눌러 전송하면 입력한 제목, 내용, 작성자를 콘솔에 출력하도록 작업.
				단, 전송 이벤트는 동작하지 않도록 막아줌.
				출력할 때 제목, 내용, 작성자를 객체 만들어서 출력.
			 */}
			<form onSubmit={submit}>
				<input type="text" placeholder="제목을 입력하세요." onChange={e=>setTitle(e.target.value)}  value={title}/> 
				<br/>
				<input type="text" placeholder="작성자를 입력하세요." onChange={e=>setWriter(e.target.value)} value={writer}/> 
				<br/>
				<textarea placeholder="내용을 입력하세요." onChange={e=>setContent(e.target.value)} value={content}></textarea>
				<br/>
				<button type="submit">게시글 작성</button>
			</form>
		</div>
	)
}

export default Page2;