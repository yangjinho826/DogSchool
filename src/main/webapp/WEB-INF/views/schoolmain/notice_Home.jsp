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
	<section id="notice_Home">
		<h1 class="notice_title"> 공지사항 </h1>
		<button onclick="location.href='notice_write.go'"><h3>작성하기</h3></button>
	</section>
	<section id="notice_Body">
		<table border="1">
			<tr>
				<td> 글 번호 </td>
				<td> 제목 </td>
				<td> 작성자</td>
				<td> 날짜 </td>
			</tr>
			<c:forEach var="n" items="${notices }">
			<tr>
				<td>${n.n_no }</td>
				<td><a href="notice.Detail?n_no=${n.n_no}">${n.n_title }</a></td>
				<td>${n.n_id }</td>
				<td><fmt:formatDate value="${n.n_date }" type="both" dateStyle="short" timeStyle="short"/></td>
			</tr>
			</c:forEach>
		</table>
		
	</section>
</body>
</html>