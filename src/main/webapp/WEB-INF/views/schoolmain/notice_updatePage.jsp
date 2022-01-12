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
	<form action="notice.update" name ="myForm" onsubmit="return call()" method="post" >
		<section id="notice_Detail">
			<span>게시물</span>
			<div class="notice_Detail_title">
					<input name="n_title" value="${note.n_title }">
			</div>
			<div class="notice_Detail_body">
			    <input name="n_no" value="${note.n_no }" type="hidden">
				<div>작성자 : ${note.n_id }</div>
				<div>작성일 : <fmt:formatDate value="${note.n_date }" type="both" dateStyle="short" timeStyle="short"/></div>
				<span>공지사항</span>
				<textarea id="summernote" name="n_txt">${note.n_txt }</textarea>
			</div>
		</section>
		<section id="notice_Detail_Button">
			<div class="notice_Detail_Button">
				<button type="button" onclick="location.href='notice.go'">목록</button>
			</div>
			<div class="notice_Detail_Button">
				<button>확인</button>
			</div>
		</section>
	</form>
</body>
</html>