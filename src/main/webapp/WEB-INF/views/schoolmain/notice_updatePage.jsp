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
	<form action="notice.update" name ="myForm" onsubmit="return notice_call2()" method="post" >
		<section id="notice_update">
			<section class="notice_update">
				<h1 class="notice_update_title">게시물 수정</h1>
				<div class="notice_update_title">
						<span class="notice_update_input_w">제목</span>
						<input class="notice_update_input_w" name="n_title" value="${note.n_title }">
				</div>
				    <input name="n_no" value="${note.n_no }" type="hidden">
				<div class="notice_update_body">
					<section class="notice_update_smalltitle">
					<div>작성자 : ${note.n_id }</div>
					<div>작성일 : <fmt:formatDate value="${note.n_date }" type="both" dateStyle="short" timeStyle="short"/></div>
					</section>
					<textarea id="summernote" name="n_txt" >${note.n_txt }</textarea>
				</div>
			</section>
			<section id="notice_update_Button">
				<div class="notice_update_Button">
					<button type="button" onclick="location.href='notice.go'" class="notice_update_btn">목록</button>
				</div>
				<div class="notice_update_Button">
					<button class="notice_update_btn">확인</button>
				</div>
			</section>
		</section>
	</form>
</body>
</html>