<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 id="mtitle">아이디 찾기</h1>
			<form action="member.findid" method="post" name="myForm" onsubmit="return findidcall()">
				
				<div id="memberh3">
					<h2 id="memberid">이름</h2>
					<span class="box int_"> 
					<input type="text"  name="name"class="int" maxlength="5" placeholder="이름">
					</span>
				</div>
				<br>
				
				<div id="memberh3">
					<h2 id="memberid">핸드폰번호</h2>
					<span class="box int_"> 
					<input name="phonenumber"  class="int" maxlength="11" placeholder="전화번호">
					</span>
				</div>
				<br>

				<div class="btn_area">
					<button id="btnJoin">확인</button>
				</div>
				
			</form>
</body>
</html>