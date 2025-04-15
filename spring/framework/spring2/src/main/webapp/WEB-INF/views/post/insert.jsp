<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		.file-label>.base-img{
			display : block;
			width: 150px; height: 200px; border: 3px solid black;
			text-align: center; line-height: 190px; font-size: 50px
		}
		.file-label>img{
			display: none;
		}
		.file-label>input{
			display: none;
		}
	</style>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert"/>" method="post" enctype="multipart/form-data">
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
			<div class="form-label">첨부파일</div>
			<div class="d-flex">
				<label class="file-label mr-3">
					<span class="base-img">+</span>
					<img class="sel-img" width="150" height="200">
					<input type="file" class="form-control" name="fileList" accept="image/*">
				</label>
				<label class="file-label  mr-3">
					<span class="base-img">+</span>
					<img class="sel-img" width="150" height="200">
					<input type="file" class="form-control" name="fileList" accept="image/*">
				</label>
				<label class="file-label  mr-3">
					<span class="base-img">+</span>
					<img class="sel-img" width="150" height="200">
					<input type="file" class="form-control" name="fileList" accept="image/*">
				</label>
			</div>
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">게시글 등록</button>
	</form>
	<script type="text/javascript">
		$("[name=fileList]").change(function(e){
			const $this = $(this);
			const file = this.files[0];
			if(file){
				const reader = new FileReader();
				reader.onload = function(e){
					$this.prev().attr("src", e.target.result).show();
					$this.prevAll(".base-img").hide();
				}
				reader.readAsDataURL(file);
			}else{
				$this.prev().hide();
				$this.prevAll(".base-img").show();
			}
		});
		$("form").submit(function(e){
			//첨부파일이 1개이상인지 확인
			let count = 0;
			$("[name=fileList]").each(function(e){
				count += this.files.length;
			})
			if(count == 0){
				alert("이미지는 1개 이상 선택하세요.")
				return false;
			}
		})
	</script>
</body>
</html>