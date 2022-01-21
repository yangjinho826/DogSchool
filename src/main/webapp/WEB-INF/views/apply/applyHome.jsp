<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td class="tdTitle" colspan="2" align="center">유치원 신청 양식</td>
				</tr>
				<tr>
					<td class="td1">원장 아이디</td>
					<td class="td2"><input name="Da_id" autocomplete="off" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="td1">원장 이름</td>
					<td class="td2"><input name="Da_name" autocomplete="off" placeholder="이름"></td>
				</tr>
				<tr>
					<td class="td1">유치원 이름</td>
					<td class="td2"><input name="Da_schoolname" autocomplete="off" placeholder="유치원 이름"></td>
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
					<td class="td2"><input name="Da_phonenumber" autocomplete="off" placeholder="연락처"></td>
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
					<td class="tdTitle" colspan="2" align="center">선생님 신청 양식</td>
				</tr>
				<tr>
					<td class="td1">유치원 선택</td>
					<td class="td2">
						<select id="selectOption" name="Ta_da_no">
							<c:forEach var="ps" items="${passSchools }">
								<option id="selectOption" value="${ps.da_no }">${ps.da_schoolname }&nbsp;-&nbsp;${ps.da_addr }</option>	
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">선생님 아이디</td>
					<td class="td2"><input name="Ta_id" autocomplete="off" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="td1">선생님 이름</td>
					<td class="td2"><input name="Ta_name" autocomplete="off" placeholder="이름"></td>
				</tr>
				<tr>
					<td class="td1">연락처</td>
					<td class="td2"><input name="Ta_phonenumber" autocomplete="off" placeholder="연락처"></td>
				</tr>
				<tr>
					<td class="td1">성별</td>
					<td class="td2">
						<select id="selectOption" name="Ta_gender">
							<option id="selectOption" value="남">남</option>
							<option id="selectOption" value="여">여</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">자기소개</td>
					<td class="td2"><textarea autocomplete="off" name="Ta_text"></textarea></td>
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
					<td class="tdTitle" colspan="2" align="center">강아지 신청 양식</td>
				</tr>
				<tr>
					<td class="td1">유치원 선택</td>
					<td class="td2">
						<select id="selectOption" name="Ua_da_no">
							<c:forEach var="ps" items="${passSchools }">
								<option id="selectOption" value="${ps.da_no }">${ps.da_schoolname }&nbsp;-&nbsp;${ps.da_addr }</option>	
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">견주 아이디</td>
					<td class="td2"><input name="Ua_id" autocomplete="off" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="td1">강아지 이름</td>
					<td class="td2"><input name="Ua_name" autocomplete="off" placeholder="이름"></td>
				</tr>
				<tr>
					<td class="td1">강아지 성별</td>
					<td class="td2">
						<select id="selectOption" name="Ua_gender">
							<option id="selectOption" value="수컷">수컷</option>
							<option id="selectOption" value="암컷">암컷</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">기간</td>
					<td class="td2"><input type="text" autocomplete="off" name="Ua_daterange"></td>
				</tr>
				<tr>
					<td class="td1">강아지 나이</td>
					<td class="td2"><input name="Ua_age" autocomplete="off" placeholder="강아지 나이"></td>
				</tr>
				<tr>
					<td class="td1">강아지 이미지</td>
					<td class="td2"><input type="file" name="Ua_img"></td>
				</tr>
				<tr>
					<td class="td1">희망 선생님 선택</td>
					<td class="td2">
						<select id="selectOption" name="Ua_tname">
							<c:forEach var="pt" items="${passTeachers }">
								<option id="selectOption" value="${pt.ta_name }">${pt.ta_name }(${pt.ta_gender })</option>	
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><button>신청하기</button></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>