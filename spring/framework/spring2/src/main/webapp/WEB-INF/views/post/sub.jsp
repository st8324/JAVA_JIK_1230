<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<!-- 서버에서 보낸 게시글 목록을 이용하여 화면을 구성. 이미지는 고정 -->
	<c:forEach items="${list}" var="post">
		<a class="form-group " href="<c:url value="/post/detail/${post.po_num}"/>">
			<div class="form-control input-group" style="min-height: auto; height: auto">
				<c:choose>
					<c:when test="${post.po_fi_name ne null }">
						<img width="100" height="120" src="<c:url value="/download${post.po_fi_name }"/>">
					</c:when>
					<c:otherwise>
						<img width="100" height="120" src="<c:url value="/resources/base.png"/>">
					</c:otherwise>
				</c:choose>
				<div class="ml-3">
					<div>${post.po_title }</div>
					<div>작성자 : ${post.po_me_id }</div>
					<div>작성일 : <fmt:formatDate pattern="yyyy.MM.dd" value="${post.po_date }"/></div>
					<div>조회수 : ${post.po_view }</div>
					<div>추천수 : ${post.po_up }</div>
				</div>
			</div>
		</a>
	</c:forEach>
	<c:if test="${list.size() eq 0 }">
		<div class="form-control text-center">등록된 게시글이 없습니다.</div>
	</c:if>
	<!-- 더보기 버튼을 추가 -->
	<c:if test="${pm.next}">
		<button class="btn btn-danger btn-more col-12">더보기</button>
	</c:if>
</body>
</html>
