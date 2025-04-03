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
<body id="body">
	
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
				<div class="form-group mt-3 d-flex justify-content-center" id="btns">
					<button class="btn btn<c:if test="${like.li_state ne 1 }">-outline</c:if>-success btn-up" data-state="1">추천(<span>${post.po_up }</span>)</button>
					<button class="btn btn<c:if test="${like.li_state ne -1 }">-outline</c:if>-danger ml-3 btn-down" data-state="-1">비추천(<span>${post.po_down }</span>)</button>
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
		
	</div>
	
	<!-- 댓글 목록 조회 -->
	<script type="text/javascript">
		var cri = {
			page : 1,
			search : ${post.po_num}
		}
		function getCommentList(cri){
			//ajax로 댓글 리스트를 가져와서 화면에 출력
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/comment/list"/>', 
				type : 'post', 
				data : JSON.stringify(cri), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					$(".comment-container").html(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		}
		
		getCommentList(cri);
	</script>
	<script type="text/javascript">
		//추천/비추천 버튼 클릭 이벤트 등록
		$(document).on("click", ".btn-up, .btn-down", function(e){
			
			if(${user == null}){
				if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?")){
					location.href= "<c:url value="/login"/>";	
				}
				return;
			}
			let state = $(this).data("state");
			let num ="${post.po_num}";
			
			let like = {
				li_po_num : num,
				li_state : state
			}
			$.ajax({
				async : true, 
				url : '<c:url value="/post/like"/>', 
				type : 'post', 
				data : JSON.stringify(like), 
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function (data){
					let res = data.res;
					let upCount = data.up;
					let downCount = data.down;
					drawUpDownBtns(res, upCount, downCount)
					switch(res){
					case -1:
						alert("비추천 했습니다.");
						break;
					case 1:
						alert("추천 했습니다.");
						break;
					case 0:
						alert((state == 1?"추천":"비추천") + "을 취소했습니다.");
						break;
					default:
						alert("추천/비추천을 하지 못했습니다.");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
		
		function drawUpDownBtns(state, upCount, downCount){
			//버튼들 색상처리
			//초기 버튼 테두리 배경을 제거
			$(".btn-up").removeClass("btn-outline-success");
			$(".btn-up").removeClass("btn-success");
			$(".btn-down").removeClass("btn-outline-danger");
			$(".btn-down").removeClass("btn-danger");
			//상태에 맞게 테두리 배경을 선택
			switch(state){
			case 1:
				$(".btn-up").addClass("btn-success");
				$(".btn-down").addClass("btn-outline-danger");
				break;
			case -1:
				$(".btn-down").addClass("btn-danger");
				$(".btn-up").addClass("btn-outline-success");
				break;
			case 0:
				$(".btn-up").addClass("btn-outline-success");
				$(".btn-down").addClass("btn-outline-danger");
			}
			//추천 비추천수 업데이트
			$(".btn-up span").text(upCount);
			$(".btn-down span").text(downCount);
		}
	</script>
</body>
</html>