<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.usignup" method="post" name="myForm" onsubmit="return membercall()">
		<div>
			아이디 <input id="id_Input" name="id" placeholder="필수, 영어/숫자만" maxlength="20" autocomplete="off">
			<input id="id2" name="id2" value="0" type="hidden">
			<span id = "idcheck"></span>
		</div>
		<div>
			비밀번호 <input name="pw" type="password" placeholder="필수, 영어/숫자만" maxlength="20" autocomplete="off">
		</div>
		<div>
			비밀번호 확인
			<input name="pw1" type="password" placeholder="필수, 영어/숫자만" maxlength="20" autocomplete="off">
		</div>
		<div>
			이름 <input name="name" placeholder="필수" maxlength="20" autocomplete="off">
		</div>
		<div>
			휴대전화번호<br>
            <select name="phonefirst">
                   <option value="010">010</option>
                   <option value="011">011</option>
                   <option value="016">016</option>
                   <option value="017">017</option>
                   <option value="018">018</option>
                   <option value="019">019</option>
            </select>
            - <input name="phonesecond"class="phonenumber" maxlength='4' style="widh:50px;" placeholder="4자리 숫자만">
            - <input name="phonethird"class="phonenumber" maxlength='4' style="widh:50px;"placeholder="4자리 숫자만">
		</div>
		<div>
			성 별 <br>남<input name="gender" type="radio" checked="checked" value="man">
				 여<input name="gender" type="radio" value="woman">
		</div>
			<button name="type" type="submit" value="${param.type}">가입</button>
	</form>

</body>
</html>