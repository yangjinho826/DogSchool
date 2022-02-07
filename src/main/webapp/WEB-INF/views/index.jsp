<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Dog School</title>
	
	<!-- jQuery -->
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/member_jquery.js"></script>
	
	<!-- validCheck  -->
	<script type="text/javascript" src="resources/js/validCheck.js"></script>
	
	<!-- summernote api -->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script> 
	<script src="resources/summernote/summernote-lite.js"></script>
	<script src="resources/summernote/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="resources/summernote/summernote-lite.css">	
	<script type="text/javascript" src="resources/js/summernote.js"></script>
	
	<link rel="icon" type="image/png" href="resources/img/dog-solid.svg">
	<script src="https://kit.fontawesome.com/cb4142df56.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">
	
	<!-- js -->
	<script type="text/javascript" src="resources/js/notice.js"></script>
	<script type="text/javascript" src="resources/js/postscript.js"></script>	
	<script type="text/javascript" src="resources/js/member.js"></script>
	<script type="text/javascript" src="resources/js/jsApply.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	
	<!-- CSS -->
	<link rel="stylesheet" href="resources/css/main.css"/>
	<link rel="stylesheet" href="resources/css/notice.css"/>
	<link rel="stylesheet" href="resources/css/postscript.css"/>
	<link rel="stylesheet" href="resources/css/applyHome.css"/>
	<link rel="stylesheet" href="resources/css/manageHome.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	
</head>
<body>
		<jsp:include page="${loginPage }"></jsp:include>
		<jsp:include page="${MenuBar }"></jsp:include>
		<jsp:include page="${contentPage }"></jsp:include>
		<jsp:include page="${footer }"></jsp:include>
</body>
</html>
