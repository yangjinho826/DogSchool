<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="member" >
		<div  class="member_info">
			<input placeholder="아이디">
			<input placeholder="비밀번호">
			<button class="member_info_btn">로그인</button>
			<button class="member_info_btn">회원가입</button>	
			<button class="member_info_btn">아이디 찾기</button>	
			<button class="member_info_btn">비밀번호 찾기</button>	
			<!-- 원장, 선생님, 견주만 -->
			<button onClick="location.href='apply.go'" class="member_info_btn">신청하기</button>
			<!-- 관리자, 원장만 -->		
			<button onClick="location.href='accept.go'" class="member_info_btn">수락하기</button>
			<!-- 관리자만! -->
			<button onClick="location.href='manage.go'" class="member_info_btn">유치원 관리</button>
		</div>
	</section>
</body>
</html>