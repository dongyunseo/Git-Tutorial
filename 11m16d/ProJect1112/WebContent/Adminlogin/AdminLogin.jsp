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
<style>
#Admin {
	width: 500px;
	padding: 30px 155px;
	text-align: center;
}

#AdminLogin {
	border: 0;
	border-radius: 5px;
	float: left;
	color: black;
	background: white;
}
#User {
	width: 500px;
	padding: 30px 155px;
	text-align: center;
}
</style>
</head>

<body>

	<div id="top">
		<div id="header">
			<jsp:include page="../section/header.jsp" />
		</div>
		<div class="container">
			<h5>
				<span>관리자 로그인 </span> 페이지입니다.
			</h5>
			<hr />
			<br />
			<form action="admin.io" method="post">
				<input type="text" placeholder="아이디" name="id" required
					style="height: 30px; width: 495px" /><br /> <br /> <input
					type="password" placeholder="비밀번호" name="pwd" required
					style="height: 30px; width: 495px" /><br /> <br />
				<p>
					<input type="submit" value="로그인" id="signup"><br /> <br />
				</p>
			</form>
			<hr />
			<div id="User">
				<form action="../Member/mainLoginPage.jsp">
					<input type="submit" value="일반 사용자 로그인( User Login )"
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