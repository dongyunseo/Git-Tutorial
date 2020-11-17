<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Northwind</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/main_Newjoin.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>
		<div class="Login-s">
			<div class="hello">환영합니다.</div>
			<div class="btn">
				<a class="button" href="../Main&Category/main.do">메인 페이지</a> <a class="button" href="../Member/mainLoginPage.jsp">로그인</a>
			</div>
		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>

	</div>
</body>
</html>