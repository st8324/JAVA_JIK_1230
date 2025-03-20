<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert"/>" method="post">
		<div class="form-group mt-3">
			<label for="board" class="form-label">게시판</label>
			<select class="form-control" id="board" name="po_bo_num">
				<c:forEach items="${list}" var="board">
					<option value="${board.bo_num}">${board.bo_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group mt-3">
			<label for="title" class="form-label">제목</label>
			<input type="text" class="form-control" id="title" name="po_title">
		</div>
		<div class="form-group mt-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" id="content" name="po_content" rows="10"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">게시글 등록</button>
	</form>
	<script type="text/javascript">
		$('#content').summernote({
	        placeholder: '내용을 입력하세요.',
	        tabsize: 2,
	        height: 400
      	});
	</script>
</body>
</html>