<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
	<script type="text/javascript">
		alert('${msg}');
		location.href = "<c:url value="${url}"/>";
	</script>
</body>
</html>
