<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="diary.update">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="mp_title" value="${d.mp_title }"></td>
			</tr>
			<tr>
				<td>건강상태</td>
				<td><input name="mp_condition" value="${d.mp_condition }"></td>
			</tr>
			<tr>
				<td>우유량</td>
				<td><input name="mp_meal" value="${d.mp_meal }"></td>
			</tr>
			<tr>
				<td>배변량</td>
				<td><input name="mp_defecate" value="${d.mp_defecate }"></td>
			</tr>
			<tr>
				<td>준비물</td>
				<td><input name="mp_supplies" value="${d.mp_supplies }"></td>
			</tr>
			<tr>
				<td>알림 내용</td>
				<td><textarea name="mp_txt">${d.mp_txt }</textarea></td>
			</tr>
		</table>
		<button name="mp_no" value="${d.mp_no }">수정하기</button>
	</form>
</body>
</html>