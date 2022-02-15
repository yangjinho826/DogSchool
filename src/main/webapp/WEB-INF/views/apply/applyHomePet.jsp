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
		<c:choose>
			<c:when test="${empty myPetOne }">
				<form action="apply.pet" method="post" enctype="multipart/form-data" name="myForm3" onsubmit="return applyCheck3()">
					<input name="token" value="${token }" hidden="hidden">
					<table border="1" style="border-collapse: collapse;" id="applyTbl">
						<tr>
							<td class="tdTitle" colspan="2" align="center">
							<b><c:forEach var="ps" items="${getOneSchool }">
								<input name="Ua_da_no" value="${ps.da_no }" hidden="true">
								"${ps.da_schoolname }"
							</c:forEach></b> 강아지 등록 양식</td>
						</tr>
						<tr>
							<td class="td1">견주 아이디</td>
							<td class="td2"><input disabled="disabled" value="${sessionScope.loginMember.id}">
								<input name="Ua_id" hidden="hidden" value="${sessionScope.loginMember.id}">
							</td>
						</tr>
						<tr>
							<td class="td1">강아지 이름</td>
							<td class="td2"><input name="Ua_name" autocomplete="off" placeholder="강아지 이름"></td>
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
							<td class="td2"><input type="file" id="img" name="Ua_img" accept="image/*"></td>
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
			</c:when>
			 
			<c:otherwise>
				<form action="reapply.myteacher">
					<input name="token" value="${token }" hidden="hidden">
					<table border="1" style="border-collapse: collapse;" id="applyTbl">
						<tr>
							<td class="tdTitle" colspan="2" align="center">
							<b><c:forEach var="ps" items="${getOneSchool }">
								<input name="Ua_da_no" value="${ps.da_no }" hidden="true">
								"${ps.da_schoolname }"
							</c:forEach></b> 강아지 등록 양식</td>
						</tr>
						<tr>
							<td class="td1">견주 아이디</td>
							<td class="td2">
								<c:forEach var="pp" items="${myPetOne }">
									<input name="Ua_no" value="${pp.ua_no }" hidden="hidden">
									<input name="Ua_id" value="${pp.ua_id }" disabled="disabled">
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="td1">강아지 이름</td>
							<td class="td2">
								<c:forEach var="pp" items="${myPetOne }">
									<input name="Ua_name" value="${pp.ua_name }" disabled="disabled">
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="td1">강아지 성별</td>
							<td class="td2">
								<c:forEach var="pp" items="${myPetOne }">
									<c:if test="${pp.ua_gender eq '수컷'}">
										<select id="selectOption" name="Ua_gender" disabled="disabled">
											<option id="selectOption" value="수컷" selected="selected">수컷</option>
											<option id="selectOption" value="암컷">암컷</option>
										</select>
									</c:if>
									<c:if test="${pp.ua_gender eq '암컷'}">
										<select id="selectOption" name="Ua_gender" disabled="disabled">
											<option id="selectOption" value="수컷">수컷</option>
											<option id="selectOption" value="암컷" selected="selected">암컷</option>
										</select>
									</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="td1">기간</td>
							<td class="td2">
								<c:forEach var="pp" items="${myPetOne }">
									<input value="${pp.ua_daterange }" disabled="disabled">
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="td1">강아지 나이</td>
							<td class="td2">
								<c:forEach var="pp" items="${myPetOne }">
									<input name="Ua_age" value="${pp.ua_age }" disabled="disabled">
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="td1">강아지 이미지</td>
							<td class="td2">
								<c:forEach var="pp" items="${myPetOne }">
									<img src="resources/img/${pp.ua_img }">
								</c:forEach>
							</td>
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
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>