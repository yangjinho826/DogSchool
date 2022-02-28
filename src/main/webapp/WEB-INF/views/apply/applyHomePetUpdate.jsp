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
		<!-- 승인 전  신청 정보 수정 시 폼 형식 -->
			<c:forEach var="pp" items="${myApplyPet }">
				<form action="apply.pet.update" method="POST" enctype="multipart/form-data" name="myForm3" onsubmit="return applyCheck3()">
					<input name="token" value="${token }" hidden="hidden">
					<input name="uA_no" value="${pp.uA_no }" hidden="hidden">
					<table border="1" style="border-collapse: collapse;" id="applyTbl">
						<tr>
							<td class="tdTitle" colspan="2" align="center">
							<b><c:forEach var="ps" items="${getOneSchool }">
								<input name="uA_da_no" value="${ps.dA_no }" hidden="true">
								"${ps.dA_schoolname }"
							</c:forEach></b> 강아지 등록 양식</td>
						</tr>
						<tr>
							<td class="td1">견주 아이디</td>
							<td class="td2"><input disabled="disabled" value="${sessionScope.loginMember.id}">
								<input name="uA_id" hidden="hidden" value="${sessionScope.loginMember.id}">
							</td>
						</tr>
						<tr>
							<td class="td1">강아지 이름</td>
							<td class="td2"><input name="uA_name" autocomplete="off" placeholder="강아지 이름" value="${pp.uA_name }"></td>
						</tr>
						<tr>
							<td class="td1">강아지 성별</td>
							<td class="td2">
								<c:if test="${pp.uA_gender eq '수컷'}">
									<select id="selectOption" name="uA_gender">
										<option id="selectOption" value="수컷" selected="selected">수컷</option>
										<option id="selectOption" value="암컷">암컷</option>
									</select>
								</c:if>
								<c:if test="${pp.uA_gender eq '암컷'}">
									<select id="selectOption" name="uA_gender">
										<option id="selectOption" value="수컷">수컷</option>
										<option id="selectOption" value="암컷" selected="selected">암컷</option>
									</select>
								</c:if>
							</td>
						</tr>
						<tr>
							<td class="td1">기간</td>
							<td class="td2"><input type="text" autocomplete="off" name="uA_daterange" value="${pp.uA_daterange }"></td>
						</tr>
						<tr>
							<td class="td1">강아지 나이</td>
							<td class="td2"><input name="uA_age" autocomplete="off" placeholder="강아지 나이" value="${pp.uA_age }"></td>
						</tr>
						<tr>
							<td class="td1">강아지 이미지</td>
							<td class="td2"><input type="file" name="imggg" accept="image/*" value="resources/img/${pp.uA_img }"></td>
						</tr>
						<tr>
							<td class="td1">희망 선생님 선택</td>
							<td class="td2">
								<select id="selectOption" name="uA_ta_no">
									<c:forEach var="pt" items="${getOneSchoolTeacher }">
										<option id="selectOption" value="${pt.tA_no }">${pt.tA_name }(${pt.tA_id}, ${pt.tA_gender })	
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2"><button>신청하기</button></td>
						</tr>
					</table>
				</form>
		</c:forEach>
	</section>
</body>
</html>