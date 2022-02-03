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
		<c:forEach var="g" items="${getTypee }">
		
		<c:if test="${g.typee eq 0}">
		<!-- if 관리자 권한 로그인 시 -->
		<!-- 유치원 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">유치원 수락 대기 목록</h2>
		<c:choose>
			<c:when test="${empty schools}">
			    <div class="acceptWaitingList">
					<table border="1" style="border-collapse: collapse;" id="acceptTbl">
						<tr><th>신청 내역 없음</th></tr>
					</table>
				</div>
			</c:when>
		 	<c:otherwise>
				<div class="acceptWaitingList">
					<table border="1" style="border-collapse: collapse;" id="acceptTbl">
						<tr>
							<th>유치원 이름</th>
							<th>원장님</th>
							<th>연락처</th>
							<th>주소</th>
							<th class="choice" colspan="2">선택</th>
						</tr>
						<c:forEach var="s" items="${schools }">
						<tr>
							<td>${s.da_schoolname }</td>
							<td>${s.da_name }<br>(${s.da_id })</td>
							<td>${s.da_phonenumber }</td>
							<td>${s.da_addr }</td>
							<td style="width:80px;"><button onclick="passSchool(${s.da_no})">수락</button></td>
							<td style="width:80px;"><button onclick="failSchool(${s.da_no})">거절</button></td>
						</tr>
						</c:forEach>
					</table>
				</div>
		    </c:otherwise>
		</c:choose>
		</c:if>
		
		<c:if test="${g.typee eq 3}">
		<!-- if 원장 권한 로그인 시 -->
		<!-- 선생님 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">선생님 수락 대기 목록</h2>
		<c:choose>
			<c:when test="${empty teachers}">
				<div class="acceptWaitingList">
					<table border="1" style="border-collapse: collapse;" id="acceptTbl">
						<tr><th>신청 내역 없음</th></tr>
					</table>
				</div>
			</c:when>
		 	<c:otherwise>
				<div class="acceptWaitingList">
					<table border="1" style="border-collapse: collapse;" id="acceptTbl">
						<tr>
							<th>선생님</th>
							<th>연락처</th>
							<th>소개</th>
							<th colspan="2">선택</th>
						</tr>
					<c:forEach var="t" items="${teachers }">
						<tr>
							<td>${t.ta_name }(${t.ta_id })<br>(${t.ta_gender })</td>
							<td>${t.ta_phonenumber }</td>
							<td style="max-width:350px;">${t.ta_text }</td>
							<td style="width:80px;"><button onclick="passTeacher(${t.ta_no})">수락</button></td>
							<td style="width:80px;"><button onclick="failTeacher(${t.ta_no})">거절</button></td>
						</tr>
					</c:forEach>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<br>
		
		<!-- 강아지 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">강아지 수락 대기 목록</h2>
		<c:choose>
			<c:when test="${empty pets}">
				<div class="acceptWaitingList">
					<table border="1" style="border-collapse: collapse;" id="acceptTbl">
						<tr><th>신청 내역 없음</th></tr>
					</table>
				</div>
			</c:when>
		 	<c:otherwise>
				<div class="acceptWaitingList">
					<table border="1" style="border-collapse: collapse;" id="acceptTbl">
						<tr>
							<th>견주 ID</th>
							<th>강아지 정보</th>
							<th>신청 기간</th>
							<th>희망 선생님</th>
							<th class="choice" colspan="2">선택</th>
						</tr>
					<c:forEach var="p" items="${pets }">
						<tr>
							<td>${p.ua_id }</td>
							<td><img src="resources/img/${p.ua_img }"><br>${p.ua_name }(${p.ua_gender }, ${p.ua_age }세)</td>
							<td>${p.ua_daterange }</td>
							<td>${p.ua_tname }</td>
							<td style="width:80px;"><button onclick="passPet(${p.ua_no})">수락</button></td>
							<td style="width:80px;"><button onclick="failPet(${p.ua_no})">거절</button></td>
						</tr>
					</c:forEach>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		</c:if>
		</c:forEach>
</section>
</body>
</html>