<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert"/>" method="post">
		<div class="form-group mt-3">
			<label for="title" class="form-label">제목</label>
			<input type="text" class="form-control" id="title" name="po_title">
		</div>
		<div class="form-group mt-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" id="content" name="po_content" rows="10"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">회원가입</button>
	</form>
</body>
</html>