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
				<div>${ps.dA_schoolname }</div>
				<div>${ps.dA_addr }</div>
				<div>원장: ${ps.dA_name }(${ps.dA_id })</div>
				<div>${ps.dA_phonenumber }</div>
				<input name="ps.dA_no" value="${ps.dA_no }" hidden="hidden" >
				<div><button>유치원 홈</button></div>
				</div>
			</form>
			</c:forEach>
		</section>
				
	</section>
</body>
</html>