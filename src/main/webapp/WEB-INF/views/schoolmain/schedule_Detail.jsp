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
</head>
<body>
	<section id="priceTag_write">
		<section class="priceTag_write">
			<div class="priceTag_write_title">
				<h1 class="priceTag_write_title">가격표 수정</h1>
			</div>
		</section>
		<section id="priceTag_write_body">
			<form action="schedule.update" name="popupForm2" onsubmit="return call_schedule1()">
					<div class="schedule_write_input">
						<span class="schedule_write_input_w">해당월 </span>
						<select name="s_month" >
							<option value = "1월"> 1월 </option>
							<option value = "2월"> 2월 </option>
							<option value = "3월"> 3월 </option>
							<option value = "4월"> 4월 </option>
							<option value = "5월"> 5월 </option>
							<option value = "6월"> 6월 </option>
							<option value = "7월"> 7월 </option>
							<option value = "8월"> 8월 </option>
							<option value = "9월"> 9월 </option>
							<option value = "10월"> 10월 </option>
							<option value = "11월"> 11월 </option>
							<option value = "12월"> 12월 </option>						
						</select>
				</div>
				<div class="schedule_write_input">
						<span class="schedule_write_input_w">날짜 </span>
						<input id="datepicker1" name="s_day" value="${sc.s_day}">
						<input name="s_no" value="${sc.s_no }" type="hidden">
				</div>
				<div class="schedule_write_input">
						<span class="schedule_write_input_w">내용 </span>
						<input type="text" name="s_text" value="${sc.s_text }" placeholder="20자 이하로 입력하세요.">
				</div>
				<div>	<button class="priceTag_write_btn">수정 </button></div>
			</form>
			<section id="priceTag_write_btn" >
			<form action="schedule.Delete" name="popupForm1" >
					<input name="s_no" value="${sc.s_no }" type="hidden">
			</form>
					<div>
						<button class="priceTag_write_btn" onclick="closeWithDSubmit();">삭제 </button>
					</div>
			</section>
	</section>
	</section>
</body>
</html>