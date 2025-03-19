<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value="/" />">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/post/list"/>">게시글 목록</a>
        </li>
        <c:if test="${user == null}">
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/signup"/>">회원 가입</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
	        </li>  
        </c:if>
        <c:if test="${user != null }">
        	<li class="nav-item">
	          <a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
	        </li>
	    </c:if>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">예제</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<c:url value="/example" />">데이터 전송 예제</a></li>
            <li><a class="dropdown-item" href="<c:url value="/jstl" />">JSTL 예제</a></li>
          </ul>
        </li>
        <c:if test="${user ne null && user.me_authority eq 'ADMIN' }">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">관리자</a>
	          <ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="<c:url value="/admin/board" />">게시판</a></li>
	          </ul>
	        </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>