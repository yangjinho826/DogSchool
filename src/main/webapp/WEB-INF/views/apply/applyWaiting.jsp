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
		
		<c:if test="${g.typee eq 3}">
		<!-- if 원장님 권한 로그인 시 -->
		<!-- 유치원 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">나의 신청 내역</h2>
		<div class="acceptWaitingList">
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>유치원 이름</th>
					<th>원장님</th>
					<th>연락처</th>
					<th>주소</th>
					<th class="choice">상태</th>
				</tr>
				<c:forEach var="s" items="${myWaitingSchools }">
				<tr>
					<td><b>${s.da_schoolname }</b></td>
					<td>${s.da_name }<br>(${s.da_id })</td>
					<td>${s.da_phonenumber }</td>
					<td>${s.da_addr }</td>
					<td>
						<c:if test="${s.da_agree eq 1}">승인 완료</c:if>
						<c:if test="${s.da_agree eq 0}">승인 대기 중</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<br><br>
		<h2 id="acceptHomeTitle" align="center">나의 수락 내역</h2>
		<div class="acceptWaitingList">
			<h3 align="center">선생님 목록</h3>
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>구분</th>
					<th>선생님</th>
					<th>연락처</th>
					<th>소개</th>
					<th class="choice">상태</th>
				</tr>
				<c:forEach var="t" items="${myPassTeachers }">
				<tr>
					<td>
						<c:forEach var="s" items="${passSchools }">
						<c:if test="${t.ta_da_no eq s.da_no }"><b>${s.da_schoolname }</b></c:if>
						</c:forEach>
					</td>
					<td>${t.ta_name }(${t.ta_id })<br>(${t.ta_gender })</td>
					<td>${t.ta_phonenumber }</td>
					<td style="max-width:350px;">${t.ta_text }</td>
					<td>
						<c:if test="${t.ta_agree eq 1}">승인 완료</c:if>
						<c:if test="${t.ta_agree eq 0}">승인 대기 중</c:if>
					</td>						
				</tr>
				</c:forEach>
			</table>
		</div>
		<br>
		<div class="acceptWaitingList">
			<h3 align="center">강아지 목록</h3>
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>구분</th>
					<th>견주 ID</th>
					<th>강아지 정보</th>
					<th>신청 기간</th>
					<th>희망 선생님</th>
					<th class="choice">상태</th>
				</tr>
				<c:forEach var="p" items="${myPassPets }">
				<tr>
					<td>
						<c:forEach var="s" items="${passSchools }">
						<c:if test="${p.ua_da_no eq s.da_no }"><b>${s.da_schoolname }</b></c:if>
						</c:forEach>
					</td>
					<td>${p.ua_id }</td>
					<td><img src="resources/img/${p.ua_img }"><br>${p.ua_name }(${p.ua_gender }, ${p.ua_age }세)</td>
					<td>${p.ua_daterange }</td>
					<td>${p.ua_tname }</td>
					<td>
						<c:if test="${p.ua_agree eq 1}">승인 완료</c:if>
						<c:if test="${p.ua_agree eq 0}">승인 대기 중</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		
		<c:if test="${g.typee eq 2}">
		<!-- if 선생님 권한 로그인 시 -->
		<!-- 선생님 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">나의 신청 내역</h2>
		<div class="acceptWaitingList">
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>선생님</th>
					<th>연락처</th>
					<th>소개</th>
					<th class="choice">상태</th>
				</tr>
				<c:forEach var="t" items="${myWaitingTeachers }">
				<tr>
					<td>${t.ta_name }(${t.ta_id })<br>(${t.ta_gender })</td>
					<td>${t.ta_phonenumber }</td>
					<td style="max-width:350px;">${t.ta_text }</td>
					<td>
						<c:if test="${t.ta_agree eq 1}">승인 완료</c:if>
						<c:if test="${t.ta_agree eq 0}">승인 대기 중</c:if>
					</td>						
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>

		<c:if test="${g.typee eq 1}">
		<!-- if 유저 로그인 시 -->
		<!-- 강아지 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">나의 신청 내역</h2>
		<div class="acceptWaitingList">
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>견주 ID</th>
					<th>강아지 정보</th>
					<th>신청 기간</th>
					<th>희망 선생님</th>
					<th class="choice">상태</th>
				</tr>
				<c:forEach var="p" items="${myWaitingPets }">
				<tr>
					<td>${p.ua_id }</td>
					<td><img src="resources/img/${p.ua_img }"><br>${p.ua_name }(${p.ua_gender }, ${p.ua_age }세)</td>
					<td>${p.ua_daterange }</td>
					<td>${p.ua_tname }</td>
					<td>
						<c:if test="${p.ua_agree eq 1}">승인 완료</c:if>
						<c:if test="${p.ua_agree eq 0}">승인 대기 중</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</c:if>
		
		</c:forEach>
</section>
</body>
</html>