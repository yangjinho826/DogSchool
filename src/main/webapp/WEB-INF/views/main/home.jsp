<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="home">
		<section class="home_Banner">
			<img class="home_Banner_img" src="resources/img/2.png">
		</section>
			
			<section class="home_review">
				<section id="review_Home">
					<h1 class="review_title">유치원 목록</h1>
					<button id="seemore2" onClick="location.href='list.go'">+</button>
					<section id="review_Body">
						<table class="review">
							<tr class="review_tr">
								<td class="review_table_title" style="width: 10%;">유치원 이름</td>
								<td class="review_table_title" style="width: 50%;">유치원 주소</td>
								<td class="review_table_title" style="width: 20%;">원장 이름(아이디)</td>
								<td class="review_table_title" style="width: 20%;">원장 전화번호</td>
							</tr>
							<tr height="1" bgcolor="black">
								<td colspan="4"></td>
							</tr>

							<c:forEach var="ps" items="${passSchools }">							
							<tr>
								<td style="height: 50px">${ps.dA_schoolname }</td>
								<td>${ps.dA_addr }</td>
								<td>${ps.dA_name }(${ps.dA_id })</td>
								<td>${ps.dA_phonenumber }</td>
							</tr>
							<tr height="2" bgcolor="black">
								<td colspan="4"></td>
							</tr>
						</c:forEach>
						</table>
					</section>
				</section>
			</section>
			

			<section class="home_review">
				<section id="review_Home">
					<h1 class="review_title">유치원 후기</h1>
					<button id="seemore" onClick="location.href='review.go'">+</button>
					<section id="review_Body">
						<table class="review">
							<tr class="review_tr">
								<td class="review_table_title" style="width: 10%;">글 번호</td>
								<td class="review_table_title" style="width: 50%;">제목</td>
								<td class="review_table_title" style="width: 20%;">작성자</td>
								<td class="review_table_title" style="width: 20%;">날짜</td>
							</tr>
							<tr height="1" bgcolor="black">
								<td colspan="4"></td>
							</tr>
							
							<c:forEach var="r" items="${reviews }">
								<tr>
									<td style="height: 45px">${r.r_no }</td>
									<td><a href="review.Detail?r_no=${r.r_no}">${r.r_title }</a></td>
									<td>${r.r_id }</td>
									<td><fmt:formatDate value="${r.r_date }" type="both"
											dateStyle="short" timeStyle="short" /></td>
								</tr>
								<tr height="2" bgcolor="black">
									<td colspan="4"></td>
								</tr>
							</c:forEach>
						</table>
					</section>
				</section>
			</section>
		</section>
	</section>
</body>
</html>