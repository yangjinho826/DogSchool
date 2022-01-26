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
		<section class="notice_write">
			<div class="notice_write_title">
				<h1 class="notice_write_title">공지사항 작성</h1>
			</div>
		</section>
		<section id="notice_write_body">
			<form action="notice.write" name ="myForm" onsubmit="return callnotice()" >
				<div class="notice_write_input">
					<span class="notice_write_input_w">제목</span>
					<input name="n_title" class="n_title">
				</div>
				<div class="notice_write_input">
					<span class="notice_write_input_w">내용</span>
					<textarea id="summernote" name="n_txt"></textarea>
				</div>
				<section id="notice_write_btn">
					<div>
						<button type="button" onclick="location.href='notice.go'" class="notice_write_btn">목록</button>
					</div>
					<div>
						<button class="notice_write_btn">작성하기 </button>
					</div>
				</section>
			</form>
		</section>
	</section>
</body>
</html>