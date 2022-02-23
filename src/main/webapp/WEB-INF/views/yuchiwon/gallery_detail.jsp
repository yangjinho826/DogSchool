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
	<h1>갤러리</h1>
		<table class="gTbl_dt">
			<tr>
				<td>제목 : ${g.g_title }</td>
			</tr>
			<tr>
				<td>
			<c:forEach var="f" items="${g.filess }">
				<img style="max-width: 200px"  src="resources/img/${f }">
			</c:forEach>
				</td>
			</tr>
			<tr>
				<td>작성자 : ${g.g_tid }</td>
			</tr>
			<tr>
				<td>날짜 : ${g.g_date }</td>
			</tr>

			<c:if test="${sessionScope.loginMember.id == g.g_tid}">
				<tr>
					<td>
						<button onclick="updateGallery('${g.g_no}')">수정</button>
						<button onclick="deleteGallery(${g.g_no})">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	<button onclick="location.href='yuchiwon.get.allgallery'">목록</button>
</body>
</html>