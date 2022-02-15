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
<link rel="stylesheet" href="resources/css/schedule.css"/>
</head>
<body>

<section id="schedule_home">
	<section class="schedule_home">
		<h1 class="schedule_title"> ${r }유치원 캘린더 </h1>
		<c:choose>
			<c:when test="${memberTypee eq '2'}">
			<c:if test="${TCheck.ta_da_no eq getSchoolSession.da_no}">
				<button class="schedule_writebtn" onclick="schedulewriteWindow();">작성하기</button>
			</c:if>
			</c:when>
			<c:when test="${memberTypee eq '3'}">
			<c:if test="${DCheck.da_no eq getSchoolSession.da_no}">
				<button class="schedule_writebtn" onclick="schedulewriteWindow();">작성하기</button>
			</c:if>
			</c:when>
			</c:choose>
	</section>
	<section id="schedule_Body">
		<div class="schedule_main">
			<h3 class="schedule_month_title">01월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '01월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">02월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '02월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">03월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '03월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">04월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '04월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">05월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '05월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">06월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '06월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>

	</section>
	<section id="schedule_Body">
		<div class="schedule_main">
		<h3 class="schedule_month_title">07월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '07월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">08월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '08월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">09월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '09월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">10월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '10월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">11월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '11월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">· ${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">· ${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
		<div class="schedule_main">
		<h3 class="schedule_month_title">12월</h3>
		<c:forEach var="s" items="${sh }">
		  	<c:if test="${s.s_month eq '12월'}">
			<div class="schedule_month_body">
				<span class="schedule_month_day"><fmt:formatDate value="${s.s_day }" pattern="YY-MM-dd"/></span>
				<c:choose> 
					<c:when test="${memberTypee eq '2'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
					</c:when>
					<c:when test="${memberTypee eq '3'}">
						<span class="schedule_month_text"><a href="#" onclick="scheduleDetailWindow(${s.s_no});">${s.s_text }</a></span>
					</c:when>
					<c:otherwise>
						<span class="schedule_month_text">${s.s_text }</span>
					</c:otherwise>
				</c:choose>
			</div>
		  	</c:if>
		</c:forEach>
		</div>
	</section>
	
</section>


</body>
</html>