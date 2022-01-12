<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="acceptHomeArea">
	
		<!-- if 관리자 권한 로그인 시 -->
		<!-- 유치원 수락 대기 목록! -->
		<div class="acceptWaitingList">
			<h2 align="center">수락 대기 목록</h2>
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>유치원 이름</th>
					<th>원장님</th>
					<th>주소</th>
				</tr>
			<c:forEach var="s" items="${schools }">
				<tr>
					<td>${s.da_schoolname }</td>
					<td>${s.da_name }(${s.da_id })</td>
					<td>${s.da_addr }</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		
		
		<!-- if 원장 권한 로그인 시 -->
		<!-- 선생님 수락 대기 목록! -->
		<div class="acceptWaitingList">
			<h2 align="center">수락 대기 목록</h2>
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>선생님</th>
					<th>연락처</th>
					<th>소개</th>
				</tr>
			<c:forEach var="t" items="${teachers }">
				<tr>
					<td>${t.ta_name }(${t.ta_id })</td>
					<td>${t.ta_phonenumber }</td>
					<td>${t.ta_text }</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		
		
		<!-- if 원장 권한 로그인 시 -->
		<!-- 강아지 수락 대기 목록! -->
		<div class="acceptWaitingList">
			<h2 align="center">수락 대기 목록</h2>
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>견주</th>
					<th>강아지 정보</th>
					<th>신청 기간</th>
					<th>희망 선생님</th>
				</tr>
			<c:forEach var="p" items="${pets }">
				<tr>
					<td>${p.ua_id }</td>
					<td><img src="resources/img/${p.ua_img }"><br>${p.ua_name }(${p.ua_gender }, ${p.ua_age }세)</td>
					<td>${p.ua_daterange }</td>
					<td>${p.ua_tname }</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</section>
</body>
</html>