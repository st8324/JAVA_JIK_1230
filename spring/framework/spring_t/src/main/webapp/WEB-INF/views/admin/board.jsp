<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
	<h1>게시판 관리</h1>
	<!-- 게시판 목록 조회 -->
	<table class="table table-hover table-warning">
		<thead>
			<tr>
				<th class="text-center">게시판명</th>
				<th class="text-center">기능</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="board">
				<tr>
					<td>${board.bo_name}</td>
					<td>
						수정, 삭제
					</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0 }">
				<tr>
					<th colspan="2" class="text-center">등록된 게시판이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>

	<!-- 게시판 등록  -->
</body>
</html>
