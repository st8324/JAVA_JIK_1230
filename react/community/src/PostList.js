import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";

function PostList(){
	let [list, setList] = useState([]);
	let [pm, setPm] = useState({});
	let [boards, setBoards] = useState([]);
	let {num} = useParams();

	useEffect(()=>{
		
		fetch("/api/react/post/list?po_bo_num="+num)
		.then(res=>res.json())
		.then(res=>{
			setList(res.list);
			setPm(res.pm);
			setBoards(res.boardList);
		})
	}, [num]);

	return(
		<div className="container">
			<h1>게시글 목록</h1>
			{
				boards.map(board=>{
					return (
					<Link to={"/post/list/" + board.bo_num} className="btn btn-outline-success me-2">{board.bo_name}</Link>)
				})
			}
			<table className="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>추천/비추천</th>
					</tr>
				</thead>
				<tbody>
					{
						list.map(post=>{
							return(
								<tr>
									<td>{post.po_num}</td>
									<td>{post.po_title}</td>
									<td>{post.po_me_id}</td>
									<td>{new Date(post.po_date).toLocaleDateString()}</td>
									<td>{post.po_view}</td>
									<td>{post.po_up}/{post.po_down}</td>
								</tr>
							)
						})
					}
					
				</tbody>
			</table>
			<ul className="pagination justify-content-center">
				{ pm.prev ?(
					<li className="page-item">
						<a className="page-link" href="javascript:void(0);">이전</a>
					</li>
				): null}
				{
					Array.from({length : pm.endPage - pm.startPage + 1}, (_, i) => pm.startPage + i).map(v=>{
						return (<li className="page-item">
							<a className="page-link">{v}</a>
						</li>)
					})
				}
				{ pm.next ?(
					<li className="page-item">
						<a className="page-link" href="javascript:void(0);">다음</a>
					</li>
				): null}
			</ul>
		</div>
	);
}

export default PostList;