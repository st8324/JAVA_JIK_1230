<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="<c:url value="/signup"/>" method="post">
		<h1>회원 가입</h1>
		<div class="form-group mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<button type="button" class="btn btn-outline-success col-12" id="check">아이디 중복 확인</button>
		<div class="form-group mt-3">
			<label for="pw" class="form-label">비번</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group mt-3">
			<label for="pw2" class="form-label">비번 확인</label>
			<input type="password" class="form-control" id="pw2">
		</div>
		<div class="form-group mt-3">
			<label for="email" class="form-label">이메일</label>
			<input type="email" class="form-control" id="email" name="me_email">
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">회원가입</button>
	</form>
	<script type="text/javascript">
		$("#check").click(function(e){
			if(checkId()){
				alert("사용 가능한 아이디입니다.");
			}else{
				alert("이미 사용중인 아이디입니다.");
			}
		});
		function checkId(){
			//입력한 아이디를 가져옴
			let id = $("#id").val();
			//정규 표현식에 맞지 않으면 알림창 리턴 후 종료
			
			let res = false;
			//비동기 통신으로 아이디를 전송하고, 서버에서 보낸 결과를 이용하여 처리
			$.ajax({
				async : false, 
				url : '<c:url value="/check/id"/>', 
				type : 'post', 
				data : { id : id }, 
				success : function (data){
					if(data){
						res = true;	
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			return res;
		}
	</script>
</body>
</html>