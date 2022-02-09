<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>알림장</h1>
	<c:if test="${sessionScope.loginMember.typee ==  2}">
	<button onclick="writeDiaryGo()">작성하기</button>
	</c:if>
	<c:forEach var="d" items="${diaries }">
	<c:if test=""></c:if>
		<table>
			<tr>
				<td>제목 : ${d.mp_title }</td>
			</tr>
			<tr>
				<td>건강상태 : ${d.mp_condition }</td>
			</tr>
			<tr>
				<td>식사량 : ${d.mp_meal }</td>
			</tr>
			<tr>
				<td>배변 횟수 : ${d.mp_defecate }</td>
			</tr>
			<tr>
				<td>준비물 : ${d.mp_supplies }</td>
			</tr>
			<tr>
				<td>내용 : ${d.mp_txt }</td>
			</tr>
			<tr>
				<td>날짜 : ${d.mp_date }
				<input type="hidden" value="${d.mp_tid }" class="tid">
				<input type="hidden" value="${d.mp_uid }" class="uid">
				<input type="hidden" value="${d.mp_uname }" class="uname">
				</td>
			</tr>
			
			<c:forEach var="dr" items="${d.mp_replys }">
			<tr>
				<td>${dr.r_owner }</td>
				<td>${dr.r_txt }</td>
				<td>(<fmt:formatDate value="${dr.r_when }" type="both" dateStyle="short" timeStyle="short"/>)</td>
				<td>
				<c:if test="${sessionScope.loginMember.id == dr.r_owner }">
				<button onclick="deleteReply(${dr.r_no});">삭제</button>
				</c:if>
				<br>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td>
					<form action="diary.reply.write">
						<input type="hidden" name="r_mp_no" value="${d.mp_no }">
						<input type="hidden" name="r_owner" value="${dr.r_owner }">
						<input name="r_txt" maxlength="80" autocomplete="off">
						<button>쓰기</button>
					</form>
				</td>
			</tr>
			<c:if test="${sessionScope.loginMember.id == d.mp_tid}">
				<tr>
					<td>
						<button onclick="updateDiary(${d.mp_no})">수정</button>
						<button onclick="deleteDiary(${d.mp_no})">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
</body>
</html>