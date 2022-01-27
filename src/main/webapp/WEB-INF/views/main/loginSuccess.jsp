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
		<div>
			<button onclick="location.href='HC.go'" class="member_info_btn">홈페이지</button>
		</div>
		<div  class="member_info">
			${sessionScope.loginMember.id} 
			<button class="member_info_btn" onclick="Memberinfo()"> 내 정보 </button>	
			<button class="member_info_btn" onclick="logout()"> 로그아웃 </button>	
			
				<!-- 원장, 선생님, 견주만 -->
			<button onClick="location.href='apply.go'" class="member_info_btn">신청하기</button>
			<!-- 관리자, 원장만 -->		
			<button onClick="location.href='accept.go'" class="member_info_btn">수락하기</button>
			<!-- 관리자만! -->
			<button onClick="location.href='manage.go'" class="member_info_btn">유치원 관리</button>
			<!-- 강아지목록 -->
			<button onClick="location.href='yuchiwon.get.allpuppy'" class="member_info_btn">강아지 목록</button>
		</div>
	</section>
</body>
</html>