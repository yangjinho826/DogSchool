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
	<script type="text/javascript" src="resources/js/jquery.js" defer></script>
	
	
	<!-- validCheck  -->
	<script type="text/javascript" src="resources/js/validCheck.js" defer></script>
	
	<!-- summernote api -->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js" defer></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js" defer></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js" defer></script> 
	<script src="resources/summernote/summernote-lite.js" defer></script>
	<script src="resources/summernote/summernote-ko-KR.js" defer></script>
	<link rel="stylesheet" href="resources/summernote/summernote-lite.css">	
	<script type="text/javascript" src="resources/js/summernote.js" defer></script>
	<script type="text/javascript" src="resources/js/member_jquery.js"defer></script>
	
	<!-- js -->
	<script type="text/javascript" src="resources/js/notice.js" defer></script>
	<script type="text/javascript" src="resources/js/postscript.js" defer></script>	
	<script type="text/javascript" src="resources/js/member.js" defer></script>
	<script type="text/javascript" src="resources/js/jsApply.js" defer></script>
	<script type="text/javascript" src="resources/js/diary.js" defer></script>
	<script type="text/javascript" src="resources/js/review.js" defer></script>
	<script type="text/javascript" src="resources/js/gallery.js" defer></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>


	<link rel="icon" type="image/png" href="resources/img/dog-solid.svg">
	<script src="https://kit.fontawesome.com/cb4142df56.js" crossorigin="anonymous" defer></script>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">
	
	<!-- CSS -->
	<link rel="stylesheet" href="resources/css/main.css"/>
	<link rel="stylesheet" href="resources/css/Schoolhome.css"/>
	<link rel="stylesheet" href="resources/css/notice.css"/>
	<link rel="stylesheet" href="resources/css/postscript.css"/>
	<link rel="stylesheet" href="resources/css/applyHome.css"/>
	<link rel="stylesheet" href="resources/css/manageHome.css"/>
	<link rel="stylesheet" href="resources/css/gallery.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	<link rel="stylesheet" href="resources/css/member.css"/>

	
</head>
<body>
		<jsp:include page="${loginPage }"></jsp:include>
		<jsp:include page="${MenuBar }"></jsp:include>
		<jsp:include page="${contentPage }"></jsp:include>
		<jsp:include page="${footer }"></jsp:include>
</body>
</html>
