<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/member.js"></script>
</head>
<body>
	<form action="member.usignup" method="post">
		<div>
			아이디 <input name="id" placeholder="필수, 영어/숫자만" maxlength="20" autocomplete="off">
		</div>
		<div>
			비밀번호 <input name="pw" type="password" placeholder="필수, 영어/숫자만" maxlength="20" autocomplete="off">
		</div>
		<div>
			이름 <input name="name" placeholder="필수" maxlength="20" autocomplete="off">
		</div>
		<div>
			휴대전화번호<input name="phonenumber" placeholder="필수, 숫자만" maxlength="20" autocomplete="off">
		</div>
		<div>
			성 별 <br>남<input name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>
			<button name="type" value="${param.type}">가입</button>
	</form>

</body>
</html>