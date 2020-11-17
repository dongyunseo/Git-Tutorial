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
<link rel="stylesheet" href="../css/adminfooter.css">
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
	<div id="QandA_list">
		<form name="cartInsert" method="post"
			action="../AdminReview&QandA/AdminQandAreply.ao">
			<input type="hidden" name="dressid" value="${dto.dressid }">

			<div id="QQAA">Q&A List</div>
			<div id="list">
				<table id="Qlist">
					<tr>
						<th style="width: 70px; height: 30px;">Number</th>
						<th style="width: 570px; height: 30px;">TITLE</th>
						<th style="width: 130px; height: 30px;">작성자</th>
						<th style="width: 130px; height: 30px;">날짜</th>
						<th style="width: 130px; height: 30px;">답글 작성</th>
					</tr>
					<c:forEach items="${QandAallList}" var="qandAVo">
						<input type="hidden" name="loginid"
							value=${sessionScope.login_Id }>
						<input type="hidden" name="id" value=${qandAVo.id }>

						<tr>
							<td style="height: 30px;">${qandAVo.qandaid}</td>
							<td style="height: 30px;"><details>
									<summary>${qandAVo.qandatitle}</summary>
									<p>
										<details>
											<summary>${qandAVo.qandacontent}</summary>
											<p>답변 : ${qandAVo.qandareply}</p>
										</details>
									</p>

								</details></td>
							<td style="height: 30px;">${qandAVo.id}</td>
							<td style="height: 30px;">${qandAVo.qandadate}</td>

							
									<td class="delete"><input type="submit"
										onclick="return confirm('답글 페이지로 이동합니다.')" name="qandaid"
										value=${qandAVo.qandaid }
										style="border: 0px; background: white;"></td>
								
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
	<div id="bott">
		<jsp:include page="../Adminsection/footer.jsp" />
	</div>
</body>
</body>
</html>