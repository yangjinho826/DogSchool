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
</head>
<body>
	<jsp:include page="${loginPage }"></jsp:include>
	<section id="menu">
		<div class="menu">
			<div class="menu_title">
				<img class="menu_title_img" src="resources/img/dog-solid-1.png">
				<h1 class="menu_title_t">강아지 유치원</h1>
			</div>
			<div class="menu_menubar">
				<a href="yuchiwon.get.diary">알림장</a>
				<a href="yuchiwon.get.gallery">갤러리</a>
			</div>
		</div>
	</section>
	<jsp:include page="${puppyContent }"></jsp:include>
</body>
</html>