<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Adminheader.css">
<link rel="stylesheet" href="../css/cart.css">
<link rel="stylesheet" href="../css/adminfooter.css">
</head>
<style>
#Admin {
	text-align: center;
}

#dressimg img {
	width: 80px;
	height: 80px;
}

#OrderList {
	padding-top: 200px;
	text-align: center;
}
#Ol {
	font-size: 12px;
	text-align: center;
	padding: 30px;
	margin: auto;
	color: #999;
	margin-bottom: -20px;
	padding-bottom: 60px;
}
</style>
<body>
<body>
	<div id="top">
		<jsp:include page="../Adminsection/header.jsp" />
	</div>
	<div id="OrderList">
		<div id="Ol">Order List</div>
		<form name="formm" method="post">
			<div id="cartlist">
				<table id="cartList">
					<tr>
						<th style="width: 7%;">주문 번호</th>
						<th style="width: 7%;">주문자</th>
						<th style="width: 9%;">이미지</th>
						<th style="width: 15%;">상품 이름</th>
						<th style="width: 9%;">금액</th>
						<th style="width: 8%;">수량</th>
						<th style="width: 8%;">배송비</th>
						<th style="width: 9%;">총 금액</th>
						<th style="width: 9%;">주문 일</th>
						<th style="width: 9%;">상태</th>
						<th style="width: 10%; padding-left: 10px;">상태 수정</th>

					</tr>

					<c:forEach items="${adminAllListOrder}" var="orderVO">
						<tr>
							<td>${orderVO.ordernum}</td>
								<td>${orderVO.id}</td>
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
								href="../AdminOrder/AdminUpdateOrder.ao?ordernum=${orderVO.ordernum}">수정</a></td>
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