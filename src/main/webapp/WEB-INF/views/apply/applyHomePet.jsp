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
		<form action="apply.pet" method="post" enctype="multipart/form-data">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td class="tdTitle" colspan="2" align="center">
					<b><c:forEach var="ps" items="${getOneSchool }">
						<input name="Ua_da_no" value="${ps.da_no }" hidden="true">
						${ps.da_schoolname }
					</c:forEach></b> 강아지 등록 양식</td>
				</tr>
				<tr>
					<td class="td1">견주 아이디</td>
					<td class="td2"><input name="Ua_id" autocomplete="off" placeholder="아이디" value="${sessionScope.loginMember.id}"></td>
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
							<c:forEach var="pt" items="${getOneSchoolTeacher }">
								<option id="selectOption" value="${pt.ta_name }">${pt.ta_name }(${pt.ta_gender })	
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