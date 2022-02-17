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
							<td>${s.dA_schoolname }</td>
							<td>${s.dA_name }<br>(${s.dA_id })</td>
							<td>${s.dA_phonenumber }</td>
							<td>${s.dA_addr }</td>
							<td style="width:80px;"><button onclick="passSchool(${s.dA_no})">수락</button></td>
							<td style="width:80px;"><button onclick="failSchool(${s.dA_no})">거절</button></td>
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
							<th>유치원 구분</th>
							<th>선생님</th>
							<th>연락처</th>
							<th>소개</th>
							<th colspan="2">선택</th>
						</tr>
					<c:forEach var="t" items="${teachers }">
						<tr>
							<td>
								<c:forEach var="s" items="${passSchools }">
								<c:if test="${t.tA_da_no eq s.dA_no }">${s.dA_schoolname }</c:if>
								</c:forEach>
							</td>
							<td>${t.tA_name }(${t.tA_id })<br>(${t.tA_gender })</td>
							<td>${t.tA_phonenumber }</td>
							<td style="max-width:350px;">${t.tA_text }</td>
							<td style="width:80px;"><button onclick="passTeacher(${t.tA_no})">수락</button></td>
							<td style="width:80px;"><button onclick="failTeacher(${t.tA_no})">거절</button></td>
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
							<th>유치원 구분</th>
							<th>견주 ID</th>
							<th>강아지 정보</th>
							<th>신청 기간</th>
							<th>희망 선생님</th>
							<th class="choice" colspan="2">선택</th>
						</tr>
					<c:forEach var="p" items="${pets }">
						<tr>
							<td>
								<c:forEach var="s" items="${passSchools }">
								<c:if test="${p.uA_da_no eq s.dA_no }">${s.dA_schoolname }</c:if>
								</c:forEach>
							</td>
							<td>${p.uA_id }</td>
							<td><img src="resources/img/${p.uA_img }"><br>${p.uA_name }(${p.uA_gender }, ${p.uA_age }세)</td>
							<td>${p.uA_daterange }</td>
							<td>
								<c:forEach var="t" items="${passTeachers }">
								<c:if test="${p.uA_ta_no eq t.tA_no }">${t.tA_name }(${t.tA_id }, ${t.tA_gender })</c:if>
								</c:forEach>
							</td>
							<td style="width:80px;"><button onclick="passPet(${p.uA_no})">수락</button></td>
							<td style="width:80px;"><button onclick="failPet(${p.uA_no})">거절</button></td>
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