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
		<section class="notice_Home">
			<h1 class="notice_title"> 공지사항 </h1>
			<button class="notice_writebtn" onclick="location.href='notice_write.go'">작성하기</button>
		</section>
		<section id="notice_Body">
			<table class="notice">
				<tr class="notic_tr">
					<td class="notic_table_title" style="width:10%;"> 글 번호 </td>
					<td class="notic_table_title" style="width:50%;"> 제목 </td>
					<td class="notic_table_title" style="width:20%;"> 작성자</td>
					<td class="notic_table_title" style="width:20%;"> 날짜 </td>
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
	</section>
</body>
</html>