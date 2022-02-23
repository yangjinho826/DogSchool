<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="postscript_write">
		<section class="postscript_write">
			<div class="postscript_write_title">
				<h1 class="postscript_write_title">유치원 후기 작성</h1>
			</div>
		</section>
		<section id="postscript_write_body">
			<form action="review.write" name ="myForm" onsubmit="return review_call()" method="post" >
				<div class="postscript_write_input">
					<input name="token" value="${token }" hidden="hidden">
					<input name="r_schoolName" value="${Schoolname }" hidden="hidden">
					<input name="uA_no" value="${param.uA_no }" hidden="hidden">	
					<span class="postscript_write_input_w">제목</span>
					<input name="r_title" class="r_title">
				</div>
				<div class="postscript_write_input">
					<span class="postscript_write_input_w">내용</span>
					<textarea id="summernote" name="r_txt"></textarea>
				</div>
				<section id="postscript_write_btn">
					<div>
						<button type="button" onclick="location.href='review.go'" class="postscript_write_btn">목록</button>
					</div>
					<div>
						<button class="postscript_write_btn">작성하기 </button>
					</div>
				</section>
			</form>
		</section>
	</section>
</body>
</html>