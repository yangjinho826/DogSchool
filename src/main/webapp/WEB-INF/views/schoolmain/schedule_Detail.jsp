<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/js/schedule.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<link rel="stylesheet" href="resources/css/schedule.css"/>
</head>
<body>
	<section id="schedule_write">
		<section class="schedule_write">
			<div class="schedule_write_title">
				<h1 class="schedule_write_title">캘린더 수정</h1>
			</div>
		</section>
		<section id="schedule_write_body">
			<form action="schedule.update" name="popupForm2" onsubmit="return call_schedule1()">

				<div class="schedule_write_input">
						<span class="schedule_write_input_w">날 짜 </span>
						<input id="datepicker1" class="schedule" name="s_day" value="${sc.s_day}">
						<input name="s_no" value="${sc.s_no }" type="hidden">
				</div>
				<div class="schedule_write_input">
						<span class="schedule_write_input_w">내 용 </span>
						<input type="text"class="schedule" name="s_text" value="${sc.s_text }" placeholder="20자 이하로 입력하세요.">
				</div>
				<div>	<button class="schedule_write_btn">수 정 </button></div>
			</form>
			<section id="schedule_write_btn" >
			<form action="schedule.Delete" name="popupForm1" >
					<input name="s_no" value="${sc.s_no }"  type="hidden">
			</form>
					<div>
						<button class="schedule_write_btn" onclick="closeWithDSubmit();">삭 제 </button>
					</div>
			</section>
	</section>
	</section>
</body>
</html>