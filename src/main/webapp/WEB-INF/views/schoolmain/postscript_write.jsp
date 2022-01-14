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
				<h1 class="postscript_write_title">선생님후기 작성</h1>
			</div>
		</section>
		<section id="postscript_write_body">
			<form action="postscript.write" name ="myForm" onsubmit="return call()" method="post" >
				<div class="postscript_write_input">
					<span class="postscript_write_input_w">제목</span>
					<input name="p_title" class="postscript">
				</div>
				<div class="postscript_write_input">
					<span class="postscript_write_input_w">내용</span>
					<textarea id="summernote" name="p_txt"></textarea>
				</div>
				<section id="postscript_write_btn">
					<div>
						<button type="button" onclick="location.href='postscript.go'" class="postscript_write_btn">목록</button>
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