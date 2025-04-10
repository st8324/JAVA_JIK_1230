import { useEffect, useState } from "react";
import { Link, useParams, useSearchParams } from "react-router-dom";

function PostList(){
	let [list, setList] = useState([]);
	let [pm, setPm] = useState({});
	let [boards, setBoards] = useState([]);
	let {num} = useParams();
	let [seachParams] = useSearchParams();
	let page = seachParams.get("page") || 1;

	useEffect(()=>{
		getPostList();

	}, [num, page]);

	function getPostList(){
		fetch("/api/react/post/list?po_bo_num="+num+"&page=" + page)
		.then(res=>res.json())
		.then(res=>{
			setList(res.list);
			setPm(res.pm);
			setBoards(res.boardList);
		});
	}

	return(
		<div className="container">
			<h1>게시글 목록</h1>
			<div className="mb-3">
				<Link className={"btn btn"+(num == 0 ? "" : "-outline")+"-danger me-2"} to={"/post/list/0"}>전체</Link>
				{
					boards.map(board=>{
						return <Link className={"btn btn"+(num == board.bo_num ? "" : "-outline")+"-success me-2"} to={"/post/list/"+board.bo_num} key={board.bo_num}>{board.bo_name}</Link>
					})
				}
			</div>
			<div>
				<table className="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<th>추/비</th>
						</tr>
					</thead>
					<tbody>
						{ list.length != 0 ? 
							list.map(post=>{
								return(
									<tr key={post.po_num}>
										<td>{post.po_num}</td>
										<td>
											<Link to={"/post/detail/"+post.po_num}>{post.po_title}</Link>
										</td>
										<td>{post.po_me_id}</td>
										<td>{new Date(post.po_date).toLocaleDateString()}</td>
										<td>{post.po_view}</td>
										<td>{post.po_up}/{post.po_down}</td>
									</tr>
								)
							}) : (
								<tr>
									<th colSpan={6}>등록된 게시글이 없습니다.</th>
								</tr>
							)
						}
					</tbody>
				</table>
			</div>
			<div>
				<ul className="pagination justify-content-center">
					{
						pm.prev ? (
							<li className="page-item">
								<Link className="page-link" to={"/post/list/"+num+"?page="+(pm.startPage-1)}>이전</Link>
							</li>
						) : null
					}
					{
						Array.from({length : pm.endPage - pm.startPage + 1}, (_,i)=> pm.startPage+i).map(i =>{
							return (
								<li className={"page-item " + (i == pm.cri.page?"active" : "")} key={i}>
									<Link className="page-link" to={"/post/list/"+num+"?page="+i}>{i}</Link>
								</li>
							)
						})
					}
					{
						pm.next ? (
							<li className="page-item">
								<Link className="page-link" to={"/post/list/"+num+"?page="+(pm.endPage+1)}>다음</Link>
							</li>
						) : null
					}
				</ul>
			</div>
		</div>
	)
}

export default PostList;