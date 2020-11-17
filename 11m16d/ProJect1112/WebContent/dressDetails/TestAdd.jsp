
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</script>
</head>
<body onload="init();">
	<form name="dressbuy" method="post">
	<input type=hidden name="sell_price" value=20000>
		<div class="totalprice">
			Total :&nbsp;&nbsp; 
			<input type="text" id="totalp" name="sum" readonly>원
		</div>
		<div class="totalprice_but">
			수량 : 
			<input type="text" name="amount" value="1" size="3" onchange="change();"> 
			<input type="button" value=" + " onclick="add();"> 
			<input type="button" value=" - " onclick="del();"> <br> 
		</div>
	</form>
</body>
</html>