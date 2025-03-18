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
<a href="<c:url value="?name=abc&age=10"/>">서버로 name과 age 값을 전송</a>
<br>
<a href="<c:url value="/send?name=abc&age=10"/>">서버(/send)로 name과 age 값을 전송</a>

<form action="<c:url value="/send"/>" method="get">
	<h1>form태그를 이용하여 get방식으로 전송</h1>
	<input type="text" name="name" placeholder="이름을 입력하세요.">
	<br>
	<input type="number" name="age" placeholder="나이를 입력하세요.">
	<br>
	<button type="submit">전송</button> 
</form>
<form action="<c:url value="/send"/>" method="post">
	<h1>form태그를 이용하여 post방식으로 전송</h1>
	<input type="text" name="name" placeholder="이름을 입력하세요.">
	<br>
	<input type="number" name="age" placeholder="나이를 입력하세요.">
	<br>
	<button type="submit">전송</button> 
</form>
<h1>url 경로에 데이터 보내기</h1>
<a href="<c:url value="/홍길동/10"/>">url 경로에 데이터 보내기</a>
<h1>redirect 예제</h1>
<a href="<c:url value="/redirect?name=홍길동&age=10"/>">리다이렉트 예제</a>
<h1>forward 예제</h1>
<a href="<c:url value="/forward?name=홍길동&age=10"/>">포워드 예제</a>

<script type="text/javascript">
	let name1 = "${name}";
	console.log(name1);
	/* js 변수 name1을 이용하여 ``안에 변수 값을 넣음
	``안에 변수 값을 넣기 위한 $`{}와 서버에서 보낸 데이터를 사용하기 위한 $`{}과 같기 때문에
	$`{}을 쓰면 서버에서 보낸 데이터를 사용하는 것으로 인식 됨
	=> ``안에 변수를 활용하려면 \$`{}로 활용해야함.
	*/
	let str = `서버에서 보낸 이름은 \${name1}입니다.`;
	console.log(str);
</script>
</body>
</html>
