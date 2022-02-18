<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dog School</title>
</head>
<body>
	<section id="home">
		<section class="home_list">
			<a href="yuchiwon.get.alldiary">알림장 </a>
		</section>
		<section>
		<c:forEach var="d" items="${diaries }">
		<table border="1" style="float: left;">
			<tr>
				<td>제목 : ${d.mp_title }</td>
			</tr>
			<tr>
				<td>건강상태 : ${d.mp_condition }</td>
			</tr>
			<tr>
				<td>식사량 : ${d.mp_meal }</td>
			</tr>
			<tr>
				<td>배변 횟수 : ${d.mp_defecate }</td>
			</tr>
			<tr>
				<td>준비물 : ${d.mp_supplies }</td>
			</tr>
			<tr>
				<td>내용 : ${d.mp_txt }</td>
			</tr>
			<tr>
				<td>날짜 : ${d.mp_date }
				<input type="hidden" value="${d.mp_tid }" class="tid">
				<input type="hidden" value="${d.mp_uid }" class="uid">
				<input type="hidden" value="${d.mp_uname }" class="uname">
				</td>
			</tr>
		</table>
		</c:forEach>
		</section>
		<section class="home_review">
			<a href="yuchiwon.get.allgallery">갤러리</a>
		</section>
		<section>
			<c:forEach var="g" items="${galleries }">
			<table border="1" style="float: left;">
				<tr>
					<td>제목 : ${g.g_title }</td>
				</tr>
				<tr>
					<td><a href="gallery.detail?g_no=${g.g_no }"> <img
							style="max-width: 200px" src="resources/img/${g.filess[0] }">
					</a></td>
				</tr>
				<tr>
					<td>날짜 : ${g.g_date }</td>
				</tr>
			</table>
		</c:forEach>
		</section>
	
	</section>
	
</body>
</html>