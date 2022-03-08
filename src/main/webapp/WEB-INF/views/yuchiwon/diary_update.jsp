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
	<form action="diary.update" name="dwForm" onsubmit="return diarycall()">
		<table border="1" class="diaryTbl">
			<tr>
				<td class="tdTitle" colspan="2" align="center">알림장 수정</td>
			</tr>
			<tr>
				<td class="td1">제목</td>
				<td class="td2"><input name="mp_title" value="${d.mp_title }"></td>
			</tr>
			<tr>
				<td class="td1">건강상태</td>
				<td class="td2"><input name="mp_condition" value="${d.mp_condition }"></td>
			</tr>
			<tr>
				<td class="td1">우유량</td>
				<td class="td2"><input name="mp_meal" value="${d.mp_meal }"></td>
			</tr>
			<tr>
				<td class="td1">배변량</td>
				<td class="td2"><input name="mp_defecate" value="${d.mp_defecate }"></td>
			</tr>
			<tr>
				<td class="td1">준비물</td>
				<td class="td2"><input name="mp_supplies" value="${d.mp_supplies }"></td>
			</tr>
			<tr>
				<td class="td1">알림 내용</td>
				<td class="td2"><textarea name="mp_txt">${d.mp_txt }</textarea></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><button type="submit" name="mp_no" value="${d.mp_no }">수정하기</button></td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>