<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/priceTag.js"></script>
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
			<form action="priceTag.Update" name="popupForm2" onsubmit="return callme1()">
				<div class="priceTag_write_input">
						<span class="priceTag_write_input_w">강아지 종류 : </span>
						<label for="BigDog">${pTag.p_Dogkind }</label>
						<input name="p_no" value="${pTag.p_no }" type="hidden">
				</div>
				<div class="priceTag_write_input">
						<span class="priceTag_write_input_w">가격 </span>
						<input type="number" name="p_price" id="p_price" placeholder="1000원 이상 입력"value="${pTag.p_price }">원
				</div>
				<div class="priceTag_write_input">
						<span class="priceTag_write_input_w">날짜 </span>
						<input type="number" name="p_date" placeholder="1일 이상 입력" value="${pTag.p_date }">일
				</div>
				<div>	<button class="priceTag_write_btn">수정 </button></div>
			</form>
			<section id="priceTag_write_btn" >
			<form action="priceTag.Delete" name="popupForm1" >
					<input name="p_no" value="${pTag.p_no }" type="hidden">
			</form>
					<div>
						<button class="priceTag_write_btn" onclick="closeWithDSubmit();">삭제 </button>
					</div>
			</section>
		</section>
	</section>
</body>
</html>