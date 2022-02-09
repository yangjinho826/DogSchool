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
		<c:forEach var="g" items="${getTypee }">
				<form action="schoolmain.go">
					<section id="showSchoolArea">
						<c:forEach var="ps" items="${passSchools }">
							<div id="showOneSchool">
								<div>${ps.da_schoolname }</div>

								<div>${ps.da_addr }</div>

								<div>원장: ${ps.da_name }(${ps.da_id })</div>

								<div>${ps.da_phonenumber }</div>
								
								<div hidden="hidden">${ps.da_no }</div>
								<div>
									<button>유치원 홈</button>
								</div>
							</div>
						</c:forEach>
					</section>
				</form>
		</c:forEach>
		</section>
</body>
</html>