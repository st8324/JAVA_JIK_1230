<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="mt-5 mb-5">
		<a class="btn btn<c:if test="${pm.cri.po_bo_num ne 0 }">-outline</c:if>-success" href="<c:url value="/post/list?po_bo_num=0"/>">전체</a>
		<c:forEach items="${boardList}" var="board">
			<a class="btn btn<c:if test="${pm.cri.po_bo_num ne board.bo_num }">-outline</c:if>-success" href="<c:url value="/post/list?po_bo_num=${board.bo_num}"/>">${board.bo_name }</a>
		</c:forEach>
	</div>

	<h1>게시글 리스트</h1>
	<!-- 서버에서 보낸 게시글 목록을 출력 -->
	<table class="table table-hover table-warning">
		<thead>
			<tr>
				<th>번호</th>
				
				<th>게시판</th>
				
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="post">
				<tr>
					<td>${post.po_num}</td>
					
					<td>${post.po_bo_name}</td>
					
					<td>
						<a href="<c:url value="/post/detail/${post.po_num}"/>">${post.po_title }</a>
					</td>
					<td>${post.po_me_id }</td>
					<td><fmt:formatDate value="${post.po_date }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td>${post.po_view }</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0 }">
				<tr>
					<th colspan="5">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<form action="<c:url value="/post/list"/>">
		<input type="hidden" name="po_bo_num" value="${pm.cri.po_bo_num}">
		<div class="input-group mb-3">
			<select class="form-control" name="type">
				<option value="0" <c:if test="${pm.cri.type == '0' }">selected</c:if>>전체</option>
				<option value="1" <c:if test="${pm.cri.type == '1' }">selected</c:if>>제목+내용</option>
				<option value="2" <c:if test="${pm.cri.type == '2' }">selected</c:if>>작성자</option>
			</select>
		    <input type="text" class="form-control" placeholder="검색어를 입력하세요." name="search" value="${pm.cri.search }">
		    <button type="submit" class="form-control btn btn-outline-success">검색</button>
		</div>
	</form>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<c:url var="url" value="/post/list">
				<c:param name="po_bo_num" value="${pm.cri.po_bo_num }" />
				<c:param name="search" value="${pm.cri.search }" />
				<c:param name="type" value="${pm.cri.type }" />
				<c:param name="page" value="${pm.startPage-1}" />
			</c:url>
			<li class="page-item">
				<a class="page-link" href="${url}">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
			<c:url var="url" value="/post/list">
				<c:param name="po_bo_num" value="${pm.cri.po_bo_num }" />
				<c:param name="search" value="${pm.cri.search }" />
				<c:param name="type" value="${pm.cri.type }" />
				<c:param name="page" value="${i}" />
			</c:url>
			
			<li class="page-item <c:if test="${pm.cri.page == i }">active</c:if>">
				<a class="page-link" href="${url}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<c:url var="url" value="/post/list">
				<c:param name="po_bo_num" value="${pm.cri.po_bo_num }" />
				<c:param name="search" value="${pm.cri.search }" />
				<c:param name="type" value="${pm.cri.type }" />
				<c:param name="page" value="${pm.endPage+1}" />
			</c:url>
			<li class="page-item">
				<a class="page-link" href="${url}">다음</a>
			</li>
		</c:if>
	</ul>
	<a href="<c:url value="/post/insert"/>" class="btn btn-outline-success btn-insert">게시글 등록</a>
	<script type="text/javascript">
		$(".btn-insert").click(function(e){
			//로그인 했으면
			if(${user != null}){
				return;
			}
			e.preventDefault();
			//안했으면
			if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?")){
				location.href = "<c:url value="/login"/>";
				
			}
		})
		
	</script>
</body>
</html>
