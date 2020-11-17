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
<link rel="stylesheet" href="../css/middle.css">
<link rel="stylesheet" href="../css/footer.cs">
<script type="text/javascript">
	function a() {
		alert("아이디 혹은 비밀번호가 틀렸습니다. 다시 확인해 주시기바랍니다.");
	}
</script>
<style>
hr {
	width: 500px;
}

#Retry {
	font-size: 12px;
	text-align: center;
	margin: auto;
	color: #999;
	padding-top: 200px;
	padding-bottom: 200px;
}
</style>

</head>
<!--  onload="a()" -->
<body onload="a()">
	<div id="wrap">
		<div id="header">

			<jsp:include page="../section/header.jsp" />
		</div>
		<div id="Retry">
			<h5>
				<span>다시 </span> 로그인하기
			</h5>
			<hr />
			<a href="../Member/mainLoginPage.jsp">다시 로그인 하러가기</a>
			<hr />
		</div>
		<div id="footer">

			<jsp:include page="../section/footer.jsp" />


		</div>
	</div>
</body>
</html>