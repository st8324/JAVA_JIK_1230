import {useState} from 'react';

function ToDoList(){
	let [list, setList] = useState(["등원", "1교시"]);
	let [toDo, setToDo] = useState("");

	function submit(e){
		e.preventDefault();
		//toDo가 비어있으면 alert으로 알림후 종료
		if(toDo.trim().length == 0){
			alert("오늘의 할일을 입력하세요.");
			return;
		}
		//리스트에 todo를 추가
		setList([...list, toDo.trim()]);
		setToDo("");
	}

	return (
		<div>
			<form onSubmit={submit}>
				<input type="text" onChange={(e)=>setToDo(e.target.value)} value={toDo}/>
				<button>등록</button>
			</form>
			<h1>오늘의 할일</h1>
			<ul>
				{
					list.map(v=><li>{v}</li>)
				}
			</ul>
		</div>
	)
}

export default ToDoList;