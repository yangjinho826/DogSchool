<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="postscript_Home">
		<section class="postscript_Home">
			<h1 class="postscript_title"> 유치원 후기 </h1>
		</section>
		<section id="postscript_Body">
			<table class="postscript">
				<tr class="postscript_tr">
					<td class="postscript_table_title" style="width:10%;"> 글 번호 </td>
					<td class="postscript_table_title" style="width:50%;"> 제목 </td>
					<td class="postscript_table_title" style="width:20%;"> 작성자</td>
					<td class="postscript_table_title" style="width:20%;"> 날짜 </td>
				</tr>

			<c:set var="num" value="${TotalCount - ((pg-1) * rowSize) }"/>
				<c:forEach var="r" items="${reviews }">
				<tr>
					<td>${r.r_no }</td>
					<td><a href="review.Detail?r_no=${r.r_no}">${r.r_title }</a></td>
					<td>${r.r_id }</td>
					<td><fmt:formatDate value="${r.r_date }" type="both" dateStyle="short" timeStyle="short"/></td>
				</tr>
				<c:set var="num" value="${num-1 }"></c:set>
				</c:forEach>

			</table>
		</section>
		<table id ="postscript_paging">
			<tr>
			<td>
			<c:choose>
	        <c:when test = "${pg > block}">
	            [<a href="review.go?pg=1">◀◀</a>]
	            [<a href="review.go?pg=${fromPage -1}">◀</a>] 
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
	        		[<a href="review.go?pg=${i }">${i }</a>]
	        	</c:otherwise>
	        	</c:choose>
	        	
	        </c:forEach>
	       
	        <c:choose>
	        	<c:when test = "${toPage < allPage }">
	        		[<a href="review.go?pg=${toPage + 1}">▶</a>]
	                [<a href="review.go?pg=${allPage}">▶▶</a>]
	        	</c:when>
	        	<c:otherwise>
	        		[<span style="color:gray">▶</span>]
	                [<span style="color:gray">▶▶</span>]
	        	</c:otherwise>       
	        </c:choose>
	        </td>
	        </tr>
		</table>
	</section>
</body>
</html>