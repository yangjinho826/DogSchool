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
	<h1>알림장</h1>
	<button onclick="location.href='diary.write.go'">작성하기</button>
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="d" items="${diaries }">
				<tr>
					<td>${d.mp_no }</td>
					<td><a href="diary.Detail?mp_no=${d.mp_no}">${d.mp_title }</a></td>
					<td>${d.mp_id }</td>
					<td><fmt:formatDate value="${d.mp_date }" type="both" dateStyle="short" timeStyle="short"/></td>
				</tr>
				</c:forEach>
	</table>
</body>
</html>