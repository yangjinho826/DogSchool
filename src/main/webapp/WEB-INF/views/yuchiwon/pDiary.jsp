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
	다이어리인가..!
	<h1>알림장</h1>
	<button onclick="location.href='diary.write'">작성하기</button>
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="" items="">
		<tr>
		<!-- 
			<td>${ }</td>
			<td>${ }</td>
			<td>${ }</td>
			 -->
		</tr>
		</c:forEach>
	</table>
</body>
</html>