<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<div class="comment-list">
		<c:forEach items="${list}" var="comment">
			<div class="<c:if test="${comment.co_num != comment.co_ori_num }">pl-5</c:if>">
				<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
					<c:choose>
						<c:when test="${comment.co_del eq 'N' }">
							<div class="comment-wrap">
								<div class="comment-writer">${comment.co_me_id}</div>
								<div class="comment-content">${comment.co_content }</div>
							</div>
							<div class="comment-func mt-2">
								<c:if test="${comment.co_num == comment.co_ori_num }">
									<button class="btn btn-outline-success btn-reply" data-num="${comment.co_num}">답글</button>
								</c:if>
								<c:if test="${comment.co_me_id == user.me_id }">
									<button class="btn btn-outline-warning btn-update" data-num="${comment.co_num}">수정</button>
									<button class="btn btn-outline-danger btn-delete" data-num="${comment.co_num}">삭제</button>
								</c:if>
							</div>
						</c:when>
						<c:otherwise>
							<div>작성자에 의해 삭제된 댓글입니다.</div>
						</c:otherwise>
					</c:choose>
				</div> 
			</div>
		</c:forEach>
		<c:if test="${list.size() == 0 }">
			<div class="text-center">등록된 댓글이 없습니다.</div>
		</c:if>
	</div>
	<div class="comment-pagination">
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<li class="page-item">
					<a class="page-link" href="javascript:void(0);" data-page="${pm.startPage-1}">이전</a>
				</li>
			</c:if>
			<c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
				<li class="page-item <c:if test="${pm.cri.page == i }">active</c:if>">
					<a class="page-link" href="javascript:void(0);" data-page="${i}">${i}</a>
				</li>
			</c:forEach>
			<c:if test="${pm.next}">
				<li class="page-item">
					<a class="page-link" href="javascript:void(0);" data-page="${pm.endPage+1}">다음</a>
				</li>
			</c:if>
		</ul>
	</div>
	<div class="comment-insert-box">
	<form class="input-group mb-3 insert-form" action="<c:url value="/comment/insert"/>" method="post">
	    <input type="hidden" name="co_po_num" value="${pm.cri.search}">
	    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
	    <button class="btn btn-outline-success"> 댓글 등록</button>
	</form>
	</div>
	
	<!-- 수정 완료 버튼을 눌러서 댓글 수정 등록 -->
	<script type="text/javascript">
		$(document).off("submit", ".update-form");
		$(document).on("submit", ".update-form", function(e){
			e.preventDefault();
			
			if('${user.me_id}' == ''){
				if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return;
			}
			let $obj = $(this).find("[name=co_content]");
			let content = $obj.val().trim();
			if(content == ''){
				alert("댓글을 입력하세요.");
				$obj.focus();
				return;
			}
			let co_num = $(this).find("[name=co_num]").val();
			let co_content = $(this).find("[name=co_content]").val();
			
			let obj = {
				co_content : co_content,
				co_num : co_num
			}
			
			let url = $(this).attr("action"); 
			$.ajax({
				async : true, 
				url : url,   
				type : 'post', 
				data : JSON.stringify(obj), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					if(data){
						alert("댓글을 수정했습니다.");
						getCommentList(cri);
					}else{
						alert("댓글을 수정하지 못했습니다.");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
	
	<!-- 수정 버튼 클릭 이벤트 등록 -->
	<script type="text/javascript">
		$(".btn-update").click(function(e){
			var $content = $(this).parents(".comment-item").find(".comment-content");
			$content.hide();
			
			var co_content = $content.text();
			var co_num = $(this).data("num");
			
			//수정 입력창 생겼으면 추가하지 않음
			if($content.next().length != 0){
				return;
			}
			
			var str = `
				<form class="input-group mb-3 update-form reply mt-2" action="<c:url value="/comment/update"/>" method="post">
					<input type="hidden" name="co_num" value="\${co_num}">
				    <textarea class="form-control" name="co_content">\${co_content}</textarea>
				    <button class="btn btn-outline-primary"> 답글 수정</button>
				</form>
			`
			$content.after(str);
		})
	</script>
	<!-- 페이지 클릭 이벤트 등록 -->
	<script type="text/javascript">
		
		$(".comment-pagination .page-link").click(function(e){
			let page = $(this).data("page");
			cri.page = page;
			getCommentList(cri);
		});
	</script>

	<!-- 삭제 이벤트 등록 -->
	<script type="text/javascript">
	
		$(".btn-delete").click(function(e){
			let co_num = $(this).data("num");
			$.ajax({
				async : true, 
				url : "<c:url value="/comment/delete"/>",   
				type : 'post', 
				data : {co_num : co_num}, 
				success : function (data){
					if(data){
						alert("댓글을 삭제했습니다.");
						getCommentList(cri);
					}else{
						alert("댓글을 삭제하지 못했습니다.");
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
	
	<!-- 답글 클릭 이벤트 -->
	<script type="text/javascript">
		$(document).off("click", ".btn-reply");
		$(document).on("click", ".btn-reply", function(e){
			let co_num = $(this).data("num");
			//답글 입력창 생겼으면 추가하지 않음
			if($(this).parent().next().length != 0){
				return;
			}
			let str = `
				<form class="input-group mb-3 insert-form reply mt-2" action="<c:url value="/comment/insert"/>" method="post">
					<input type="hidden" name="co_ori_num" value="\${co_num}">
					<input type="hidden" name="co_po_num" value="${pm.cri.search}">
				    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
				    <button class="btn btn-outline-primary"> 답글 등록</button>
				</form>
			`
			$(this).parent().after(str);
		});
	</script>

	<!-- 댓글/답글 등록 이벤트 -->
	<script type="text/javascript">
		$(document).off("submit", ".insert-form");
		$(document).on("submit", ".insert-form", function(e){
			e.preventDefault();
			
			if('${user.me_id}' == ''){
				if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return false;
			}
			let $obj = $(this).find("[name=co_content]");
			let content = $obj.val().trim();
			if(content == ''){
				alert("댓글을 입력하세요.");
				$obj.focus();
				return false;
			}
			let co_ori_num = $(this).find("[name=co_ori_num]").val();
			let co_po_num = $(this).find("[name=co_po_num]").val();
			let co_content = $(this).find("[name=co_content]").val();
			
			let obj = {
				co_po_num : co_po_num,
				co_content : co_content,
				co_ori_num : co_ori_num == 'undefined' ? 0 : co_ori_num
			}
			console.log(obj);
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
						getCommentList(cri);
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