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
	<h1>갤러리 수정</h1>
	<form action="gallery.update" method="post" enctype="multipart/form-data" name="galleryForm1" onsubmit="return gallerycallupdateme()">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="g_title" value="${g.g_title }"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" multiple="multiple" name="g_img"></td>
			</tr>
		</table>
		<input type="hidden" name="originalFile" value="${g.g_img }">
		<input type="hidden" name="g_no" value="${g.g_no }">
		<button >수정하기</button>
	</form>
</body>
</html>