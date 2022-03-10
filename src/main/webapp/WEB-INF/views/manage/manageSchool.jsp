<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section id="manageHomeArea">
	<div>
		<h2 align="center" id="manageHomeTitle">이용 중인 유치원</h2>
		<div id="manageMenuBar">
			<div id="managePaging">
		        <button id="allListBtn" onClick="location.href='manage.go'">[전체 목록]</button>
				&nbsp;
				<c:choose>
			        <c:when test = "${pg > block}">
			            [<a href="manage.go?pg=1">◀◀</a>]&nbsp;
			            [<a href="manage.go?pg=${fromPage -1}">◀</a>]&nbsp;
			        </c:when>
			        <c:otherwise>
			            [◀◀]&nbsp;[◀]&nbsp;
			        </c:otherwise>
		     	</c:choose>
		        <c:forEach var="i" begin="${fromPage }" end="${toPage }">
		        <c:choose>
		        	<c:when test = "${i == pg }">
		        		[${i }]&nbsp;
		        	</c:when> 	
		        	<c:otherwise>
		        		[<a href="manage.go?pg=${i }">${i }</a>]&nbsp;
		        	</c:otherwise>
		        </c:choose>
		        </c:forEach>
		        <c:choose>
		        	<c:when test = "${toPage < allPage }">
		        		[<a href="manage.go?pg=${toPage + 1}">▶</a>]&nbsp;
		                [<a href="manage.go?pg=${allPage}">▶▶</a>]
		        	</c:when>
		        	<c:otherwise>
		        		[▶]&nbsp;[▶▶]
		        	</c:otherwise>       
		        </c:choose>
			</div>
			<div id="searchMenu">
				<img id="searchIcon" src="resources/img/search.png">
				<form action="search.go">
					<input name="searchWord" class="searchBar" placeholder="유치원 이름을 입력하세요" autocomplete="off"> 
					<button class="searchBtn">검색</button>
				</form>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${empty lists}">
				<table id="manageTbl">
				<tr><td>검색 결과가 없습니다.</td></tr>
				</table>
			</c:when>
			<c:otherwise>		
				<c:set var="num" value="${TotalCount - ((pg-1) * rowSize) }"/>
				<c:forEach var="s" items="${lists }">
					<table border="1" id="manageTbl">
						<tr>
							<th rowspan="4">${num }</th>
							<th>유치원 이름</th>
							<th>원장님(아이디)</th>
							<th>연락처</th>
							<th>관리</th>
						</tr>
						<tr>
							<td>${s.dA_schoolname }</td>
							<td>${s.dA_name }(${s.dA_id })</td>
							<td>${s.dA_phonenumber }</td>
							<td rowspan="3"><button class="manageDelete" onClick="deleteSchool(${s.dA_no})">삭제</button></td>
						</tr>
						<tr>				
							<th rowspan="3">주소</th>
						</tr>
						<tr>				
							<td rowspan="3" colspan="2">${s.dA_addr }</td>
						</tr>
					</table>
					<c:set var="num" value="${num-1 }"></c:set>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
</section>

</body>
</html>