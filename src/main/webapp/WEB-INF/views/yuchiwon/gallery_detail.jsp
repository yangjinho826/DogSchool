<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/gallery.js" defer></script>
</head>
<body>
<section id="gallery_detail">
		 <section class="notice_Detail">
			<h1 class="notice_title" id="mtitle" >갤러리</h1>
		 </section>
		<table class="gTbl_dt">
			<tr class="gTr1">
				<td class="g_title">제목 : ${g.g_title }</td>
			</tr>
			<tr>
				<td>
			<c:forEach var="f" items="${g.filess }">
				<img class="galleryImg" style="width: 230px; height: 200px; margin: 10px;" src="resources/img/${f }">
			</c:forEach>
				</td>
			</tr>
			<tr class="gTr2">
				<td class="gTdWriter">작성자 : ${g.g_tid}</td>
			</tr>
			<tr>
				<td class="gTd">날짜 : ${g.g_date }</td>
			</tr>

				<tr>
					<td>
						<c:if test="${sessionScope.loginMember.id == g.g_tid}">
						<button class="gallery_Detail_Btn" onclick="updateGallery('${g.g_no}')">수정</button>
						<button class="gallery_Detail_Btn" onclick="deleteGallery(${g.g_no})">삭제</button>
						</c:if>
						<button  class="gallery_Detail_Btn" onclick="location.href='yuchiwon.get.puppy?&uA_no=${sessionScope.puppies.uA_no }'">목록</button>
					</td>
				</tr>
		</table>
</section>
</body>
</html>