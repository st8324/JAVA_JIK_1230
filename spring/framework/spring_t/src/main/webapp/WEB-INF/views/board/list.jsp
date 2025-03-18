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
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="board">
				<tr>
					<td>${board.bo_num}</td>
					<td>
						<a href="#">${board.bo_title }</a>
					</td>
					<td>${board.bo_me_id }</td>
					<td><fmt:formatDate value="${board.bo_date }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td>${board.bo_view }</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0 }">
				<tr>
					<th colspan="5">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
</body>
</html>