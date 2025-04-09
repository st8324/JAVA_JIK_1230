
function Page1({list}){
	
	return(
		<div>
			<h1>게시글 목록</h1>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					{
						list.map(post=>{
							return(
								<tr key={post.num}>
									<td>{post.num}</td>
									<td>{post.title}</td>
									<td>{post.writer}</td>
									<td>{post.view}</td>
								</tr>
							)
						})
					}
				</tbody>
			</table>
		</div>
	)
}

export default Page1;