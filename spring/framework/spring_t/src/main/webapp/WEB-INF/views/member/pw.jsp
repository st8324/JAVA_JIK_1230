<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div>
		<h1>비번찾기</h1>
		<div class="form-group mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id">
		</div>
		<button type="button" class="btn-find-pw btn btn-outline-success mt-3 col-12">비번 찾기</button>
	</div>
	<script type="text/javascript">
		$(".btn-find-pw").click(function(e){
			$.ajax({
				async : true,
				url : '<c:url value="/find/pw"/>',
				method : "post",
				data : { id : $("#id").val() },
				success : function(data){
					console.log(data);	
				}
			});
		});
	
		
	</script>
</body>
</html>