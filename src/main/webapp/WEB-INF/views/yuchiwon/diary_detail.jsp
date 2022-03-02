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
			
			<c:forEach var="dr" items="${d.mp_replys }">
			<tr>
				<td>${dr.r_owner }</td>
				<td>${dr.r_txt }</td>
				<td>(<fmt:formatDate value="${dr.r_when }" type="both" dateStyle="short" timeStyle="short"/>)</td>
				<td>
				<c:if test="${sessionScope.loginMember.id == dr.r_owner }">
				<button onclick="deleteReply(${dr.r_no});">삭제</button>
				</c:if>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td>
					<form action="diary.reply.write">
						<!-- <input type="hidden" name="r_mp_no" value="${d.mp_no }">
						<input type="hidden" name="r_owner" value="${dr.r_owner }"> -->
						<input name="r_txt" maxlength="80" autocomplete="off">
					</form>
				</td>
				<td>
					<button>쓰기</button>
				</td>
			</tr>
		</table>
		<c:if test="${sessionScope.loginMember.typee ==  2}">
		<button name="mp_no" onclick="location.href='diary.update.go?mp_no=${d.mp_no}'" >수정하기</button>
		<button name="mp_no" onclick="deleteDiary('${d.mp_no}')" >삭제하기</button>
		</c:if>
</body>
</html>