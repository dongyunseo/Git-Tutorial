<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Adminheader.css">
<link rel="stylesheet" href="../css/ReviewList.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<body>
<body>
	<div id="top">
		<jsp:include page="../Adminsection/header.jsp" />
	</div>
	<div id="mid">
		<jsp:include page="../Adminsection/AdminQandA&Review.jsp" />
	</div>
	<div id="ReviewList">Review List</div>
	<hr class="ReviewLine">
		<div id="Review">
		<c:forEach items="${ReviewAllList}" var="reviewVO">
			<table>
				<tr>
					<td><table id="Reviewright">
							<tr>
								<td>${reviewVO.reviewscore}</td>
							</tr>
							<tr>
								<td><details>
										<summary>${reviewVO.reviewtitle}</summary>
										<p>${reviewVO.reviewcontent}</p>
									</details></td>
							</tr>
							<tr>
								<td>
									<div id="ReviewImg">
										<details>
											<summary>
												<span>${reviewVO.reviewimg}</span>
											</summary>
											<p>
											<div id="ReviewImgbig">
												<span>${reviewVO.reviewimg}</span>
											</div>
										</details>
									</div>
								</td>
							</tr>
						</table></td>

					<td><table id="Reviewleft">
							<tr>
								<td>리뷰 작성자 : ${reviewVO.id}
									<hr class="RLine">
								</td>
							</tr>
							<tr>
								<td>리뷰 작성일 : ${reviewVO.reviewDate}
									<hr class="RLine">
								</td>
							</tr>
							<tr>
								<td>상품 이름 : ${reviewVO.dressname}
									<hr class="RLine">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
			<hr class="ReviewLine">
		</c:forEach>

	</div>
	<div id="bott">
		<jsp:include page="../Adminsection/footer.jsp" />
	</div>
</body>
</body>
</html>