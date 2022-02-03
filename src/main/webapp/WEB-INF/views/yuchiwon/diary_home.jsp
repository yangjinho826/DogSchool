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
	<button onclick="location.href='diary.write.go'">작성하기</button>
	<c:forEach var="d" items="${diaries }">
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
				<td>날짜 : ${d.mp_date }</td>
			</tr>
			
			<c:forEach var="dr" items="${d.mp_replys }">
			<tr>
				<td>${dr.r_owner }</td>
				<td>${dr.r_txt }</td>
				<td>(<fmt:formatDate value="${dr.r_when }" type="both" dateStyle="short" timeStyle="short"/>)</td>
			</tr>
			</c:forEach>
			<tr>
				<td>
					<form action="diary.reply.write">
						<input type="hidden" name="r_mp_no" value="${d.mp_no }">
						<input name="r_txt" maxlength="80" autocomplete="off">
						<button>쓰기</button>
					</form>
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>