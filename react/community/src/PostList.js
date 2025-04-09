import { useEffect, useState } from "react";

function PostList(){
	let [list, setList] = useState([]);

	useEffect(()=>{
		fetch("/api/react/post/list")
		.then(res=>res.json())
		.then(res=>{
			setList(res.list);
		})
	}, []);

	return(
		<div>
			<h1>게시글 목록</h1>
		</div>
	);
}

export default PostList;