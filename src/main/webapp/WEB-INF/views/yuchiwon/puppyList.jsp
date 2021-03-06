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

<div id="viewPuppyList">
	<h2 id="puppyListTitle">강아지 목록</h2>
	<table id="puppyListTbl" border="1">
		<tr>
			<th>유치원 이름</th>
			<th>사진</th>
			<th>강아지 이름</th>
			<th>견주 아이디</th>
			<th>관리 기간</th>
		</tr>
		<c:forEach var="p" items="${puppies }">
		<c:if test="${p.uA_daterange ne '기간 만료' }">
		<tr class="trr" onClick="location.href='yuchiwon.get.puppy?uA_no=${p.uA_no }'">
			<td>
				<c:forEach var="dd" items="${passSchools }">
				<c:if test="${dd.dA_no eq p.uA_da_no }">${dd.dA_schoolname }</c:if>
				</c:forEach>
			</td>
			<td><img id="puppyListImg" src="resources/img/${p.uA_img }"></td>
			<td>${p.uA_name }</td>
			<td>${p.uA_id }</td>
			<td>${p.uA_daterange}</td>
		</tr>
		</c:if>
		</c:forEach>
	</table>
</div>

</body>
</html>