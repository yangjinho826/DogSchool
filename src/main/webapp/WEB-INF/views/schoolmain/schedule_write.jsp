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
				<h1 class="schedule_write_title">캘린더 작성</h1>
			</div>
		</section>
		<section id="schedule_write_body">
			<form action="schedule.write" name="popupForm" onsubmit="return call_schedule()">

				<div class="schedule_write_input">
						<span class="schedule_write_input_w">날 짜 </span>
						<input id="datepicker1" class="schedule" name="s_day">
				</div>
				<div class="schedule_write_input">
						<span class="schedule_write_input_w">내 용 </span>
						<input type="text" class="schedule" name="s_text" placeholder="20자 이하로 입력하세요.">
				</div>
					<div>
						<button class="schedule_write_btn">작 성 </button>
					</div>
			</form>
		</section>
	</section>
</body>
</html>