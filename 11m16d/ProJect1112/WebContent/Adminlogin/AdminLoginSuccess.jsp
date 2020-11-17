<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<style>
#middle {
	padding-bottom: 50px;
	padding-top: 170px;
}

#productdiv {
	border: 1px solid black;
	width: 1500px;
	height: 1000px;
	margin: auto;
}

#mid {
	padding-top: 150px;
}
</style>
<body>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../Adminsection/header.jsp" />
		</div>
	</div>
	<div id="mid">
		<jsp:include page="../Adminsection/AdminMain.jsp" />
		</div>
		<div id="bott">
			<jsp:include page="../Adminsection/footer.jsp" />
		</div>
</body>
</body>
</html>