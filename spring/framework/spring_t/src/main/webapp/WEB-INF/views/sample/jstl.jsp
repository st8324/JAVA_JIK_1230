<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 예제</h1>
	<c:set var="name" value="홍길동" />
	<p>제 이름은 ${name}입니다.</p>
	${str}
	<c:out value="${str}"/>
	<br>
	<c:if test="${age >= 20 }">
		<h3>성인입니다.</h3>
	</c:if>
	<!-- {}안에서 공백이 몇개 들어가도 상관없지만, "와 $사이에 공백이 들어가면 정상적으로 동작하지 않음 -->
	<c:if test="${age <    20 }">
		<h3>성인이 아닙니다.</h3>
	</c:if>
	<c:choose>
		<c:when test="${age >= 20 }">
			<h3>성인입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>성인이 아닙니다.</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<h1>c:forEach 예제</h1>
	<!-- 1부터 5까지 출력하는 예제 -->
	<c:forEach begin="1" end="5" var="i" step="2">
		<b>${i}</b>
	</c:forEach>
	<hr>
	<ul>
		<c:forEach items="${list}" var="fruit" varStatus="vs">
			<li>
				${vs.count}.${fruit} ${vs.index}
				<c:if test="${vs.first}">New</c:if>
				<c:if test="${vs.last}">Old</c:if>
			</li>
		</c:forEach>
	</ul>
</body>
</html>