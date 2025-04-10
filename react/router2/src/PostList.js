import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

function PostList(){
	let [list, setList] = useState([]);
	let [pm, setPm] = useState({});
	let [boards, setBoards] = useState([]);
	let {num} = useParams();

	useEffect(()=>{
		getPostList();

	}, [num]);

	function getPostList(){
		fetch("/api/react/post/list?po_bo_num="+num)
		.then(res=>res.json())
		.then(res=>{
			setList(res.list);
			setPm(res.pm);
			setBoards(res.boardList);
		});
	}

	return(
		<div>
			<h1>게시글 목록</h1>
			<div>
				{
					boards.map(board=>{
						return <Link to={"/post/list/"+board.bo_num} key={board.bo_num}>{board.bo_name}</Link>
					})
				}
			</div>
			<div>
				<table>
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
										<td>{post.po_title}</td>
										<td>{post.po_me_id}</td>
										<td>{post.po_date}</td>
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
				<ul>
					{
						pm.prev ? (
							<li>
								<Link>이전</Link>
							</li>
						) : null
					}
					{
						Array.from({length : pm.endPage - pm.startPage + 1}, (_,i)=> pm.startPage+i).map(i =>{
							return (
								<li key={i}>
									<Link>{i}</Link>
								</li>
							)
						})
					}
					{
						pm.next ? (
							<li>
								<Link>다음</Link>
							</li>
						) : null
					}
				</ul>
			</div>
		</div>
	)
}

export default PostList;