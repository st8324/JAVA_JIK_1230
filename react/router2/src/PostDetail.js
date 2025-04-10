import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function PostDetail(){
	let {num} = useParams();//url에 있는 게시글 번호를 가져옴
	let [post, setPost] = useState({});//비동기 통신으로 가져온 게시글을 담을 변수

	useEffect(()=>{
		fetch("/api/react/post/detail/"+num)
		.then(res=>res.json())
		.then(res=>setPost(res.post));
	},[]);
	return (
		<div className="container">
			<h1>게시글 상세</h1>
			{post == null ? <div>삭제되거나 등록되지 않은 게시글입니다.</div>:(
				<div>
					<div className="mb-3 mt-3">
						<label className="form-label">제목</label>
						<div className="form-control">{post.po_title}</div>
					</div>
					<div className="mb-3 mt-3">
						<label className="form-label">작성자</label>
						<div className="form-control">{post.po_me_id}</div>
					</div>
					<div className="mb-3 mt-3">
						<label className="form-label">작성일</label>
						<div className="form-control">{new Date(post.po_date).toLocaleString()}</div>
					</div>
					<div className="mb-3 mt-3">
						<label className="form-label">조회수</label>
						<div className="form-control">{post.po_view}</div>
					</div>
					<div className="mb-3 mt-3">
						<label className="form-label">내용</label>
						<div className="form-control" dangerouslySetInnerHTML={{__html : post.po_content}} ></div>
					</div>
				</div>
			)}
		</div>
	)
}

export default PostDetail;