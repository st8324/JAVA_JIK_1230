<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 
서버에서 보낸 데이터를 처리할 때는 $`{화면에서사용할이름}을 이용하여 활용
- 단 주석에서도 인식 되기 때문에 주석에서 조심히 작성. ${name}
 -->
<P>  서버에서 보낸 제 이름은 ${name}입니다. </P>
</body>
</html>
