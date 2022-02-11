<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 id="mtitle"> 비밀번호 찾기 </h1>
		<form action="member.findpw" method="post" name="myForm" onsubmit="return findpwcall()">
			
			<div id="memberh3">
				<h2>아이디</h2>
				<span class="box int_">
				<input name="id" class="int" placeholder="아이디">
				</span>
			</div>
			
			<div id="memberh3">
				<h2>이름</h2>
				<span class="box int_">
				<input name="name" class="int" maxlength="5" placeholder="이름">
				</span>
			</div>
			
			<div id="memberh3">
				<h2>핸드폰번호</h2>
				<span class="box int_">
				<input name="phonenumber" class="int" maxlength="11" placeholder="전화번호">
				</span>
			</div>
			
			<div class="btn_area">
				<button id="btnJoin">확인</button>
			</div>
		</form>
</body>
</html>