<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>알림장 작성</h1>
	<form action="diary.write" name="dwForm" onsubmit="return diarycall()">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="mp_title"></td>
			</tr>
			<tr>
				<td>건강상태</td>
				<td><input name="mp_condition"></td>
			</tr>
			<tr>
				<td>우유량</td>
				<td><input name="mp_meal"></td>
			</tr>
			<tr>
				<td>배변량</td>
				<td><input name="mp_defecate"></td>
			</tr>
			<tr>
				<td>준비물</td>
				<td><input name="mp_supplies"></td>
			</tr>
			<tr>
				<td>알림 내용</td>
				<td><textarea name="mp_txt"></textarea></td>
				<td><input name="token" value="${token }" hidden="hidden"></td>
			</tr>
		</table>
		<button type="submit">작성하기</button>
	</form>
</body>
</html>