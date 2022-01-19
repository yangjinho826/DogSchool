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
<section id="manageHomeArea">
	<div>
		<h2 align="center" id="manageHomeTitle">운영 중인 유치원 </h2>
		<table border="1" style="border-collapse: collapse;" id="manageTbl">
			<tr>
				<th>유치원 이름<br>(구분 코드)</th>
				<th>원장님<br>(아이디)</th>
				<th>연락처</th>
				<th>주소</th>
			</tr>
			<c:forEach var="s" items="${passSchools }">
			<tr>
				<td>${s.da_schoolname }<br>(${s.da_no })</td>
				<td>${s.da_name }<br>(${s.da_id })</td>
				<td>${s.da_phonenumber }</td>
				<td>${s.da_addr }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
</section>

</body>
</html>