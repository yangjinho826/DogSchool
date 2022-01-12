<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="applyHomeArea">
	
		<!-- if 원장 권한 로그인 시 -->
		<form action="apply.school">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td colspan="2" align="center">유치원 신청 양식</td>
				</tr>
				<tr>
					<td class="td1">원장 아이디</td>
					<td class="td2"><input name="Da_id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="td1">원장 이름</td>
					<td class="td2"><input name="Da_name" placeholder="이름"></td>
				</tr>
				<tr>
					<td class="td1">유치원 이름</td>
					<td class="td2"><input name="Da_schoolname" placeholder="유치원 이름"></td>
				</tr>
				<tr>
					<td class="td1">유치원 주소</td>
					<td class="td2">
						<input id="m_addr3Input" readonly="readonly" name="Da_addr3" maxlength="5" autocomplete="off" placeholder="우편번호">
						<span id="addrSearchBtn">[검색]</span><br>
						<input id="m_addr1Input" readonly="readonly" name="Da_addr1" maxlength="30" autocomplete="off" placeholder="주소"><br>
						<input name="Da_addr2" maxlength="30" autocomplete="off" placeholder="상세주소">
					</td>
				</tr>
				<tr>
					<td class="td1">원장 연락처</td>
					<td class="td2"><input name="Da_phonenumber" placeholder="연락처"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><button>신청하기</button></td>
				</tr>
			</table>
		</form>
		<br>
		
		
		<!-- if 선생님 권한 로그인 시 -->
		<form action="apply.teacher">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td colspan="2" align="center">선생님 신청 양식</td>
				</tr>
				<tr>
					<td class="td1">유치원 선택</td>
					<td class="td2">유치원목록ex콤보박스 임시 input <input name="Ta_da_no"></td>
				</tr>
				<tr>
					<td class="td1">선생님 아이디</td>
					<td class="td2"><input name="Ta_id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="td1">선생님 이름</td>
					<td class="td2"><input name="Ta_name" placeholder="이름"></td>
				</tr>
				<tr>
					<td class="td1">연락처</td>
					<td class="td2"><input name="Ta_phonenumber" placeholder="연락처"></td>
				</tr>
				<tr>
					<td class="td1">성별</td>
					<td class="td2">
						<select name="Ta_gender">
							<option value="남">남</option>
							<option value="여">여</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">자기소개</td>
					<td class="td2"><textarea name="Ta_text"></textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><button>신청하기</button></td>
				</tr>
			</table>
		</form>
		<br>
		
		
		<!-- if 견주 권한 로그인 시 -->
		<form action="apply.pet" method="post" enctype="multipart/form-data">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td colspan="2" align="center">강아지 신청 양식</td>
				</tr>
				<tr>
					<td class="td1">유치원 선택</td>
					<td class="td2">유치원목록(콤보박스): 임시 input <input name="Ua_da_no"></td>
				</tr>
				<tr>
					<td class="td1">견주 아이디</td>
					<td class="td2"><input name="Ua_id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="td1">강아지 이름</td>
					<td class="td2"><input name="Ua_name" placeholder="이름"></td>
				</tr>
				<tr>
					<td class="td1">강아지 성별</td>
					<td class="td2">
						<select name="Ua_gender">
							<option value="남">수컷</option>
							<option value="여">암컷</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">기간</td>
					<td class="td2"><input type="text" name="Ua_daterange"></td>
				</tr>
				<tr>
					<td class="td1">강아지 나이</td>
					<td class="td2"><input name="Ua_age"></td>
				</tr>
				<tr>
					<td class="td1">강아지 이미지</td>
					<td class="td2"><input type="file" name="Ua_img"></td>
				</tr>
				<tr>
					<td class="td1">희망 선생님 선택</td>
					<td class="td2">해당유치원선생님목록(콤보박스): 임시 input <input name="Ua_tname"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><button>신청하기</button></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>