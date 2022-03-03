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
	<h1 id="mtitle">회원 정보 수정</h1>
		<form action="member.update" method="post" name="myForm" onsubmit="return membercall()">
			
			<div id="memberh3">
				<h2 id="memberid">아이디</h2>
				<span class="box int_">  
				<input readonly="readonly" class="int" value="${sessionScope.loginMember.id}" name="id">
				</span>
			</div>
			
			<div id="memberh3">
				<h2 id="memberid">비밀번호</h2>
				<span class="box int_">  
				<input value="${sessionScope.loginMember.pw}" id="pw" name="pw" class="int" type="password" maxlength="15">
				</span>
			</div>
			
			<div id="memberh3">
				<h2 id="memberid">비밀번호 확인</h2>
				<span class="box int_">  
				<input id="pw1" name="pw1" type="password" maxlength="15" class="int">
				</span>
				<br>
				<span id = "pwcheck" class="pwcheck"></span>
			</div>
			
			<div id="memberh3">
				<h2 id="memberid">이름</h2> 
				<span class="box int_">  
				<input value="${sessionScope.loginMember.name}" name="name" class="int" maxlength="10">
				</span>
			</div>
			
			<div id="memberh3">
				<h2 id="memberid">휴대전화번호</h2>
				<span class="box int_">  
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
				<input name="phonesecond"  maxlength='4' value="<c:out value="${fn:substring(loginMember.phonenumber, 3, 7)}"></c:out>">
				-
				<input name="phonethird"  maxlength='4' value="<c:out value="${fn:substring(loginMember.phonenumber, 7, 11)}"></c:out>">
				</span>
			</div>
			
			<div id="memberh3">
				<h2 id="memberid">성 별</h2> 
				<span class="box int_">  
					남<input name="gender" type="radio" checked="checked" value="man">
					여<input name="gender" type="radio" value="woman">
				</span>
			</div>
			<input name="typee" value ="${sessionScope.loginMember.typee}" hidden="hidden">
			<div class="btn_area">
				<button id="btnJoin" >수정</button><br>
				<button id="btnJoin" onclick="bye();" type="button">탈퇴</button>
			</div>
		</form>
</body>
</html>








