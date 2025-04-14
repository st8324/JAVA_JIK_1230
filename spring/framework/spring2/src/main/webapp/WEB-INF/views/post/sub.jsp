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
		<div class="form-group ">
			<div class="form-control input-group" style="min-height: auto; height: auto">
				<img width="100" height="120" src="https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp">
				<div class="ml-3">
					<div>${post.po_title }</div>
					<div>작성자 : ${post.po_me_id }</div>
					<div>작성일 : <fmt:formatDate pattern="yyyy.MM.dd" value="${post.po_date }"/></div>
					<div>조회수 : ${post.po_view }</div>
					<div>추천수 : ${post.po_up }</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<c:if test="${list.size() eq 0 }">
		<div class="form-control text-center">등록된 게시글이 없습니다.</div>
	</c:if>
</body>
</html>
