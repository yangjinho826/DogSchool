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
		<c:forEach var="g" items="${getTypee }">
		<c:if test="${g.typee eq 3}">
		<!-- if 원장 권한 로그인 시 -->
		<form action="apply.school" name="myForm" onsubmit="return applyCheck1()">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td class="tdTitle" colspan="2" align="center">유치원 등록 양식</td>
				</tr>
				<tr>
					<td class="td1">원장 아이디</td>
					<td class="td2"><input name="Da_id" autocomplete="off" placeholder="아이디" value="${sessionScope.loginMember.id}"></td>
				</tr>
				<tr>
					<td class="td1">원장 이름</td>
					<td class="td2"><input name="Da_name" autocomplete="off" placeholder="이름" value="${sessionScope.loginMember.name}"></td>
				</tr>
				<tr>
					<td class="td1">원장 연락처</td>
					<td class="td2"><input name="Da_phonenumber" autocomplete="off" placeholder="연락처" value="${sessionScope.loginMember.phonenumber}"></td>
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
					<td align="center" colspan="2"><button>신청하기</button></td>
				</tr>
			</table>
		</form>
		</c:if>

		<c:if test="${g.typee eq 2}">
		<!-- if 선생님 권한 로그인 시 -->
		<form action="apply.teacher">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td class="tdTitle" colspan="2" align="center">선생님 등록 양식</td>
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
					<td class="td2"><input name="Ta_id" autocomplete="off" placeholder="아이디" value="${sessionScope.loginMember.id}"></td>
				</tr>
				<tr>
					<td class="td1">선생님 이름</td>
					<td class="td2"><input name="Ta_name" autocomplete="off" placeholder="이름" value="${sessionScope.loginMember.name}"></td>
				</tr>
				<tr>
					<td class="td1">연락처</td>
					<td class="td2"><input name="Ta_phonenumber" autocomplete="off" placeholder="연락처" value="${sessionScope.loginMember.phonenumber}"></td>
				</tr>
				<tr>
					<td class="td1">성별</td>
					<td class="td2">
						<c:if test="${sessionScope.loginMember.gender eq 'man'}">
							<select id="selectOption" name="Ta_gender">
							<option id="selectOption" value="man" selected="selected">남성</option>
							<option id="selectOption" value="woman">여성</option>
							</select>
						</c:if>
						<c:if test="${sessionScope.loginMember.gender eq 'woman'}">
							<select id="selectOption" name="Ta_gender">
							<option id="selectOption" value="man">남성</option>
							<option id="selectOption" value="woman" selected="selected">여성</option>
							</select>
						</c:if>
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
		</c:if>
		
		<c:if test="${g.typee eq 1}">
		<!-- if 견주 권한 로그인 시 -->
		<form action="apply.go.pet">
		<section id="showSchoolArea">
			<c:forEach var="ps" items="${passSchools }">
				<div id="showOneSchool">
					<div>${ps.da_schoolname }</div>
				
					<div>${ps.da_addr }</div>
				
					<div>원장: ${ps.da_name }(${ps.da_id })</div>
					
					<div>${ps.da_phonenumber }</div>
					<div><button name="Da_no" value="${ps.da_no }">신청하기</button></div>
				</div>
			</c:forEach>	
		</section>
		</form>
		</c:if>
		</c:forEach>
	</section>
</body>
</html>