<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>갤러리</h1>
	<c:if test="${sessionScope.loginMember.typee ==  2}">
		<button onclick="location.href='gallery.write.go'">작성하기</button>
	</c:if>
	<div id="gDiv">
		<c:forEach var="g" items="${galleries }">
			<table class="gTbl">
				<tr>
					<td>제목 : ${g.g_title }</td>
				</tr>
				<tr>
					<td><a href="gallery.detail?g_no=${g.g_no }"> <img
							style="max-width: 200px" src="resources/img/${g.filess[0] }">
					</a></td>
				</tr>
				<tr>
					<td>날짜 : ${g.g_date }</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>