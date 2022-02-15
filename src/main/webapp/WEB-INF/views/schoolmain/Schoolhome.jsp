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
	<section id="Schoolhome">
		 <section class="Schoolhome_body">
			<article id="Schoolhome_notice">
			<h2 class="Schoolhome_title"><a href="notice.go">공지사항</a></h2>
			<table class="Schoolhome_notice">
				<c:forEach var="f" items="${fivenote }">
						<tr class="Schoolhome_notice_tr">
						 <td class="Schoolhome_notice_td" style="width:50%;">${f.n_title }</td>
						 <td class="Schoolhome_notice_td" style="width:20%;">${f.n_id }</td>
						 <td class="Schoolhome_notice_td" style="width:30%;"><fmt:formatDate value="${f.n_date }" type="both" dateStyle="short" timeStyle="short"/></td>
						</tr>
				</c:forEach>
			</table>
			</article >
			
			<article id="Schoolhome_priceTag">
				<h2 class="Schoolhome_title"><a href="priceTag.go">가격표</a></h2>
				<section id="Schoolhome_priceTag">
				
				<div class="Schoolhome_priceTag_title"> ${BigDog } </div>
				<table class="Schoolhome_priceTag">
					<tr class="Schoolhome_priceTag_tr">
						<c:forEach var="pT" items="${priceTags }">
						<c:if test="${pT.p_Dogkind eq '대형견'}">
							<td class="Schoolhome_priceTag_td">${pT.p_date }일</td>
						</c:if>
						</c:forEach>
					</tr>
					<tr class="Schoolhome_priceTag_tr">
						<c:forEach var="pT" items="${priceTags }">
						<c:if test="${pT.p_Dogkind eq '대형견'}">
							<td class="Schoolhome_priceTag_td"> ${pT.p_price }원 </td>
						</c:if>
						</c:forEach>
					</tr>
				</table>
				
				<div class="Schoolhome_priceTag_title"> ${MiddleDog } </div>
				<table class="Schoolhome_priceTag">
					<tr class="Schoolhome_priceTag_tr">
						<c:forEach var="pT" items="${priceTags }">
						<c:if test="${pT.p_Dogkind eq '중형견'}">
							<td class="Schoolhome_priceTag_td">${pT.p_date }일</td>
						</c:if>
						</c:forEach>
					</tr>
					<tr class="Schoolhome_priceTag_tr">
						<c:forEach var="pT" items="${priceTags }">
						<c:if test="${pT.p_Dogkind eq '중형견'}">
							<td class="Schoolhome_priceTag_td"> ${pT.p_price }원 </td>
						</c:if>
						</c:forEach>
					</tr>
				</table>
				
				<div class="Schoolhome_priceTag_title"> ${SmallDog } </div>
				<table class="Schoolhome_priceTag">
					<tr class="Schoolhome_priceTag_tr">
						<c:forEach var="pT" items="${priceTags }">
						<c:if test="${pT.p_Dogkind eq '소형견'}">
							<td class="Schoolhome_priceTag_td">${pT.p_date }일</td>
						</c:if>
						</c:forEach>
					</tr>
					<tr class="Schoolhome_priceTag_tr">
						<c:forEach var="pT" items="${priceTags }">
						<c:if test="${pT.p_Dogkind eq '소형견'}">
							<td class="Schoolhome_priceTag_td"> ${pT.p_price }원 </td>
						</c:if>
						</c:forEach>
					</tr>
				</table>
			</section>
				
			</article >
			
			<article id="Schoolhome_postscript">
				<h2 class="Schoolhome_title"><a href="postscript.go">선생님 후기</a></h2>
				<table class="Schoolhome_postscript">
				<c:forEach var="fp" items="${fivepostscript }">
					<tr class="Schoolhome_postscript_tr">
					 <td class="Schoolhome_postscript_td" style="width:50%;">${fp.p_title }</td>
					 <td class="Schoolhome_postscript_td" style="width:20%;">${fp.p_id }</td>
					 <td class="Schoolhome_postscript_td" style="width:30%;"><fmt:formatDate value="${fp.p_date }" type="both" dateStyle="short" timeStyle="short"/></td>
					</tr>
				</c:forEach>
				</table>
			</article >
		</section>
		<section class="SchoolHome_aside">
			<aside class="Schoolhome_schedule">
				<c:if test="${mon eq '01월'}">
					<div class="schedule_main">
						<h3 class="schedule_month_title"><a href="schedule.go">01월</a></h3>					
						<c:forEach var="ms" items="${ms }">	
							<div class="schedule_month_body">
								<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
								<span class="schedule_month_text">· ${ms.s_text }</span>
							</div>
						</c:forEach>	
					</div>
				</c:if>
				<c:if test="${mon eq '02월'}">
					<div class="schedule_main">
						<h3 class="Schoolhome_aisdetitle"><a href="schedule.go">02월</a></h3>					
						<c:forEach var="ms" items="${ms }">	
							<div class="schedule_month_body">
								<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
								<span class="schedule_month_text">· ${ms.s_text }</span>
							</div>
						</c:forEach>	
					</div>
				</c:if>
				<c:if test="${mon eq '03월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">03월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '04월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">04월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '05월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">05월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '06월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">06월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '07월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">07월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '08월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">08월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '09월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">09월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '10월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">10월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '11월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">11월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
		<c:if test="${mon eq '12월'}">
			<div class="schedule_main">
				<h3 class="schedule_month_title"><a href="schedule.go">12월</a></h3>					
				<c:forEach var="ms" items="${ms }">	
					<div class="schedule_month_body">
						<span class="schedule_month_day"><fmt:formatDate value="${ms.s_day }" pattern="YY-MM-dd"/></span>
						<span class="schedule_month_text">· ${ms.s_text }</span>
					</div>
				</c:forEach>	
			</div>
		</c:if>
			</aside>
		</section>
	</section>
	

</body>
</html>