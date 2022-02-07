<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<section id="menu" >
		<div class="menu">
			<div class="menu_title">
				<img onClick="location.href='HC.go'" class="menu_title_img" src="resources/img/dog-solid-1.png">
				<a href="schoolmain.go"><h1 class="menu_title_t"> ${r}유치원</h1></a>
			</div>
			<div class="menu_menubar">
				<!--<a href="#" class="menu_menubar_item">유치원 소개</a> -->
					<a href="notice.go" class="menu_menubar_item">공지사항</a>
					<a href="postscript.go" class="menu_menubar_item">선생님 후기</a>
					<a href="schedule.go" class="menu_menubar_item">시간표</a>
					<a href="priceTag.go" class="menu_menubar_item">가격표</a>
			</div>
		</div>
	</section>
</body>
</html>