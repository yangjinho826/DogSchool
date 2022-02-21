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
	<section id="applyHomeArea">		
		<section id="showSchoolArea">
		<c:set var="num" value="${TotalCount - ((pg-1) * rowSize) }"/>
			<c:forEach var="ps" items="${passSchools }">
			<form action="schoolmain.go">
				<div id="showOneSchool">
				<div>${ps.dA_schoolname }</div>
				<div>${ps.dA_addr }</div>
				<div>원장: ${ps.dA_name }(${ps.dA_id })</div>
				<div>${ps.dA_phonenumber }</div>
				<input name="ps.dA_no" value="${ps.dA_no }" hidden="hidden" >
				<div><button>유치원 홈</button></div>
				</div>
			</form>
			<c:set var="num" value="${num-1 }"></c:set>
			</c:forEach>
		</section>
		
		<table id ="postscript_paging">
			<tr>
			<td>
			<c:choose>
	        <c:when test = "${pg > block}">
	            [<a href="list.go?pg=1">◀◀</a>]
	            [<a href="list.go?pg=${fromPage -1}">◀</a>] 
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
	        		[<a href="list.go?pg=${i }">${i }</a>]
	        	</c:otherwise>
	        	</c:choose>
	        	
	        </c:forEach>
	       
	        <c:choose>
	        	<c:when test = "${toPage < allPage }">
	        		[<a href="list.go?pg=${toPage + 1}">▶</a>]
	                [<a href="list.go?pg=${allPage}">▶▶</a>]
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