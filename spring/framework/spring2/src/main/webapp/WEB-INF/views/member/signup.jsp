<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<style type="text/css">
		.error,.red{ color : red; }
		.green{ color : green; }
	</style>
</head>
<body>
	<form action="<c:url value="/signup"/>" method="post">
		<h1>회원 가입</h1>
		<div class="form-group mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id" name="me_id">
			<label id="checkId" class="red"></label>
		</div>
		<div class="form-group mt-3">
			<label for="pw" class="form-label">비번</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group mt-3">
			<label for="pw2" class="form-label">비번 확인</label>
			<input type="password" class="form-control" id="pw2" name="me_pw2">
		</div>
		<div class="form-group mt-3">
			<label for="email" class="form-label">이메일</label>
			<input type="email" class="form-control" id="email" name="me_email">
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">회원가입</button>
	</form>
	<script type="text/javascript">
	
		$("#id").on("input",function(e){
			//checkId();
		});
		function checkId(){
			//입력한 아이디를 가져옴
			$("#checkId").text("");
			let id = $("#id").val();

			if(!/^[a-zA-Z0-9]{3,13}$/.test(id)){
				return false;
			}
			
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
			let str;
			if(res){
				str = "사용 가능한 아이디입니다.";
				$("#checkId").addClass("green");
				$("#checkId").removeClass("red");
			}else{
				str = "이미 사용중인 아이디입니다.";
				$("#checkId").addClass("red");
				$("#checkId").removeClass("green");
			}
			$("#checkId").text(str);
			return res;
		}
		
		$("form").validate({
			rules : {
				me_id : {
					required : true,
					regex : /^[a-zA-Z0-9]{3,13}$/
				},
				me_pw : {
					required : true,
					regex : /^[a-zA-Z0-9!@#$]{3,15}$/
				},
				me_pw2 : {
					equalTo : pw
				},
				me_email : {
					required : true,
					email : true
				}
			},
			messages : {
				me_id : {
					required : "필수 항목입니다.",
					regex : "아이디는 영문, 숫자만 가능하며, 3~13자입니다."
				},
				me_pw : {
					required : "필수 항목입니다.",
					regex : "비번은 영문, 숫자,특수문자(!@#$)만 가능하며, 3~15자입니다."
				},
				me_pw2 : {
					equalTo : "비번과 비번확인이 일치하지 않습니다."
				},
				me_email : {
					required : "필수 항목입니다.",
					email : "이메일 형식이 아닙니다."
				}
			},
			//유효성 검사 체크 후 전송하기 직전에 확인하고 싶을 때 사용. return true 전송
			submitHandler : function(){
				return true; //checkId();
			}
		})
		$.validator.addMethod("regex", function(value, element, regex){
			var re = new RegExp(regex);
			return this.optional(element) || re.test(value);
		}, "정규표현식을 확인하세요.");
	</script>
</body>
</html>