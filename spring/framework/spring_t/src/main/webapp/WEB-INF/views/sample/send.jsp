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
	<h1>전송 확인</h1>
	<!-- 
	서버에서 객체로 보낸 경우 객체명.필드명으로 호출하는데, 이 때 실제 필드를 가져오는 것이 아니라 getter를 호출 -->
	<p>${person.name}의 나이 : ${person.age }</p>
	<p>${person.getName()}의 나이 : ${person.getAge()}</p>
	<p>${person.total}</p>
	<p>${person}</p>
</body>
</html>