<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="postscript_Home">
		<section class="postscript_Home">
			<h1 class="postscript_title"> 선생님 후기 </h1>
			<c:if test="${memberTypee eq '1'}">
				<button class="postscript_writebtn" onclick="location.href='postscript_write.go'">작성하기</button>
			</c:if>
		</section>
		<section id="postscript_Body">
			<table class="postscript">
				<tr class="postscript_tr">
					<td class="postscript_table_title" style="width:10%;"> 글 번호 </td>
					<td class="postscript_table_title" style="width:50%;"> 제목 </td>
					<td class="postscript_table_title" style="width:20%;"> 작성자</td>
					<td class="postscript_table_title" style="width:20%;"> 날짜 </td>
				</tr>

				<c:forEach var="p" items="${postscripts }">
				<tr>
					<td>${p.p_no }</td>
					<td><a href="postscript.Detail?p_no=${p.p_no}">${p.p_title }</a></td>
					<td>${p.p_id }</td>
					<td><fmt:formatDate value="${p.p_date }" type="both" dateStyle="short" timeStyle="short"/></td>
				</tr>
				</c:forEach>

			</table>
		</section>
	</section>
</body>
</html>