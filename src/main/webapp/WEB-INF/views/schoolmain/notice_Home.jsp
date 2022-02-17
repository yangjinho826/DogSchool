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

	<section id="notice_Home">
		<section class="notice_Home">
			<h1 class="notice_title"> 공지사항 </h1>
			<c:choose> 
				 <c:when test="${memberTypee eq '2'}">
				  	    <c:if test="${TCheck.tA_da_no eq getSchoolSession.dA_no}">
							 <button class="notice_writebtn" onclick="location.href='notice_write.go'">작성하기</button>
					    </c:if>
				</c:when>
			 	<c:when test="${memberTypee eq '3'}">
			 	   <c:if test="${DCheck.dA_no eq getSchoolSession.dA_no}">
						<button class="notice_writebtn" onclick="location.href='notice_write.go'">작성하기</button>
				 	</c:if>
				</c:when>
			</c:choose>
		</section>
		<section id="notice_Body">
			<table class="notice">
				<tr class="notic_tr">
					<td class="notic_table_title" style="width:10%;"> 글 번호 </td>
					<td class="notic_table_title" style="width:50%;"> 제목 </td>
					<td class="notic_table_title" style="width:20%;"> 작성자</td>
					<td class="notic_table_title" style="width:20%;"> 날짜 </td>
				</tr>
		
				<c:set var="num" value="${TotalCount - ((pg-1) * rowSize) }"/>
				<c:forEach var="n" items="${notices }">
					<tr>
						<td>${num }</td>
						<td><a href="notice.Detail?n_no=${n.n_no}">${n.n_title }</a></td>
						<td>${n.n_id }</td>
						<td><fmt:formatDate value="${n.n_date }" type="both" dateStyle="short" timeStyle="short"/></td>
					</tr>
					<c:set var="num" value="${num-1 }"></c:set>
				</c:forEach>
			</table>
		</section>
		<table id ="notic_paging">
			<tr>
			<td>
			<c:choose>
	        <c:when test = "${pg > block}">
	            [<a href="notice.go?pg=1">◀◀</a>]
	            [<a href="notice.go?pg=${fromPage -1}">◀</a>] 
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
	        		[<a href="notice.go?pg=${i }">${i }</a>]
	        	</c:otherwise>
	        	</c:choose>
	        	
	        </c:forEach>
	       
	        <c:choose>
	        	<c:when test = "${toPage < allPage }">
	        		[<a href="notice.go?pg=${toPage + 1}">▶</a>]
	                [<a href="notice.go?pg=${allPage}">▶▶</a>]
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