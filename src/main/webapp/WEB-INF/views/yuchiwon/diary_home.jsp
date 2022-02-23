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
	<section id="diary_Home">
		<section class="diary_Home">
			<h1 class="diary_title">알림장</h1>
			<c:if test="${sessionScope.loginMember.typee ==  2}">
				<button onclick="writeDiaryGo()">작성하기</button>
			</c:if>
		</section>
		<section id="diary_Body">
		<c:set var="num" value="${TotalCount - ((pg-1) * rowSize) }" />
		<c:forEach var="d" items="${diaries }">
			<table class="diary">
				<tr>
					<td>제목 : ${d.mp_title }</td>
				</tr>
				<tr>
					<td>건강상태 : ${d.mp_condition }</td>
				</tr>
				<tr>
					<td>식사량 : ${d.mp_meal }</td>
				</tr>
				<tr>
					<td>배변 횟수 : ${d.mp_defecate }</td>
				</tr>
				<tr>
					<td>준비물 : ${d.mp_supplies }</td>
				</tr>
				<tr>
					<td>내용 : ${d.mp_txt }</td>
				</tr>
				<tr>
					<td>작성자 : ${d.mp_tid }</td>
				</tr>
				<tr>
					<td>날짜 : ${d.mp_date } <input type="hidden"
						value="${d.mp_uid }" class="uid"> <input type="hidden"
						value="${d.mp_uname }" class="uname">
					</td>
				</tr>

				<c:forEach var="dr" items="${d.mp_replys }">
					<tr>
						<td>${dr.r_owner }</td>
						<td>${dr.r_txt }</td>
						<td>(<fmt:formatDate value="${dr.r_when }" type="both"
								dateStyle="short" timeStyle="short" />)
						</td>
						<td><c:if
								test="${sessionScope.loginMember.id == dr.r_owner }">
								<button onclick="deleteReply(${dr.r_no});">삭제</button>
							</c:if> <br></td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="diary.reply.write">
							<input type="hidden" name="r_mp_no" value="${d.mp_no }">
							<input type="hidden" name="r_owner" value="${dr.r_owner }">
							<input name="r_txt" maxlength="80" autocomplete="off">
							<button>쓰기</button>
						</form>
					</td>
				</tr>
				<c:if test="${sessionScope.loginMember.id == d.mp_tid}">
					<tr>
						<td>
							<button onclick="updateDiary(${d.mp_no})">수정</button>
							<button onclick="deleteDiary(${d.mp_no})">삭제</button>
						</td>
					</tr>
				</c:if>
			</table>
			<c:set var="num" value="${num-1 }"></c:set>
		</c:forEach>
		</section>

		<table id="diary_paging">
			<tr>
				<td>
				<c:choose>
				<c:when test="${pg > block}">
	            	[<a href="yuchiwon.get.alldiary?pg=1">◀◀</a>]
	            	[<a href="yuchiwon.get.alldiary?pg=${fromPage -1}">◀</a>] 
	        	</c:when>

				<c:otherwise>
	            	[<span style="color: gray">◀◀</span>]   
	            	[<span style="color: gray">◀</span>]
	        	</c:otherwise>
				</c:choose>
				
				<c:forEach var="i" begin="${fromPage }" end="${toPage }">
					${i }
					<%-- <c:choose>
					<c:when test="${i == pg }">
	        			[${i }]
	        		</c:when>

					<c:otherwise>
	        			[<a href="yuchiwon.get.alldiary?pg=${i }">${i }</a>]
	        		</c:otherwise>
					</c:choose> --%>
				</c:forEach>
					
				<c:choose>
					<c:when test="${toPage < allPage }">
	        			[<a href="yuchiwon.get.alldiary?pg=${toPage + 1}">▶</a>]
	                	[<a href="yuchiwon.get.alldiary?pg=${allPage}">▶▶</a>]
	        		</c:when>
	        		
					<c:otherwise>
	        			[<span style="color: gray">▶</span>]
	                	[<span style="color: gray">▶▶</span>]
	        		</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</table>
	</section>
</body>
</html>