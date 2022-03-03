<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/gallery.js" defer></script>
<script type="text/javascript" src="resources/js/validCheck.js" defer></script>
</head>
<body>

	<h1>갤러리 작성</h1>
	<form action="gallery.write" method="post" enctype="multipart/form-data" name="galleryForm" onsubmit="return gallerycallme()">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="g_title"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" multiple="multiple" name="g_img"></td>
			</tr>
		</table>
		<input name="token" value="${token }" hidden="hidden">
		<button>작성하기</button>
	</form>

</body>
</html>