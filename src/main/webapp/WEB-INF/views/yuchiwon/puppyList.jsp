<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
강아지들 여기에 출력
<table border="1">
	<tr>
		<th colspan="3">마이펫 목록</th>
	</tr>
	<tr>
		<td>사진</td>
		<td>강아지 이름</td>
		<td>견주 아이디</td>
	</tr>
	<c:forEach var="p" items="${puppies }">
	<tr>
		<td><a href="yuchiwon.get.puppy?uA_no=${p.uA_no }"><img id="puppyListImg" src="resources/img/${p.uA_img }"></a></td>
		<td><a href="yuchiwon.get.puppy?uA_no=${p.uA_no }">${p.uA_name }</a></td>
		<td>${p.uA_id }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>