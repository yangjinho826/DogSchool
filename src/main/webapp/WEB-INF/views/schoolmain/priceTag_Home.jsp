<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/priceTag.js"></script>
<link rel="stylesheet" href="resources/css/priceTag.css"/>
</head>
<body>
	<section id="priceTag_Home">
		<section class="priceTag_Home">
			<h1 class="priceTag_title"> 가격표 </h1>
			<c:choose> 
				<c:when test="${memberTypee eq '2'}">
					<button class="priceTag_writebtn" onclick="pricewriteWindow();">작성하기</button>
				</c:when>
				<c:when test="${memberTypee eq '3'}">
					<button class="priceTag_writebtn" onclick="pricewriteWindow();">작성하기</button>
				</c:when>
			</c:choose>
		</section>
		<section id="priceTag_Body">
		
			<div class="priceTag_table_title">대형견</div>
			<table class="priceTag">
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '대형견'}">
						<c:choose> 
							<c:when test="${memberTypee eq '2'}">
								<td class="priceTag_table_day"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a></td>
							</c:when>
							<c:when test="${memberTypee eq '3'}">
								<td class="priceTag_table_day"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a></td>
							</c:when>
							<c:otherwise>
								<td class="priceTag_table_day">${pT.p_date }일</td>
							</c:otherwise>
						</c:choose>
					</c:if>
					</c:forEach>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '대형견'}">
						<td class="priceTag_table_price"> ${pT.p_price }원 </td>
					</c:if>
					</c:forEach>
				</tr>
			</table>
			
			<div class="priceTag_table_title">중형견</div>
			<table class="priceTag">
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '중형견'}">
						<c:choose> 
							<c:when test="${memberTypee eq '2'}">
								<td class="priceTag_table_day"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a></td>
							</c:when>
							<c:when test="${memberTypee eq '3'}">
								<td class="priceTag_table_day"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a></td>
							</c:when>
							<c:otherwise>
								<td class="priceTag_table_day">${pT.p_date }일</td>
							</c:otherwise>
						</c:choose>
					</c:if>
					</c:forEach>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '중형견'}">
						<td class="priceTag_table_price"> ${pT.p_price }원 </td>
					</c:if>
					</c:forEach>
				</tr>
			</table>
			
			<div class="priceTag_table_title">소형견 </div>
			<table class="priceTag">
				<tr class="priceTag_tr">
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '소형견'}">
						<c:choose> 
							<c:when test="${memberTypee eq '2'}">
								<td class="priceTag_table_day"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a></td>
							</c:when>
							<c:when test="${memberTypee eq '3'}">
								<td class="priceTag_table_day"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a></td>
							</c:when>
							<c:otherwise>
								<td class="priceTag_table_day">${pT.p_date }일</td>
							</c:otherwise>
						</c:choose>
					</c:if>
					</c:forEach>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '소형견'}">
						<td class="priceTag_table_price"> ${pT.p_price }원 </td>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</section>
	</section>
</body>
</html>