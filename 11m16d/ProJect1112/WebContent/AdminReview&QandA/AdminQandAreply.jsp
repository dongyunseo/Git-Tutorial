<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Adminheader.css">
<link rel="stylesheet" href="../css/detail.css">
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
		<jsp:include page="../Adminsection/AdminQandA&Review.jsp" />
	</div>
	<div>
		<input type="hidden" name="qandaid" value="${updateQandA.qandaid}">
		<input type="hidden" name="qandatitle"
			value="${updateQandA.qandatitle}"> <input type="hidden"
			name="id" value="${updateQandA.id}"> <input type="hidden"
			name="qandadate" value="${updateQandA.qandadate}">

		<table id="Qlist">
			<tr>
				<th style="width: 70px; height: 30px;">Number</th>
				<th style="width: 570px; height: 30px;">TITLE</th>
				<th style="width: 130px; height: 30px;">작성자</th>
				<th style="width: 130px; height: 30px;">날짜</th>
			</tr>

			<tr>
				<td style="height: 30px;">${updateQandA.qandaid}</td>
				<td style="height: 30px;"><details>
						<summary>${updateQandA.qandatitle}</summary>
						<p>${updateQandA.qandacontent}</p>

					</details></td>
				<td style="height: 30px;">${updateQandA.id}</td>
				<td style="height: 30px;">${updateQandA.qandadate}</td>
			</tr>

		</table>
	</div>
	<div id="QandA">
		<div id="QQAA">Q&A 답글 작성</div>
		<div id="QandA_insert">
			<form method="post" name="QandAform"
				action="../AdminReview&QandA/AdminQandA.ao">
				<input type="hidden" name="qandaid" value="${updateQandA.qandaid}">
				<div id="Insert">
					<br /> <input type="text" placeholder="내용" name="qandareply"
						required
						style="height: 200px; width: 900px; border: 1px solid #d7d5d5;" />
					<br /> <br />
				</div>
				<p>

					<input type="submit" value="작성하기" id="QandA_in" /> <br /> <br />

				</p>
			</form>
		</div>
	</div>

	<div id="bott">
		<jsp:include page="../Adminsection/footer.jsp" />
	</div>
</body>
</body>
</html>