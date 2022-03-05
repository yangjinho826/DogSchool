<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 id="mtitle">회원가입</h1>
		<form action="member.usignup" method="post" name="myForm" onsubmit="return membercall()">
			
			<div id="memberh3">
				<h2 id="memberid">아이디</h2> 
				<span class="box int_"> 
				<input id="id_Input" name="id" class="int" placeholder="필수, 영어/숫자만" maxlength="15" autocomplete="off">
				<input id="id2" name="id2" value="0" type="hidden"><br>
				</span>
				<br>
				<span id = "idcheck" class="int"></span>
			</div>
			
			<div></div>
			<div id="memberh3">
				<h2 id="memberid">비밀번호 </h2>
				<span class="box int_"> 
				<input id="pw" name="pw" class="int" type="password" placeholder="필수, 영어/숫자만" maxlength="15" autocomplete="off">
				</span>
			</div>
			<br>
			
			<div id="memberh3">
				<h2 id="memberid">비밀번호 확인 </h2>
				<span class="box int_"> 
				<input id="pw1" name="pw1" class="int" type="password" placeholder="필수, 영어/숫자만" maxlength="15" autocomplete="off">
				</span>
				<br>
				<span id = "pwcheck" class="pwcheck"></span>
			</div>
			
			<div id="memberh3">
				<h2 id="memberid">이름</h2> 
				<span class="box int_"> 
				<input name="name" class="int" placeholder="필수, 한글만" maxlength="10" autocomplete="off">
				</span>
			</div>
			<br>
			
			<div id="memberh3">
				<h2 id="memberid">휴대전화번호</h2>
				<span class="box int_"> 
	            <select name="phonefirst" class="phonefirst">
	                   <option value="010">010</option>
	                   <option value="011">011</option>
	                   <option value="016">016</option>
	                   <option value="017">017</option>
	                   <option value="018">018</option>
	                   <option value="019">019</option>
	            </select>
	            - <input class="phonesecond" name="phonesecond" maxlength='4' style="width:50px;" >
	            - <input class="phonethird" name="phonethird" maxlength='4' style="width:50px;">
	            <input id="phonenumbercheck" name="phonenumber" value="0" type="hidden"><br>
				</span>
				<span id="numbercheck"></span>
			</div>
			<br>
			
			<div id="memberh3">
				<h2 id="memberid">성 별</h2> 
				<span class="box int_"> 
					남<input name="gender" type="radio" checked="checked" value="man">
					 여<input name="gender" type="radio" value="woman">
				</span>
			</div>
			<br>
			
			<div class="btn_area">
				<button name="type" id="btnJoin" type="submit" value="${param.type}">가입하기</button>
			</div>
			
		</form>

</body>
</html>