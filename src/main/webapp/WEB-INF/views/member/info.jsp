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
			아이디 <input readonly="readonly" value="${sessionScope.loginMember.id}" name="id">
		</div>
		<div>
			비밀번호 <input value="${sessionScope.loginMember.pw}" name="pw" type="password">
		</div>
		<div>
			비밀번호확인 <input value="${sessionScope.loginMember.pw}" name="pw" type="password">
		</div>
		<div>
			이름 <input value="${sessionScope.loginMember.name}" name="name" >
		</div>
		<div>
			휴대전화번호
            <select name="phonefirst" >
                   <option value="010">010</option>
                   <option value="011">011</option>
                   <option value="016">016</option>
                   <option value="017">017</option>
                   <option value="018">018</option>
                   <option value="019">019</option>
            </select>
            - <input value="${sessionScope.loginMember.phonenumber}" name="phonesecond"class="phonenumber" maxlength='4' style="width:50px;">
            - <input value="${sessionScope.loginMember.phonenumber}" name="phonethird"class="phonenumber" maxlength='4' style="width:50px;">

		</div>
		<div>
			성 별 <br>남<input name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>
			<button name="type" value="${param.type}" type="hidden"></button>
			<button>수정</button>
			<button onclick="bye();" type="button">탈퇴</button>
	</form>
</body>
</html>








