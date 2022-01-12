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
<table>
	<tr>
		<th>마이펫 목록</th>
	</tr>
	<c:forEach var="p" items="${puppies }">
	<tr>
		<td>${p.uA_img }</td> 
		
		<td onclick="location.href='puppyC?puppyName=${p.uA_name}'">${p.uA_name }</td>
		
	</tr>
	</c:forEach>
</table>

</body>
</html>