<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="home">
		<section class="home_Banner" >
			<div ><img class="home_Banner_img" src="resources/img/2.png"></div>
		</section>
		
		<section id="postscript_Home">
		<h1 class="postscript_title"> 유치원 목록 </h1> 
		<button id="seemore" onClick="location.href='list.go'">+</button>
			<section id="showSchoolArea">
				<c:forEach var="ps" items="${passSchools }">
					<div id="showOneSchool">
					<div>${ps.da_schoolname }</div>
					<div>${ps.da_addr }</div>
					<div>원장: ${ps.da_name }(${ps.da_id })</div>
					<div>${ps.da_phonenumber }</div>
					<input name="ps.da_no" value="${ps.da_no }" hidden="hidden" >
					<div><button>유치원 홈</button></div>
					</div>
				</c:forEach>
			</section>
		</section>
		
		<section class="home_review">
			<section id="review_Home">
			<h1 class="review_title"> 유치원 후기 </h1>
			<button id="seemore" onClick="location.href='review.go'">+</button>
		<section id="review_Body">
			<table class="review">
				<tr class="review_tr">
					<td class="review_table_title" style="width:10%;"> 글 번호 </td>
					<td class="review_table_title" style="width:50%;"> 제목 </td>
					<td class="review_table_title" style="width:20%;"> 작성자</td>
					<td class="review_table_title" style="width:20%;"> 날짜 </td>
				</tr>
				
				<c:forEach var="r" items="${reviews }">
				<tr>
					<td>${r.r_no }</td>
					<td><a href="review.Detail?r_no=${r.r_no}">${r.r_title }</a></td>
					<td>${r.r_id }</td>
					<td><fmt:formatDate value="${r.r_date }" type="both" dateStyle="short" timeStyle="short"/></td>
				</tr>
				</c:forEach>
		</table>
		</section>
		</section>
	</section>
	</section>
</body>
</html>