<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 아이디 찾기 </h3>
	<form action="member.findid" method="post" name="myForm" onsubmit="return findidcall()">
		<div>
			이름 <input name="name" maxlength="10"> <br>
		</div>
		<div>
			휴대전화번호 <input name="phonenumber"> <br>
		</div>
		<button>확인</button>
	</form>
</body>
</html>