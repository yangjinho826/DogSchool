<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<section id="postscript_Detail">
		<section class="postscript_Detail">
			<h1 class="postscript_title">유치원 후기</h1>
			<div class="postscript_Detail_title">
				<div class="postscript_Detail_title"><h1 class="postscript_Detail_smtitle">${rv.r_title }</h1></div>
			</div>
			<section id="postscript_Detail_body">
				<div class="postscript_Detail_body">
					<div>작성자 : ${rv.r_id }</div>
					<div>작성일 : <fmt:formatDate value="${rv.r_date }" type="both" dateStyle="short" timeStyle="short"/></div>
				</div>
				<div class="postscript_Detail_bodytitle">${rv.r_txt }</div>
			</section>
		</section>
		<section id="postscript_Detail_Button">
			<div class="postscript_Detail_Button">
				<button class="postscript_Detail_Btn" onclick="location.href='review.go'">목록</button>
			</div>
			<div class="postscript_Detail_Button">
				<c:if test="${memberName eq rv.r_id}">
					<button class="postscript_Detail_Btn" onclick="review_UpdatePageGo(${review.r_no});">수정</button>
					<button id="review_Delete" class="postscript_Detail_Btn" value="${review.r_no }">삭제</button>
				</c:if>
			</div>
		</section>
	</section>
</body>
</html>