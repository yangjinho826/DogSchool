<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<metA charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="applyHomeArea">
		<c:forEach var="g" items="${getTypee }">
		<c:if test="${g.typee eq 3}">
		<!-- if 원장 권한 로그인 시 -->
		<form action="apply.school" name="myForm" onsubmit="return applyCheck1()">
			<input name="token" value="${token }" hidden="hidden">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td class="tdTitle" colspan="2" align="center">유치원 등록 양식</td>
				</tr>
				<tr>
					<td class="td1">원장 아이디</td>
					<td class="td2"><input name="dA_id" autocomplete="off" placeholder="아이디" value="${sessionScope.loginMember.id}"></td>
				</tr>
				<tr>
					<td class="td1">원장 이름</td>
					<td class="td2"><input name="dA_name" autocomplete="off" placeholder="이름" value="${sessionScope.loginMember.name}"></td>
				</tr>
				<tr>
					<td class="td1">원장 연락처</td>
					<td class="td2"><input name="dA_phonenumber" autocomplete="off" placeholder="연락처" value="${sessionScope.loginMember.phonenumber}"></td>
				</tr>
				<tr>
					<td class="td1">유치원 이름</td>
					<td class="td2"><input name="dA_schoolname" autocomplete="off" placeholder="유치원 이름"></td>
				</tr>
				<tr>
					<td class="td1">유치원 주소</td>
					<td class="td2">
						<input id="m_addr3Input" readonly="readonly" name="dA_addr3" maxlength="5" autocomplete="off" placeholder="우편번호">
						<span id="addrSearchBtn">[검색]</span><br>
						<input id="m_addr1Input" readonly="readonly" name="dA_addr1" maxlength="30" autocomplete="off" placeholder="주소"><br>
						<input name="dA_addr2" maxlength="30" autocomplete="off" placeholder="상세주소">
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
		<form action="apply.teacher" id="myForm2" name="myForm2" onsubmit="return applyCheck2()">
			<input name="token" value="${token }" hidden="hidden">
			<table border="1" style="border-collapse: collapse;" id="applyTbl">
				<tr>
					<td class="tdTitle" colspan="2" align="center">선생님 등록 양식</td>
				</tr>
				<tr>
					<td class="td1">유치원 선택</td>
					<td class="td2">
						<select id="selectOption" name="tA_da_no">
							<c:forEach var="ps" items="${passSchools }">
								<option id="selectOption" value="${ps.dA_no }">${ps.dA_schoolname }&nbsp;-&nbsp;${ps.dA_addr }</option>	
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td1">선생님 아이디</td>
					<td class="td2"><input name="tA_id" id="tA_id" autocomplete="off" placeholder="아이디" value="${sessionScope.loginMember.id}">&nbsp;<button id="checkBtn" type="button">ID 확인</button><input id="id2" name="id2" value="0" type="hidden"><span id="idcheck" class="idcheck"></span></td>
				</tr>
				<tr>
					<td class="td1">선생님 이름</td>
					<td class="td2"><input name="tA_name" autocomplete="off" placeholder="이름" value="${sessionScope.loginMember.name}"></td>
				</tr>
				<tr>
					<td class="td1">연락처</td>
					<td class="td2"><input name="tA_phonenumber" autocomplete="off" placeholder="연락처" value="${sessionScope.loginMember.phonenumber}"></td>
				</tr>
				<tr>
					<td class="td1">성별</td>
					<td class="td2">
						<c:if test="${sessionScope.loginMember.gender eq 'man'}">
							<select id="selectOption" name="tA_gender">
							<option id="selectOption" value="man" selected="selected">남성</option>
							<option id="selectOption" value="woman">여성</option>
							</select>
						</c:if>
						<c:if test="${sessionScope.loginMember.gender eq 'woman'}">
							<select id="selectOption" name="tA_gender">
							<option id="selectOption" value="man">남성</option>
							<option id="selectOption" value="woman" selected="selected">여성</option>
							</select>
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="td1">자기소개</td>
					<td class="td2"><textArea autocomplete="off" name="tA_text"></textArea></td>
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
					<div>${ps.dA_schoolname }</div>
				
					<div>${ps.dA_addr }</div>
				
					<div>원장: ${ps.dA_name }(${ps.dA_id })</div>
					
					<div>${ps.dA_phonenumber }</div>
					<div><button name="dA_no" value="${ps.dA_no }">신청하기</button></div>
				</div>
			</c:forEach>	
		</section>
		</form>
		</c:if>
		</c:forEach>
	</section>
</body>
</html>