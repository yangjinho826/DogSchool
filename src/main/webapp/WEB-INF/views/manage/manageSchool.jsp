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

		<h2 align="center" id="manageHomeTitle">이용 중인 유치원</h2>
		<div id="manageMenuBar">
			<select class="manageSelect">
				<option>최근순</option>
				<option>오래된 순</option>
			</select>
			<div id="searchMenu">
				<!--
				<select class="searchSelect">
					<option>제목</option>
					<option>주소</option>
				</select>
				-->
				<form>
					<input name="searchWord" class="searchBar" placeholder="검색어를 입력하시오"> 
					<button class="searchBtn">검색</button>
				</form>
			</div>
		</div>
		
		<c:forEach var="s" items="${passSchools }">
		<table border="1" id="manageTbl">
			<tr>
				<th>유치원 이름(구분 코드)</th>
				<th>원장님(아이디)</th>
				<th>연락처</th>
				<th>관리</th>
			</tr>
			<tr>
				<td>${s.da_schoolname }<br>(${s.da_no })</td>
				<td>${s.da_name }<br>(${s.da_id })</td>
				<td>${s.da_phonenumber }</td>
				<td rowspan="3"><button class="manageDelete" onClick="deleteSchool(${s.da_no})">삭제</button></td>
			</tr>
			<tr>				
				<th rowspan="3">주소</th>
			</tr>
			<tr>				
				<td rowspan="3" colspan="2">${s.da_addr }</td>
			</tr>
		</table>
		</c:forEach>
		
	</div>
	
</section>

</body>
</html>