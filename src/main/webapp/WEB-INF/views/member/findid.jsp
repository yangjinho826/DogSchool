<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="mempty">
	<h1 id="mtitle">아이디 찾기 결과</h1>
	
	<div id="memberh3">
		<span class="box int_"> ${result1} </span>
	</div>
	
	<div class="btn_area">
		<button id="btnJoin" onClick="location.href='HC.go'">홈으로</button>
		<br>
		<button id="btnJoin" onClick="location.href='member.findpwgo'">비밀번호 찾기</button>
	</div>
</div>
</body>
</html>