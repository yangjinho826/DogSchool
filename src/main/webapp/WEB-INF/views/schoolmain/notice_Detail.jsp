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
	<section id="notice_Detail">
		<span class="notice_title">게시물</span>
		<div class="notice_Detail_title">
			
			<div class="notice_Detail_title">${note.n_title }</div>
		</div>
		<div class="notice_Detail_body">
			
			<div>작성자 : ${note.n_id }</div>
			<div>작성일 : <fmt:formatDate value="${note.n_date }" type="both" dateStyle="short" timeStyle="short"/></div>
			<div>${note.n_txt }</div>
		</div>
	</section>
	<section id="notice_Detail_Button">
		<div class="notice_Detail_Button">
			<button onclick="location.href='notice.go'">목록</button>
		</div>
		<div class="notice_Detail_Button">
			<button onclick="notice_UpdatePageGo(${notice.n_no});">수정</button>
		</div>
		<div class="notice_Detail_Button">
			<button onclick="notice_Delete(${notice.n_no});">삭제</button>
		</div>
	</section>

</body>
</html>