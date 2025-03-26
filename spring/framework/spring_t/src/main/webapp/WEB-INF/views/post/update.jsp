<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
    <style type="text/css">
    	.del{
    		position: absolute; top:50%;right:0;
    		width: 30px; height: 30px; line-height: 24px;
    		font-size : 24px; transform : translateY(-50%);
    		text-align: center; cursor: pointer;
    		color : black; 
    	}
    	.del:hover{
    		text-decoration: none; color: red;
    	}
    </style>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="<c:url value="/post/update"/>" method="post" enctype="multipart/form-data">
		<input type="hidden" name="po_num" value="${post.po_num}">
		<div class="form-group mt-3">
			<label for="board" class="form-label">게시판</label>
			<select class="form-control" id="board" name="po_bo_num">
				<c:forEach items="${list}" var="board">
					<option value="${board.bo_num}" <c:if test="${board.bo_num == post.po_bo_num }">selected</c:if>>${board.bo_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group mt-3">
			<label for="title" class="form-label">제목</label>
			<input type="text" class="form-control" id="title" name="po_title" value="${post.po_title}">
		</div>
		<div class="form-group mt-3">
			<label for="content" class="form-label">내용</label>
			<textarea class="form-control" id="content" name="po_content" rows="10">${post.po_content }</textarea>
		</div>
		<div class="form-group mt-3">
			<label class="form-label">첨부파일</label>
			<c:forEach begin="1" end="${3 - fileList.size()}">
				<input type="file" class="form-control" name="fileList">
			</c:forEach>
			<c:forEach items="${fileList }" var="file">
				<div class="form-control" style="position: relative;">
					<span>${file.fi_ori_name}</span>
					<a href="javascript:void(0);" class="del" data-num="${file.fi_num}">&times;</a>
				</div>
			</c:forEach>
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">게시글 수정</button>
	</form>
	<script type="text/javascript">
		$('#content').summernote({
	        placeholder: '내용을 입력하세요.',
	        tabsize: 2,
	        height: 400
      	});
		$(".del").click(function(e){
			//삭제할 첨부파일 번호를 가져옴
			let fi_num = $(this).data("num");

			let inputTag = `<input type="file" class="form-control" name="fileList">`;
			let hiddenTag = `<input type="hidden" name="delNums" value="\${fi_num}">`;
			
			$("[name=fileList]").last().after(inputTag);
			$("[name=fileList]").last().after(hiddenTag);
			$(this).parent().remove();
		})
	</script>
</body>
</html>