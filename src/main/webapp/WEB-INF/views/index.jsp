<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Dog School</title>
	<link rel="icon" type="image/png" href="resources/img/dog-solid.svg">
	<script src="https://kit.fontawesome.com/cb4142df56.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/main.css"/>
	<link rel="stylesheet" href="resources/css/applyHome.css"/>
	<link rel="stylesheet" href="resources/css/manageHome.css"/>
	
	<script type="text/javascript" src="resources/js/jQuery.js"></script>
	<script type="text/javascript" src="resources/js/jsApply.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>
<body>
		<jsp:include page="${loginPage }"></jsp:include>
		<jsp:include page="${MenuBar }"></jsp:include>
		<jsp:include page="${contentPage }"></jsp:include>
		<jsp:include page="${footer }"></jsp:include>
</body>
</html>
