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
</head>
<body>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>

		<form name="formm" method="post">
			<div id="cartlist">
				<div id="shopping_cart_list">Shopping Cart list</div>
				<div id="cart_name">${sessionScope.login_Name } 님의 장바구니입니다.</div>
				<table id="cartList"
					style="font-family: Go, Arial, malgun gothic, 맑은고딕, NanumGothic, dotum, 돋움, sans-serif; font-weight: bold;">
					<tr>
						<th style="width: 15%;">이미지</th>
						<th style="width: 15%;">상품 이름</th>
						<th style="width: 10%;">금액</th>
						<th style="width: 10%;">수량</th>
						<th style="width: 15%;">총 금액</th>
						<th style="width: 15%;">주문 일</th>
						<th style="width: 10%; padding-left: 7px;">취소</th>
						<th style="width: 10%; padding-left: 7px;">주문</th>
					</tr>

					<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td>
								<div id="dressimg">
									<span>${cartVO.dressimg}</span>
								</div>
							</td>
							<td>${cartVO.dressname}</td>

							<td style="width: 150px" align="right"><fmt:formatNumber
									pattern="###,###,###" value="${cartVO.price}" /></td>
							<td>${cartVO.amount}</td>
							<td style="width: 150px" align="right"><fmt:formatNumber
									pattern="###,###,###" value="${cartVO.sum}" /></td>
							<td><fmt:formatDate value="${cartVO.addDate}" type="date" /></td>

							<td class="delete"><a
								style="color: navy; text-decoration: none"
								href="../cart/cartDelete.co?cartnum=${cartVO.cartnum}">삭 제</a></td>
							<td class="order"><a
								style="color: navy; text-decoration: none"
								href="../order/order.co?cartnum=${cartVO.cartnum}">주문</a></td>
						</tr>
					</c:forEach>

				</table>

			</div>
		</form>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>
</body>
</body>
</html>