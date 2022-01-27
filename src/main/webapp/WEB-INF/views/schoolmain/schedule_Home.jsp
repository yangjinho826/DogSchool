<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/schedule.js"></script>
</head>
<body>

<section id="schedule_home">
	<section id="schedule_button">
		<div class="schedule_button">
			<h1 class="schedule_title"> ${r }유치원 캘린더 </h1>
			<button class="schedule_writebtn" onclick="schedulewriteWindow();">작성하기</button>
		</div>
	</section>
	<section id="schedule_Body">
		<div class="schedule_main">
		<h3 class="schedule_month">1월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '1월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">2월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '2월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">3월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '3월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">4월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '4월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">5월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '5월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">6월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '6월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">7월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '7월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">8월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '8월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">9월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '9월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">10월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '10월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">11월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '11월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month">12월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '12월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
	</section>
</section>


</body>
</html>