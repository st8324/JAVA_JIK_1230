<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="<c:url value="/login"/>" method="post">
		<h1>로그인</h1>
		<div class="form-group mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<div class="form-group mt-3">
			<label for="pw" class="form-label">비번</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">로그인</button>
	</form>
</body>
</html>