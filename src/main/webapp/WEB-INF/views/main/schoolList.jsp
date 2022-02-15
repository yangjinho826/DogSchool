<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="applyHomeArea">		
		<section id="showSchoolArea">
			<c:forEach var="ps" items="${passSchools }">
			<form action="schoolmain.go">
				<div id="showOneSchool">
				<div>${ps.da_schoolname }</div>
				<div>${ps.da_addr }</div>
				<div>원장: ${ps.da_name }(${ps.da_id })</div>
				<div>${ps.da_phonenumber }</div>
				<input name="ps.da_no" value="${ps.da_no }" hidden="hidden" >
				<div><button>유치원 홈</button></div>
				</div>
			</form>
			</c:forEach>
		</section>
				
	</section>
</body>
</html>