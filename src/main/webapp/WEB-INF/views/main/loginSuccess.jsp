<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			
			<c:forEach var="gg" items="${getTypee }">
			
			<!-- 1: 유저 -->
			<c:if test="${gg.typee eq 1}">
			<button onClick="location.href='apply.go'" class="member_info_btn">신청하기</button>
			<button onClick="location.href='apply.waiting'" class="member_info_btn">신청 내역</button>
			</c:if>
			
			<!-- 2: 선생님 -->
			<c:if test="${gg.typee eq 2}">
			<button onClick="location.href='apply.go'" class="member_info_btn">신청하기</button>
			<button onClick="location.href='apply.waiting'" class="member_info_btn">신청 내역</button>			
			</c:if>
			
			<!-- 3: 원장 -->
			<c:if test="${gg.typee eq 3}">
			<button onClick="location.href='apply.go'" class="member_info_btn">신청하기</button>
			<button onClick="location.href='accept.go'" class="member_info_btn">수락하기</button>
			<button onClick="location.href='apply.waiting'" class="member_info_btn">신청・수락 내역</button>			
			</c:if>
			
			<!-- 0: 관리자 -->
			<c:if test="${gg.typee eq 0}">
			<button onClick="location.href='accept.go'" class="member_info_btn">수락하기</button>
			<button onClick="location.href='manage.go'" class="member_info_btn">관리하기</button>
			</c:if>
			
			</c:forEach>

			<!-- 강아지목록 -->
			<button onClick="location.href='yuchiwon.get.allpuppy?id=${sessionScope.loginMember.id}&typee=${sessionScope.loginMember.typee}'" class="member_info_btn">강아지 목록</button>
		</div>
	</section>
</body>
</html>