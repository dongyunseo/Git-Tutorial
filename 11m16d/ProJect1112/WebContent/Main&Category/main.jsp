<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/middle.css">
<link rel="stylesheet" href="../css/footer.css">
</head>

<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/header.jsp" />
		</div>
		<table class="table">

			<tbody id="ajaxTable">

			</tbody>
		</table>
		<div id="middle">
			<jsp:include page="../section/middle.jsp" />
		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>
</body>
</html>