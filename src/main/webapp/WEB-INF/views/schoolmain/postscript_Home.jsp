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
			<h1 class="postscript_title"> 선생님 후기 </h1>
			<c:if test="${memberTypee eq '1'}">
			 <c:if test="${UCheck.uA_da_no eq getSchoolSession.da_no}">
				   <button class="postscript_writebtn" onclick="location.href='postscript_write.go'">작성하기</button>
			 </c:if>
			</c:if>
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
				<c:forEach var="p" items="${postscripts }">
				<tr>
					<td>${num}</td>
					<td><a href="postscript.Detail?p_no=${p.p_no}">${p.p_title }</a></td>
					<td>${p.p_id }</td>
					<td><fmt:formatDate value="${p.p_date }" type="both" dateStyle="short" timeStyle="short"/></td>
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
	            [<a href="postscript.go?pg=1">◀◀</a>]
	            [<a href="postscript.go?pg=${fromPage -1}">◀</a>] 
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
	        		[<a href="postscript.go?pg=${i }">${i }</a>]
	        	</c:otherwise>
	        	</c:choose>
	        	
	        </c:forEach>
	       
	        <c:choose>
	        	<c:when test = "${toPage < allPage }">
	        		[<a href="postscript.go?pg=${toPage + 1}">▶</a>]
	                [<a href="postscript.go?pg=${allPage}">▶▶</a>]
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