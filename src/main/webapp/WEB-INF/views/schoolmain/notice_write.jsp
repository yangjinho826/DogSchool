<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="notice_write">
		<div id="notice_write_title">
			<h1 class="notice_write_title">공지사항 작성</h1>
		</div>
	</section>
	<section id="notice_write_body">
		<form action="notice.write" name ="myForm" onsubmit="return call()" method="post" >
			<div class="notice_write_input">
				<span>제목</span>
				<input name="n_title">
			</div>
			<div class="notice_write_input">
				<span>공지사항</span>
				<textarea id="summernote" name="n_txt"></textarea>
			</div>
			<div>
				<button>작성하기 </button>
			</div>
		</form>
	</section>
</body>
</html>