<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<hr>
	<h1>c:forTokens 예제</h1>
	<ul>
		<c:forTokens items="${'사과,바나나,포도,오렌지'}" delims="," var="token" varStatus="vs">
			<li>${vs.count}. ${token}</li>
		</c:forTokens>
	</ul>
	<h1>c:url 예제</h1> 
	<c:url var="url" value="/send" >
		<c:param name="name" value="abc"/>
		<c:param name="age" value="20"/>
	</c:url>
	<p>${url}</p>
	<hr>
	<h1>fmt:formatNumber 예제</h1>
	<fmt:formatNumber value="10000" type="currency"/>
	<!-- 서버 로컬 정보가 한국으로 되어 있어서 아래 setLocale이 반영된지 않음. -->
	<fmt:setLocale value="en_us"/>
	<fmt:formatNumber value="10000" type="currency"/>
	
	<fmt:setLocale value="ja_jp"/>
	<fmt:formatNumber value="10000" type="currency"/>
	
	<h1>fmt:formatDate</h1>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd EE요일"/>
	<br>
	${date }
</body>
</html>