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
		<h2 id="acceptHomeTitle" align="center">신청 내역</h2>
		<div class="acceptWaitingList">
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>유치원 이름</th>
					<th>원장님</th>
					<th>연락처</th>
					<th>주소</th>
					<th class="choice">상태</th>
				</tr>
				<c:choose>
					<c:when test="${empty myWaitingSchools}">
						<tr>
							<td colspan="5">아직 유치원을 신청하지 않았습니다.</td>
						</tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach var="s" items="${myWaitingSchools }">
						<tr>
							<td><b>${s.dA_schoolname }</b></td>
							<td>${s.dA_name }<br>(${s.dA_id })</td>
							<td>${s.dA_phonenumber }</td>
							<td>${s.dA_addr }</td>
							<td>
								<c:if test="${s.dA_agree eq 1}">승인 완료</c:if>
								<c:if test="${s.dA_agree eq 0}">승인 대기 중<br>
									<button id="btnCancel" onClick="applyCancelDa(${s.dA_no})">신청 취소</button>
								</c:if>
							</td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<br><br>
		<h2 id="acceptHomeTitle" align="center">수락 내역</h2>
		<div class="acceptWaitingList">
			<h3 align="center">선생님 목록</h3>
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>구분</th>
					<th>선생님</th>
					<th>연락처</th>
					<th>소개</th>
					<th class="choice">관리</th>
				</tr>
				<c:choose>
					<c:when test="${empty myPassTeachers }">
						<tr>
							<td colspan="5">등록된 선생님이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="t" items="${myPassTeachers }">
						<tr>
							<td>
								<c:forEach var="s" items="${passSchools }">
								<c:if test="${t.tA_da_no eq s.dA_no }"><b>${s.dA_schoolname }</b></c:if>
								</c:forEach>
							</td>
							<td>${t.tA_name }<br>(${t.tA_id }, <c:if test="${t.tA_gender eq 'man'}">남</c:if><c:if test="${t.tA_gender eq 'woman'}">여</c:if>)</td>
							<td>${t.tA_phonenumber }</td>
							<td style="max-width:350px;">${t.tA_text }</td>
							<td>
								<button id="btnCancel" onClick="deleteTeacher(${t.tA_no})">삭제</button>
							</td>						
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
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
					<th>담당 선생님</th>
					<th class="choice">관리</th>
				</tr>
				<c:choose>
					<c:when test="${empty myPassPets }">
						<tr>
							<td colspan="6">등록된 강아지가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="p" items="${myPassPets }">
						<tr>
							<td>
								<c:forEach var="s" items="${passSchools }">
								<c:if test="${p.uA_da_no eq s.dA_no }"><b>${s.dA_schoolname }</b></c:if>
								</c:forEach>
							</td>
							<td>${p.uA_id }</td>
							<td><img src="resources/img/${p.uA_img }"><br>${p.uA_name }(${p.uA_gender }, ${p.uA_age }세)</td>
							<td>${p.uA_daterange }</td>
							<td>
								<c:if test="${p.uA_ta_no eq 0}">선생님 재신청 필요</c:if>
								<c:forEach var="t" items="${passTeachers }">
									<c:if test="${p.uA_ta_no eq t.tA_no }">${t.tA_name}(${t.tA_id }, <c:if test="${t.tA_gender eq 'man'}">남</c:if><c:if test="${t.tA_gender eq 'woman'}">여</c:if>)</c:if>
								</c:forEach>
							</td>
							<td>
								<button id="btnCancel" onClick="deletePet(${p.uA_no})">삭제</button>
							</td>
						</tr>
						</c:forEach>				
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		</c:if>
		
		<c:if test="${g.typee eq 2}">
		<!-- if 선생님 권한 로그인 시 -->
		<!-- 선생님 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">신청 내역</h2>
		<div class="acceptWaitingList">
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>유치원 이름</th>
					<th>선생님</th>
					<th>연락처</th>
					<th>소개</th>
					<th class="choice">상태</th>
				</tr>
				<c:choose>
					<c:when test="${empty myWaitingTeachers }">
						<tr>
							<td colspan="5">아직 유치원에 신청하지 않았습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="t" items="${myWaitingTeachers }">
						<tr>
							<td>
								<c:forEach var="s" items="${passSchools }">
								<c:if test="${t.tA_da_no eq s.dA_no }"><b>${s.dA_schoolname }</b></c:if>
								</c:forEach>
							</td>
							<td>${t.tA_name }<br>(${t.tA_id }, <c:if test="${t.tA_gender eq 'man'}">남</c:if><c:if test="${t.tA_gender eq 'woman'}">여</c:if>)</td>
							<td>${t.tA_phonenumber }</td>
							<td style="max-width:350px;">${t.tA_text }</td>
							<td>
								<c:if test="${t.tA_agree eq 1}">승인 완료</c:if>
								<c:if test="${t.tA_agree eq 0}">승인 대기 중<br>
									<button id="btnCancel" onClick="applyCancelTa(${t.tA_no})">신청 취소</button>
								</c:if>
							</td>						
						</tr>
						</c:forEach>				
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		</c:if>

		<c:if test="${g.typee eq 1}">
		<!-- if 유저 로그인 시 -->
		<!-- 강아지 수락 대기 목록! -->
		<h2 id="acceptHomeTitle" align="center">신청 내역</h2>
		<div class="acceptWaitingList">
			<table border="1" style="border-collapse: collapse;" id="acceptTbl">
				<tr>
					<th>유치원</th>
					<th>견주 ID</th>
					<th>강아지 정보</th>
					<th>신청 기간</th>
					<th>선생님</th>
					<th class="choice">상태</th>
				</tr>
				<c:choose>
					<c:when test="${empty myWaitingPets }">
						<tr><td colspan="6">아직 유치원에 등록하지 않았습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="p" items="${myWaitingPets }">
						<tr>
							<td>
								<c:forEach var="s" items="${passSchools }">
								<c:if test="${p.uA_da_no eq s.dA_no }"><b>${s.dA_schoolname }</b></c:if>
								</c:forEach>
							</td>
							<td>${p.uA_id }</td>
							<td><img src="resources/img/${p.uA_img }"><br>${p.uA_name }(${p.uA_gender }, ${p.uA_age }세)</td>
							<td>
								${p.uA_daterange }<br>
								<c:if test="${p.uA_daterange eq '기간 만료' }">
									<button id="btnCancel" onClick="goWriteReview(${p.uA_da_no }, ${p.uA_no })">후기 작성하기</button>
									<button id="btnCancel" onClick="location.href='reapply.daterange.go?dA_no=${p.uA_da_no }&uA_no=${p.uA_no }'">기간 연장 재신청</button>
									<button id="btnCancel" onClick="deleteMyPetRecode(${p.uA_no})">삭제하기</button>
								</c:if>
							</td>
							<td>
								<c:choose>
									<c:when test="${p.uA_ta_no eq 0}">
										<button id="btnCancel" onClick="location.href='reapply.myteacher.go?dA_no=${p.uA_da_no }&uA_no=${p.uA_no }'">선생님 재신청</button>
									</c:when>
									<c:otherwise>
										<c:forEach var="t" items="${passTeachers }">
										<c:if test="${p.uA_ta_no eq t.tA_no}">${t.tA_name }(${t.tA_id }, <c:if test="${t.tA_gender eq 'man'}">남</c:if><c:if test="${t.tA_gender eq 'woman'}">여</c:if>)</c:if>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<c:if test="${p.uA_agree eq 1}">승인 완료</c:if>
								<c:if test="${p.uA_agree eq 0}">승인 대기 중<br>
									<button id="btnCancel" onClick="applyCancelUa(${p.uA_no})">신청 취소</button>
								</c:if>
							</td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		</c:if>
		
		</c:forEach>
</section>
</body>
</html>