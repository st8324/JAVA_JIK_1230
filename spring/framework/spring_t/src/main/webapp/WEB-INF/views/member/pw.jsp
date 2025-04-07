<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.fixed{ position: fixed; top:0; bottom: 0; left: 0; right: 0; display: none}
	.bg-dark2{ background: rgba(0,0,0,0.3)}
	.all{ position: absolute; top:0; bottom: 0; left: 0; right: 0}
	.fixed .spinner{ margin-left : calc(50vw - 25px); margin-top : calc(50vh - 25px) }
</style>
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
	<div class="fixed">
		<div class="bg-dark2 all"></div>
		<div class="spinner spinner-border text-info"></div>
	</div>
	<script type="text/javascript">
		$(".btn-find-pw").click(function(e){
			$(".fixed").show();
			$.ajax({
				async : true,
				url : '<c:url value="/find/pw"/>',
				method : "post",
				data : { id : $("#id").val() },
				success : function(data){
					$(".fixed").hide();
					if(data){
						alert("새 비번을 메일로 전송했습니다.");
					}else{
						alert("정보가 일치하지 않아 비밀번호를 찾을 수 없습니다.")
					}
				}
			});
		});
	
		
	</script>
</body>
</html>