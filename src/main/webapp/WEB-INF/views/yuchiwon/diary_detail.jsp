<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="notice_Detail">
		<h1 class="notice_title" >알림장</h1>
	</section>
	<section id="diaryDetailArea">
		<table class="diaryDetailTbl">
			<tr>
				<td class="diaryDetailTd1">제목</td>
				<td class="diaryDetailTd2">${d.mp_title }</td>
			</tr>
			<tr>
				<td class="diaryDetailTd1">건강상태</td>
				<td class="diaryDetailTd2">${d.mp_condition }</td>
			</tr>
			<tr>
				<td class="diaryDetailTd1">우유량</td>
				<td class="diaryDetailTd2">${d.mp_meal }</td>
			</tr>
			<tr>
				<td class="diaryDetailTd1">배변량</td>
				<td class="diaryDetailTd2">${d.mp_defecate }</td>
			</tr>
			<tr>
				<td class="diaryDetailTd1">준비물</td>
				<td class="diaryDetailTd2">${d.mp_supplies }</td>
			</tr>
			<tr>
				<td class="diaryDetailTd1">알림 내용</td>
				<td class="diaryDetailTd2">${d.mp_txt }</td>
			</tr>
		</table>

		<table class="diaryDetailTbl2" border="1">
			<c:forEach var="dr" items="${d.mp_replys }">
				<tr class="drTr">
					<td class="drTd">${dr.r_owner }-&nbsp;${dr.r_txt }</td>
					<td class="drTd2">(<fmt:formatDate value="${dr.r_when }"
							type="both" dateStyle="short" timeStyle="short" />)
					</td>
					<td class="drTd3"><c:if
							test="${sessionScope.loginMember.name == dr.r_owner }">
							<button class="drButton"
								onclick="deleteReply(${dr.r_no}, ${d.mp_no });">삭제</button>
						</c:if></td>
				<tr>
			</c:forEach>

			<form action="diary.reply.write">
				<tr>
					<td class="drWrite" colspan="2"><input type="hidden"
						name="r_mp_no" value="${d.mp_no }"> <input type="hidden"
						name="r_owner" value="${sessionScope.loginMember.name }">
						<input type="hidden" name="mp_no" value="${d.mp_no }"> <input
						hidden="hidden" name="token" value="${token }"> <input
						class="drInput" name="r_txt" maxlength="80" autocomplete="off">
					</td>
					<td class="drTd3">
						<button class="drBtn">쓰기</button>
					</td>
				</tr>
			</form>
			
			<tr>
				<td class="drTdUpDel" colspan="2"><c:if
						test="${sessionScope.loginMember.typee ==  2}">
						<button name="mp_no"
							onclick="location.href='diary.update.go?mp_no=${d.mp_no}'"
							class="diaryBtn">수정</button>
						<button name="mp_no" onclick="deleteDiary('${d.mp_no}')"
							class="diaryBtn">삭제</button>
					</c:if></td>
				<td class="drTd3">
					<button
						onclick="location.href='yuchiwon.get.puppy?uA_no=${sessionScope.puppies.uA_no }'"
						class="diaryBtn">목록</button>
				</td>
			</tr>
		</table>
	</section>
</body>
</html>