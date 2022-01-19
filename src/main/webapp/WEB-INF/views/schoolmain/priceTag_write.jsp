<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/priceTag.js"></script>
</head>
<body>
	<section id="priceTag_write">
		<section class="priceTag_write">
			<div class="priceTag_write_title">
				<h1 class="priceTag_write_title">가격표 작성</h1>
			</div>
		</section>
		<section id="priceTag_write_body">
			<form action="priceTag.write" name="popupForm" >
				<div class="priceTag_write_input">
						<span class="priceTag_write_input_w">강아지 종류 </span>
					<div>
						<input type="radio" name="p_Dogkind" value="대형견" checked>
						<label for="BigDog">대형견</label>
						<input type="radio" name="p_Dogkind" value="중형견">
						<label for="MiddleDog">중형견</label>
						<input type="radio" name="p_Dogkind" value="소형견">
						<label for="SmallDog">소형견</label>
					</div>
				</div>
				<div class="priceTag_write_input">
						<span class="priceTag_write_input_w">가격 </span>
						<input type="number" name="p_price" placeholder="1000원 이상 입력" min="0">원
				</div>
				<div class="priceTag_write_input">
						<span class="priceTag_write_input_w">날짜 </span>
						<input type="number" name="p_date" placeholder="1일 이상 입력" min="1">일
				</div>
			</form>
			<section id="priceTag_write_btn">
					<div>
						<button class="priceTag_write_btn" onclick="closeWithSubmit();">작성하기 </button>
					</div>
			</section>
		</section>
	</section>
</body>
</html>