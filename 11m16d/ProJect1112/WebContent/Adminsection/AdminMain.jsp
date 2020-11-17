<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Adminheader.css">
<style>
#admin {
	text-align: center;
	padding-top: 250px;
	padding-bottom: 250px;
}
</style>
</head>
<body>
	<div id="admin">
		<h2>관리자 로그인 완료</h2>
		<br>
		<h3>${sessionScope.login_Id }님 환영합니다.</h3>
	</div>
</body>
</html>
