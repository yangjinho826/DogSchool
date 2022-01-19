<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<form action="member.update" method="post">
		<div>
			아이디
			<input value="${sessionScope.loginMember.id} " name="id" readonly="readonly">
		</div>
		<div>
			비밀번호 
			<input value="${sessionScope.loginMember.pw}" name="pw" placeholder="필수, 숫자 하나이상 반드시" type="password" maxlength="10" autocomplete="off">
		</div>
		<div>
			이름 
			<input value="${sessionScope.loginMember.name}" name="name" placeholder="필수" maxlength="10" autocomplete="off">
			
		</div>
		<div>
			휴대전화번호
			<input value="${sessionScope.loginMember.phonenumber}" name="phonenumber" placeholder="필수" maxlength="10" autocomplete="off">
		</div>
		<div>
			성 별 
			<br>남<input value="${sessionScope.loginMember.gender}" name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>
	
		<button>수정</button>
		<button onclick="bye();" type="button">탈퇴</button>
	
	</form>
</body>
</html>








