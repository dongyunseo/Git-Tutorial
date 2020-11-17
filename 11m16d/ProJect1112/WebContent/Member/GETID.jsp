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
<script language="JavaScript">
	function Logingo() {
		document.Logingo.action = "../Member/mainLoginPage.jsp";
		document.Logingo.submit();
	}
</script>
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
				<span>찾으신 </span> 아이디
			</h5>
			<hr />
			<br> <br>
			<h3>${dtoid.id}</h3>
			<br /> <br />
			<hr />
			<form name="Logingo">
				<input type="submit" value="로그인 하러 가기" id="signup1"
					onclick="javascript:Logingo()"
					style="border: 0px; background: white;" />
			</form>

		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>

</body>
</body>
</html>