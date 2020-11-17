<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/admindetail.css">
<link rel="stylesheet" href="../css/footer.css">
<!--  https://great-yo.tistory.com/86?category=786047  게시판    -->
<script language="JavaScript">
	function productupdate() {
		alert('상품 수정이 완료되었습니다.');
		document.productupdate.action="../AdminProductManager/AdminProductDetail.ao";
		document.productupdate.submit();
	}
</script>
<style>
#Review {
	font-size: 12px;
	text-align: center;
	margin: auto;
	color: #999;
	width: 910px;
	margin-bottom: 80px;
}

#order_Information {
	width: 800px;
	height: 150px;
	padding-top: 50px;
	padding-left: 130px;
}
</style>
</head>
<body onload="init();">
	<div id="menu">
		<jsp:include page="AdminProduct.jsp" />
	</div>
	<div id="dress">
		<form name="productupdate" method="post" action="../AdminProductManager/AdminProductDetail.ao">
			<div id="dressimg" style="height: 441px; width: 441px;">
				<span>${dto.dressimg }</span>
			</div>
			<div id="dressname">
				<span>${dto.dressname }</span>
			</div>
			<div id="price">${dto.price}원</div>
			<table id="order_Information">
				<tr>
					<th>상품 이름</th>
					<th><input type="text" name="dressname" required></th>
				</tr>
				<tr>
				<tr>
					<th>상품 가격</th>
					<th><input type="text" name="price" required></th>
				</tr>

			</table>

			<input type="submit" value="상품 수정 완료" id="detilButton"
			onclick="javascript:productupdate()">
			<input type="hidden" name="dressid" value="${dto.dressid }">
		</form>
	</div>
	<div id="bott">
		<jsp:include page="../section/footer.jsp" />
	</div>
</body>
</html>