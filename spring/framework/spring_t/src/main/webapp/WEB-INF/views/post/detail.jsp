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
	
	<c:choose>
		<c:when test="${post ne null}">
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
				<c:if test="${list.size() ne 0}">
					<div class="form-group">
						<label>첨부파일</label>
						<c:forEach items="${list }" var="file">
							<a class="form-control" href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">${file.fi_ori_name }</a>
						</c:forEach>							
					</div>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<h3>등록되지 않거나 삭제된 게시글입니다.</h3>		
		</c:otherwise>
	</c:choose>
	<div class="d-flex justify-content-between">
		<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록</a>
		<c:if test="${user.me_id eq post.po_me_id }">
			<div class="btns">
				<a href="<c:url value="/post/update/${post.po_num}"/>" class="btn btn-outline-info">수정</a>
				<a href="<c:url value="/post/delete/${post.po_num}"/>" class="btn btn-outline-danger">삭제</a>
			</div>
		</c:if>
	</div>
	<hr>
	<h3>댓글</h3>
	<div class="comment-container">
		<div class="comment-list">
			<!-- 
			<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
				<div class="comment-wrap">
					<div class="comment-writer">ad</div>
					<div class="comment-content">댓글입니다.</div>
				</div>
				<div class="comment-func mt-2">
					<button class="btn btn-outline-success">대댓</button>
					<button class="btn btn-outline-warning">수정</button>
					<button class="btn btn-outline-danger" >삭제</button>
				</div>
			</div> 
			-->
		</div>
		<div class="comment-pagination"></div>
		<div class="comment-insert-box">
		<form class="input-group mb-3 insert-form" action="<c:url value="/comment/insert"/>" method="post">
		    <input type="hidden" name="co_po_num" value="${post.po_num}">
		    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
		    <button class="btn btn-outline-success"> 댓글 등록</button>
		</form>
		</div>
	</div>
	
	<!-- 답글 등록 -->
	<script type="text/javascript">
		$(document).on("click", ".btn-reply", function(e){
			let str = `
				<form class="input-group mb-3 insert-form reply mt-2" action="<c:url value="/comment/insert"/>" method="post">
					<input type="hidden" name="co_ori_num" value="\${""}">
					<input type="hidden" name="co_po_num" value="${post.po_num}">
				    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
				    <button class="btn btn-outline-primary"> 답글 등록</button>
				</form>
			`
			$(this).parent().after(str);
		});
	</script>
	
	<!-- 댓글 목록 조회 -->
	<script type="text/javascript">
		function getCommentList(cri){
			//ajax로 댓글 리스트를 가져와서 화면에 출력
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/comment/list"/>', 
				type : 'post', 
				data : JSON.stringify({
					search : '${post.po_num}'
				}), 
				contentType : "application/json; charset=utf-8",
				dataType : "json", 
				success : function (data){
					let list = data.list;
					drawCommentList(list);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		}
		function drawCommentList(list){
			
			if(list.length == 0){
				$(".comment-list").html(`<div class="text-center mb-3">등록된 게시글이 없습니다.</div>`)
				return;
			}
			
			let str = '';
			for(comment of list){
				let btns = '';
				if(comment.co_me_id == '${user.me_id}'){
					btns = `
						<button class="btn btn-outline-warning">수정</button>
						<button class="btn btn-outline-danger" >삭제</button>
					`;
				}
				
				str += `
					<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
						<div class="comment-wrap">
							<div class="comment-writer">\${comment.co_me_id}</div>
							<div class="comment-content">\${comment.co_content}</div>
						</div>
						<div class="comment-func mt-2">
							<button class="btn btn-outline-success btn-reply">답글</button>
							\${btns}
						</div>
					</div>
				`
			}
			$(".comment-list").html(str);
		}
		
		getCommentList();
	</script>
	
	<!-- 댓글 등록 -->
	<script type="text/javascript">
		$(".insert-form").submit(function(e){
			e.preventDefault();
			
			if('${user.me_id}' == ''){
				if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return false;
			}
			let $obj = $("[name=co_content]");
			let content = $obj.val().trim();
			if(content == ''){
				alert("댓글을 입력하세요.");
				$obj.focus();
				return false;
			}
			let obj = {
				co_po_num : $("[name=co_po_num]").val(),
				co_content : $("[name=co_content]").val()
			}
			let url = $(this).attr("action"); 
			$.ajax({
				async : false, 
				url : url,   
				type : 'post', 
				data : JSON.stringify(obj), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					if(data){
						alert("댓글을 등록했습니다.");
						getCommentList();
					}else{
						alert("댓글을 등록하지 못했습니다.");
					}
					$obj.val("");
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			return false;
		});
	</script>
</body>
</html>