<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
			<tr>
				<td>제목</td>
				<td>${d.mp_title }</td>
			</tr>
			<tr>
				<td>건강상태</td>
				<td>${d.mp_condition }</td>
			</tr>
			<tr>
				<td>우유량</td>
				<td>${d.mp_meal }</td>
			</tr>
			<tr>
				<td>배변량</td>
				<td>${d.mp_defecate }</td>
			</tr>
			<tr>
				<td>준비물</td>
				<td>${d.mp_supplies }</td>
			</tr>
			<tr>
				<td>알림 내용</td>
				<td>${d.mp_txt }</td>
			</tr>
		</table>
		<button name="mp_no" onclick="location.href='diary.update.go?mp_no=${d.mp_no}'" >수정하기</button>
		<button name="mp_no" onclick="deleteDiary('${d.mp_no}')" >삭제하기</button>
</body>
</html>