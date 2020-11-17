<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Adminheader.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<style>

#Admin {
	text-align: center;
}

#Admincategory {
	font-family: Go, Arial, malgun gothic, 맑은고딕, NanumGothic, dotum, 돋움,
		sans-serif;
	font-weight: bold;
	width: 1000px;
	height: 100px;
	margin: auto;
}
</style>
<body>
<body>
	<div id="top">
		<jsp:include page="../Adminsection/header.jsp" />
	</div>
	<div id="mid">
		<jsp:include page="../Adminsection/AdminProduct.jsp" />
	</div>
</body>
</body>
</html>