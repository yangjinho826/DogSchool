<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gallery.update" method="post" enctype="multipart/form-data">
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
		<input type="hidden" name="token" value="${token}">
		
		<button name="g_no" value="${g.g_no }">수정하기</button>
	</form>
</body>
</html>