<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="member" >
		<div>
			<button onclick="location.href='HC.go'" class="member_info_btn">홈페이지</button>
		</div>
		<div  class="member_info">
		<form action="member.login" method="post" name="loginForm" onsubmit="return logincall()">
		${result }
       		<input name="id" placeholder="아이디" autocomplete="off">
            <input name="pw" placeholder="비밀번호" type="password" autocomplete="off">
            <button class="member_info_btn">로그인</button>
            <div class="member_singup">
            	<button class="member_info_btn" type="button">회원가입</button>
            	<div class="member_singup_kind">
	            	<button type="button" onclick="signupgo(1)" >견주 회원가입</button>
					<button type="button" onclick="signupgo(2)" >선생님 회원가입</button>
					<button type="button" onclick="signupgo(3)" >원장 회원가입</button>
				</div>
			</div>
            <button class="member_info_btn" type="button" onclick="findidgo()">아이디 찾기</button>
            <button class="member_info_btn" type="button" onclick="findpwgo()">비밀번호 찾기</button>
		</form>
		</div>
		
		
				
	</section>
</body>
</html>