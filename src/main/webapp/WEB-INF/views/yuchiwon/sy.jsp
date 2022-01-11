<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
누른 그 유치원
<div> 
<ul>
<li><a href="yuchiwon.get.allpuppy">강아지 목록</a></li>
</ul>
</div>
누른 그 유치원 메뉴들의 대한 컨텐츠 -----------
<div>
<jsp:include page="${yuchiwonContent }"></jsp:include>
</div>

</body>
</html>