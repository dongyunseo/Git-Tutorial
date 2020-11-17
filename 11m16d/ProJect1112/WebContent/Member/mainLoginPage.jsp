<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>SignUp</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/mainLoginPage.css">
<link rel="stylesheet" href="../css/footer.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>
		<div class="container">
			<h5>
				<span>로그인 </span> 페이지입니다.
			</h5>
			<hr />
			<br />
			<form action="login.so" method="post">
				<input type="text" placeholder="아이디" name="id" id="login_but" required />
				<br /> <br /> 
				<input type="password" placeholder="비밀번호" name="pwd" id="login_but" required />
				<br /> <br />
				<p>
					<input type="submit" value="로그인" id="signup"><br /> <br />
				</p>
			</form>

			<div id="FORGOT">
				<form action="FORGOTID.jsp">
					<input type="submit" value="FORGOT ID" id="foidpw" />
				</form>
				<form action="FORGOTPW.jsp">
					<input type="submit" value="FORGOT PW" id="foidpw" /><br /> <br />
				</form>
			</div>
			<hr />
			<div id="Admin">
				<form action="../Adminlogin/AdminLogin.jsp">
					<input type="submit" value="관리자 로그인 ( Admin Login )"
						id="AdminLogin" />
				</form>
			</div>
		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>

</body>
</html>