<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/gallery.js" defer></script>
<script type="text/javascript" src="resources/js/validCheck.js" defer></script>
<link rel="stylesheet" href="resources/css/gallery.css"/>
</head>
<body>
<section id="gallery_write">
	<section class="gallery_write">
			<div class="gallery_write_title">
				<h1 class="gallery_write_title">갤러리 작성</h1>
			</div>
	</section>
	<section id="gallery_write_body">
		<form action="gallery.write" method="post" enctype="multipart/form-data" name="galleryForm" onsubmit="return gallerycallme()">
			 <div class="gallery_write_input">	
			 	<input name="token" value="${token }" hidden="hidden">
				<span class="gallery_write_input_w">제목</span>
				<input name="g_title" class="gallery">
			 </div>
			 <div class="gallery_write_input">	
				<span class="gallery_write_input_w">이미지</span>
				<input type="file" class="gallery1" multiple="multiple" name="g_img">
			 </div>
			 <div id="gallery_write_btn">
				<button class="gallery_write_btn">작성하기</button>
			</div>
		</form>
	</section>
</section>
</body>
</html>