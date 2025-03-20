<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>게시글 상세</h1>
	<div>
		<div class="form-group mt-3">
			<label class="form-label">게시판</label>
			<input type="text" class="form-control" value="${post.po_bo_name }" readonly>
		</div>
		<div class="form-group mt-3">
			<label class="form-label">제목</label>
			<input type="text" class="form-control" value="${post.po_title}" readonly>
		</div>
		<div class="form-group mt-3">
			<label class="form-label">작성자</label>
			<input type="text" class="form-control"value="${post.po_me_id}" readonly>
		</div>
		<div class="form-group mt-3">
			<label for="title" class="form-label">작성일</label>
			<input type="text" class="form-control" value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly>
		</div>
		
		<div class="form-group mt-3">
			<label for="title" class="form-label">조회수</label>
			<input type="text" class="form-control" value="${post.po_view}" readonly>
		</div>
		<div class="form-group mt-3">
			<label for="content" class="form-label">내용</label>
			<div class="form-control" id="content" style="min-height: 400px;">${post.po_content }</div>
		</div>
	</div>
	
</body>
</html>