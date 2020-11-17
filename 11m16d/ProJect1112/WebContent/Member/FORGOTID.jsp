<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<style>
#id_forgot {
	width: 600px;
	height: 500px;
	margin: auto;
}

hr {
	width: 500px;
}

#id_forgot2 {
	font-size: 12px;
	text-align: center;
	margin: auto;
	color: #999;
	padding-top: 200px;
}

h5 span {
	color: teal;
}

#signup1 {
	font-family: Go, Arial, malgun gothic, 맑은고딕, NanumGothic, dotum, 돋움,
		sans-serif;
	font-weight: bold;
	background-color: #a4d2f2;
	color: white;
	border: 0;
	border-radius: 5px;
	padding: 10px 224px;
	margin-left: 38px;
}

#imail {
	position: absolute;
	top: 110px;
	margin: 0 470px;
}
</style>
<body>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>
		<div id="id_forgot2">
			<h5>
				<span>아이디 </span> 찾기
			</h5>
			<hr />
		</div>
		<div id="id_forgot">
			<form method="post" action="../Member/idforgot.so">
				<br /> <input type="text" placeholder="이 름" name="name" required
					style="height: 30px; width: 495px; margin-left: 45px;" /><br /> <br />
				<input type="email" placeholder="이 메 일" name="email" required
					style="height: 30px; width: 495px; margin-left: 45px;" /><br /> <br />
				<input type="text" placeholder="전화 번호 ( - 제외  )" name="phone"
					required style="height: 30px; width: 495px; margin-left: 45px;" /><br />
				<br />

				<p>
					<input type="submit" value="아이디 찾기" id="signup1" /><br /> <br />
				</p>
				<hr />
			</form>
		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>

</body>
</body>
</html>