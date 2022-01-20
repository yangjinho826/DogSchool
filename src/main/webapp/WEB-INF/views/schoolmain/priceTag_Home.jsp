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
</head>
<body>
	<section id="priceTag_Home">
		<section class="priceTag_Home">
			<h1 class="priceTag_title"> 가격표 </h1>
			<button class="priceTag_writebtn" onclick="pricewriteWindow();">작성하기</button>
		</section>
		<section id="priceTag_Body">
			<table class="priceTag">
				<tr class="priceTag_tr">
					<td class="priceTag_table_title"> ${BigDog } </td>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '대형견'}">
						<td class="priceTag_table_title"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a> </td>
					</c:if>
					</c:forEach>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '대형견'}">
						<td class="priceTag_table_title"> ${pT.p_price }원 </td>
					</c:if>
					</c:forEach>
				</tr>
			</table>
			<table class="priceTag">
				<tr class="priceTag_tr">
					<td class="priceTag_table_title"> ${MiddleDog } </td>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '중형견'}">
						<td class="priceTag_table_title"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a> </td>
					</c:if>
					</c:forEach>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '중형견'}">
						<td class="priceTag_table_title"> ${pT.p_price }원 </td>
					</c:if>
					</c:forEach>
				</tr>
			</table>
			<table class="priceTag">
				<tr class="priceTag_tr">
					<td class="priceTag_table_title"> ${SmallDog } </td>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '소형견'}">
						<td class="priceTag_table_title"><a href="#" onclick="priceDetailWindow(${pT.p_no});">${pT.p_date }일</a> </td>
					</c:if>
					</c:forEach>
				</tr>
				<tr class="priceTag_tr">
					<c:forEach var="pT" items="${priceTags }">
					<c:if test="${pT.p_Dogkind eq '소형견'}">
						<td class="priceTag_table_title"> ${pT.p_price }원 </td>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</section>
	</section>
</body>
</html>