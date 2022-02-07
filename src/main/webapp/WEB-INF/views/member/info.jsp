<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<form action="member.update" method="post" name="myForm" onsubmit="return membercall()">
		<div>
			아이디 <input readonly="readonly" value="${sessionScope.loginMember.id}" name="id">
		</div>
		<div>
			비밀번호 <input value="${sessionScope.loginMember.pw}" name="pw" type="password">
		</div>
		<div>
			비밀번호 확인
			<input name="pw1" type="password">
		</div>
		<div>
			이름 <input value="${sessionScope.loginMember.name}" name="name" >
		</div>
		<div>
			휴대전화번호<br>
			<c:choose>
				<c:when test="${fn:substring(sessionScope.loginMember.phonenumber, 0, 3) eq '010'}">
					<select name="phonefirst">
		   				<option value="010" selected>010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.loginMember.phonenumber, 0, 3) eq '011'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011" selected>011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.loginMember.phonenumber, 0, 3) eq '016'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016" selected>016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.loginMember.phonenumber, 0, 3) eq '017'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017" selected>017</option>
		   				<option value="018">018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:when test="${fn:substring(sessionScope.loginMember.phonenumber, 0, 3) eq '018'}">
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018" selected>018</option>
		   				<option value="019">019</option>
					</select>
				</c:when>
				<c:otherwise>
					<select name="phonefirst">
		   				<option value="010">010</option>
		   				<option value="011">011</option>
		   				<option value="016">016</option>
		   				<option value="017">017</option>
		   				<option value="018">018</option>
		   				<option value="019" selected>019</option>
					</select>
				</c:otherwise>
			</c:choose>					
			-
			<input name="phonesecond"class="phonenumber" maxlength='4' value="<c:out value="${fn:substring(loginMember.phonenumber, 3, 7)}"></c:out>">
			-
			<input name="phonethird"class="phonenumber" maxlength='4' value="<c:out value="${fn:substring(loginMember.phonenumber, 7, 11)}"></c:out>">
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








