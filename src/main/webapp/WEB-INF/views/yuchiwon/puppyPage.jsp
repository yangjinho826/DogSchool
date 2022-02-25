<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dog School</title>
<script type="text/javascript" src="resources/js/gallery.js" defer></script>
</head>
<body>
	<section id="puppyPageHome">	
		<div class="puppyDiaryPreview">
			<h1 id="puppyPageTitle">알림장</h1>
			<c:if test="${sessionScope.loginMember.typee ==  2}">
				<button onclick="writeDiaryGo()">작성하기</button>
			</c:if>
				<div class="tableSort">
				<c:forEach var="d" items="${diaries }">
				<table border="1" id="dairyTbl">
					<tr>
						<td><a href="diary.detail.go?mp_no=${d.mp_no}">제목 : ${d.mp_title }</a></td>
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
						<td>날짜 : ${d.mp_date }</td>
					</tr>
				</table>
				</c:forEach>
				</div>
			<table id ="notic_paging">
			<tr>
			<td>
			<c:choose>
	        <c:when test = "${pg > block}">
	            [<a href="yuchiwon.get.puppy?pg=1&uA_no=${param.uA_no }">◀◀</a>]
	            [<a href="yuchiwon.get.puppy?pg=${fromPage -1}&uA_no=${param.uA_no }">◀</a>] 
	        </c:when>
	
	        <c:otherwise>
	            [<span style="color:gray">◀◀</span>]   
	            [<span style="color:gray">◀</span>]
	        </c:otherwise>
	     	</c:choose>
	
	        <c:forEach var="i" begin="${fromPage }" end="${toPage }">
	        	<c:choose>
	        	<c:when test = "${i == pg }">
	        		[${i }]
	        	</c:when>
	        	
	        	<c:otherwise>
	        		[<a href="yuchiwon.get.puppy?pg=${i }&uA_no=${param.uA_no }">${i }</a>]
	        	</c:otherwise>
	        	</c:choose>
	        	
	        </c:forEach>
	       
	        <c:choose>
	        	<c:when test = "${toPage < allPage }">
	        		[<a href="yuchiwon.get.puppy?pg=${toPage + 1}&uA_no=${param.uA_no }">▶</a>]
	                [<a href="yuchiwon.get.puppy?pg=${allPage}&uA_no=${param.uA_no }">▶▶</a>]
	        	</c:when>
	        	<c:otherwise>
	        		[<span style="color:gray">▶</span>]
	                [<span style="color:gray">▶▶</span>]
	        	</c:otherwise>       
	        </c:choose>
	        </td>
	        </tr>
		</table>
		</div>
		<br>
		
		
		<div class="puppyGalleryPreview">
			<h1 id="puppyPageTitle"><a href="yuchiwon.get.allgallery">갤러리</a></h1>
			<c:if test="${sessionScope.loginMember.typee ==  2}">
				<button onclick="GallerywriteWindow()">작성하기</button>
			</c:if>
			<div class="tableSort">
				<c:forEach var="g" items="${galleries }">
				<table border="1" id="dairyTbl">
					<tr>
						<td>제목 : ${g.g_title }</td>
					</tr>
					<tr>
						<td><img style="max-width: 200px" src="resources/img/${g.filess[0] }"></td>
					</tr>
					<tr>
						<td>날짜 : ${g.g_date }</td>
					</tr>
				</table>
				</c:forEach>	
			</div>	
		</div>
	</section>
</body>
</html>