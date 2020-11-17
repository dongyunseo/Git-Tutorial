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
	var sell_price;
	var amount;

	function init() {
		sell_price = document.dressbuy.sell_price.value;
		amount = document.dressbuy.amount.value;
		document.dressbuy.sum.value = sell_price;
		change();
	}

	function add() {
		hm = document.dressbuy.amount;
		sum = document.dressbuy.sum;
		hm.value++;
		sum.value = parseInt(hm.value) * sell_price;
	}

	function del() {
		hm = document.dressbuy.amount;
		sum = document.dressbuy.sum;
		if (hm.value > 1) {
			hm.value--;
			sum.value = parseInt(hm.value) * sell_price;
		}
	}

	function change() {
		hm = document.dressbuy.amount;
		sum = document.dressbuy.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
		sum.value = parseInt(hm.value) * sell_price;
	}
	function productupdate() {
		alert('상품 수정 페이지로 이동합니다. ');
		document.dressbuy.action = "../AdminProductManager/AdminProductUpdate.ao"
		document.dressbuy.submit();
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
</style>
</head>
<body onload="init();">
	<div id="menu">
		<jsp:include page="AdminProduct.jsp" />
	</div>
	<div id="dress">
		<form name="dressbuy" method="post"
			action="../AdminProductManager/AdminProductUpdate.ao">
			<div id="dressimg" style="height: 441px; width: 441px;">
				<span>${dto.dressimg }</span>
			</div>
			<div id="dressname">
				<span>${dto.dressname }</span>
			</div>
			<div id="price">${dto.price}원</div>
			<hr class="lineone">
			<input type="hidden" name="dressid" value="${dto.dressid }">
			<input type="hidden" name="dressname" value="${dto.dressname }">
			<div id="totalprice">
				Total :&nbsp;&nbsp; <input type="text" id="totalp" name="sum"
					readonly>원
			</div>
			<div id="totalprice">
				수량 : <input type=hidden name="sell_price" value=${dto.price}>
				<input type="text" name="amount" value="1" size="3"
					onchange="change();"> <input type="button" value=" + "
					onclick="add();"> <input type="button" value=" - "
					onclick="del();"><br>
			</div>
			<input type="hidden" name="price" value="${dto.price }"> <input
				type="submit" value="상품 수정하기 " id="detilButton">
			<!--  onclick="javascript:productupdate()">-->

		</form>
	</div>
	<div id="bott">
		<jsp:include page="../section/footer.jsp" />
	</div>
</body>
</html>