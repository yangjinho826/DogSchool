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
	<h1 id="mtitle" >알림장</h1>

	<section id="diaryDetailArea">
	  <div id="dmemberh3">
	  	<h2 id="memberid">제목</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_title }" name="id" style='cursor:default;'>
		</span>
	  </div>
	  <div id="dmemberh3">
	  	<h2 id="memberid">건강상태</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_condition }" name="id" style='cursor:default;'>
		</span>
	  </div>
	  <div id="dmemberh3">
	  	<h2 id="memberid">식사횟수</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_meal }" name="id" style='cursor:default;'>
		</span>
	  </div>
	  <div id="dmemberh3">
	  	<h2 id="memberid">배변횟수</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_defecate }" name="id" style='cursor:default;'>
		</span>
	  </div>
	  <div id="dmemberh3">
	  	<h2 id="memberid">준비물</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_supplies }" name="id" style='cursor:default;'>
		</span>
	  </div>
	  <div id="dmemberh3">
	  	<h2 id="memberid">알림 내용</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_txt }" name="id" style='cursor:default;'>
		</span>
	  </div>
	  <div id="dmemberh3">
	  	<h2 id="memberid">등록 날짜</h2>
	  	<span class="box int_">  
			<input readonly onfocus="this.blur();" class="int" value="${d.mp_date }" name="id" style='cursor:default;'>
		</span>
	  </div>
	   <div id="dmemberh3">
	  	<span class="dbox">  
				<c:if test="${sessionScope.loginMember.typee ==  2}">
						<button name="mp_no"
							onclick="location.href='diary.update.go?mp_no=${d.mp_no}'"
							id="bbtnJoin">수정</button>
						<button name="mp_no" onclick="deleteDiary('${d.mp_no}')"
							id="bbtnJoin">삭제</button>
				</c:if>
				<button
						onclick="location.href='yuchiwon.get.puppy?uA_no=${sessionScope.puppies.uA_no }'"
						id="bbtnJoin">목록</button>
		</span>
	  </div>
	</section>
	

		
		<table class="diaryDetailTbl2" >
			<form action="diary.reply.write" name="replyForm" onsubmit="return replycall()">
				<tr>
					<td class="drWrite" colspan="2">
					  <input type="hidden" name="r_mp_no" value="${d.mp_no }"> 
					  <input type="hidden" name="r_owner" value="${sessionScope.loginMember.name }">
					  <input type="hidden" name="mp_no" value="${d.mp_no }"> 
					  <input hidden="hidden" name="token" value="${token }"> 
					  <input class="drInput" name="r_txt" maxlength="80" autocomplete="off">
					</td>
					<td class="drTd3">
							<button class="drBtn">댓글작성</button>
					</td>
				</tr>
			</form>

			<c:forEach var="dr" items="${d.mp_replys }">
				<tr class="drTr">
					<td class="drTd">${dr.r_txt }<span class="replys_time"><fmt:formatDate value="${dr.r_when }"
							type="date" dateStyle="short"/></span></td>
					<td class="drTd2">${dr.r_owner }</td>
					<td class="drTd3"><c:if
							test="${sessionScope.loginMember.name == dr.r_owner }">
							<button class="drButton" onclick="deleteReply(${dr.r_no}, ${d.mp_no });">삭제</button>
						</c:if></td>
				<tr>
			</c:forEach>
		</table>

</body>
</html>