<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="diaryWriteArea">
	<form action="diary.write" name="dwForm" onsubmit="return diarycall()">
		<table border="1" class="diaryTbl">
			<tr>
				<td class="tdTitle" colspan="2" align="center">알림장 작성</td>
			</tr>
			<tr>
				<td class="td1">제목</td>
				<td class="td2"><input name="mp_title"></td>
			</tr>
			<tr>
				<td class="td1">건강상태</td>
				<td class="td2"><input name="mp_condition"></td>
			</tr>
			<tr>
				<td class="td1">우유량</td>
				<td class="td2"><input name="mp_meal"></td>
			</tr>
			<tr>
				<td class="td1">배변량</td>
				<td class="td2"><input name="mp_defecate"></td>
			</tr>
			<tr>
				<td class="td1">준비물</td>
				<td class="td2"><input name="mp_supplies"></td>
			</tr>
			<tr>
				<td class="td1">알림 내용</td>
				<td class="td2"><textarea class="mp_txt" name="mp_txt"></textarea></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><button type="submit">작성하기</button></td>
			</tr>
		</table>
		<input name="token" value="${token }" hidden="hidden">
	</form>
	</section>
</body>
</html>