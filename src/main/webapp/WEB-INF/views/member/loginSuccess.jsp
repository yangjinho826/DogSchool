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
<section id="member" >
		<div  class="member_info">
			${sessionScope.loginMember.id} 
			<button class="member_info_btn" onclick="Memberinfo()"> 내 정보 </button>	
			<button class="member_info_btn" onclick="logout()"> 로그아웃 </button>	
		</div>
	</section>
</body>
</html>