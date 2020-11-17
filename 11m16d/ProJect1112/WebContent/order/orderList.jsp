<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/cart.css">
<link rel="stylesheet" href="../css/footer.css">
<!-- <h2>${sessionScope.login_Name }님의장바구니입니다.</h2> -->
</head>
<style>
#dressimg img {
	width: 80px;
	height: 80px;
}
</style>
<body>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>

		<form name="formm" method="post">
			<div id="cartlist">
				<div id="shopping_cart_list">Shopping Order list</div>
				<div id="cart_name">${sessionScope.login_Name }님의주문상품입니다.</div>
				<table id="cartList"
					style="font-family: Go, Arial, malgun gothic, 맑은고딕, NanumGothic, dotum, 돋움, sans-serif; font-weight: bold;">
					<tr>
						
						<th style="width: 10%;">이미지</th>
						<th style="width: 15%;">상품 이름</th>
						<th style="width: 10%;">금액</th>
						<th style="width: 10%;">수량</th>
						<th style="width: 10%;">배송비</th>
						<th style="width: 10%;">총 금액</th>
						<th style="width: 15%;">주문 일</th>
						<th style="width: 10%;">상태</th>
						<th style="width: 10%; padding-left: 10px;">주문 취소</th>

					</tr>

					<c:forEach items="${ListOrder}" var="orderVO">
						<tr>
							<td>
								<div id="dressimg">
									<span>${orderVO.dressimg}</span>
								</div>
							</td>
							<td>${orderVO.dressname}</td>

							<td style="width: 150px" align="right"><fmt:formatNumber
									pattern="###,###,###" value="${orderVO.price}" /></td>
							<td>${orderVO.amount}</td>
							<td>2,500</td>
							<td style="width: 150px" align="right"><fmt:formatNumber
									pattern="###,###,###" value="${orderVO.sum + 2500}" /></td>
							<td><fmt:formatDate value="${orderVO.orderDate}" type="date" /></td>
							<td>${orderVO.delivery}</td>
							<td class="delete"><a
								style="color: navy; text-decoration: none"
								href="../order/orderDelete.co?ordernum=${orderVO.ordernum}">삭
									제</a></td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</form>
		<div id="State">
			<img src="../img/Pay/Payment.jpg">
		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>
</body>
</body>
</html>