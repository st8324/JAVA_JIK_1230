<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>게시글 리스트</h1>
	<!-- 서버에서 보낸 게시글 목록을 출력 -->
	<table class="table table-hover table-warning">
		<thead>
			<tr>
				<th>번호</th>
				
				<th>게시판</th>
				
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="post">
				<tr>
					<td>${post.po_num}</td>
					
					<td>${post.po_bo_name}</td>
					
					<td>
						<a href="<c:url value="/post/detail/${post.po_num}"/>">${post.po_title }</a>
					</td>
					<td>${post.po_me_id }</td>
					<td><fmt:formatDate value="${post.po_date }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td>${post.po_view }</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0 }">
				<tr>
					<th colspan="5">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	<a href="<c:url value="/post/insert"/>" class="btn btn-outline-success btn-insert">게시글 등록</a>
	<script type="text/javascript">
		$(".btn-insert").click(function(e){
			//로그인 했으면
			if(${user != null}){
				return;
			}
			e.preventDefault();
			//안했으면
			if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?")){
				location.href = "<c:url value="/login"/>";
				
			}
		})
		
	</script>
</body>
</html>