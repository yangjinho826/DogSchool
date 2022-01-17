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
			아이디 <input name="u_id">
		</div>
		<div>
			비밀번호 <input name="u_pw" type="password">
		</div>
		<div>
			이름 <input name="u_name">
		</div>
		<div>
			휴대전화번호<input name="u_phonenumber">
		</div>
		<div>
			성 별 <br>남<input name="u_gender" type="radio" checked="checked" value="man">
				 여<input name="u_gender" type="radio" value="woman">
		</div>
			<button>가입</button>
	</form>

</body>
</html>