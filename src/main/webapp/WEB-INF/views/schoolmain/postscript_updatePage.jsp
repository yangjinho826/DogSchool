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
	<form action="postscript.update" name ="myForm" onsubmit="return postscript_call()" method="post" >
		<section id="postscript_update">
			<section class="postscript_update">
				<h1 class="postscript_update_title">선생님 후기 수정</h1>
				<div class="postscript_update_title">
						<span class="postscript_update_input_w">제목</span>
						<input class="postscript_update_input_w" name="p_title" value="${ps.p_title }">
				</div>
				    <input name="p_no" value="${ps.p_no }" type="hidden">
				<div class="postscript_update_body">
					<section class="postscript_update_smalltitle">
					<div>작성자 : ${ps.p_id }</div>
					<div>작성일 : <fmt:formatDate value="${ps.p_date }" type="both" dateStyle="short" timeStyle="short"/></div>
					</section>
					<textarea id="summernote" name="p_txt" >${ps.p_txt }</textarea>
				</div>
			</section>
			<section id="postscript_update_Button">
				<div class="postscript_update_Button">
					<button type="button" onclick="location.href='postscript.go'" class="postscript_update_btn">목록</button>
				</div>
				<div class="postscript_update_Button">
					<button class="postscript_update_btn">확인</button>
				</div>
			</section>
		</section>
	</form>
</body>
</html>