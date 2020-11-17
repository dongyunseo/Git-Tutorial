<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/order.css">
<link rel="stylesheet" href="../css/footer.css">
<script language="JavaScript">
	function orderSuccess() {
		alert('주문 완료!');
		document.orderInsert.action = "../order/orderInsert.co";
		document.orderInsert.submit();

	}
</script>
</head>

<body>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>
		<div id="orderList">
			<div id="shopping_Order_list">Shopping Order</div>
			<div id="order_name">${sessionScope.login_Name }님의주문페이지입니다.</div>
			<form name="orderInsert" method="post"
				action="../order/orderInsert.co">

				<input type="hidden" name="dressid" value="${OrderReady.dressId}">
				<input type="hidden" name="dressimg" value="${OrderReady.dressimg}">
				<input type="hidden" name="dressname"
					value="${OrderReady.dressname}"> <input type="hidden"
					name="price" value="${OrderReady.price}"> <input
					type="hidden" name="amount" value="${OrderReady.amount}"> <input
					type="hidden" name="sum" value="${OrderReady.sum}">

				<table id="orderList">
					<tr>
						<th style="width: 25%;">이미지</th>
						<th style="width: 10%;">상품 번호</th>
						<th style="width: 20%;">상품 이름</th>
						<th style="width: 15%;">금액</th>
						<th style="width: 5%;">수량</th>
						<th style="width: 25%;">총 금액</th>

					</tr>

					<tr>
						<td>
							<div id="dressimg">
								<span>${OrderReady.dressimg}</span>
							</div>
						</td>
						<td>${OrderReady.dressId}</td>
						<td>${OrderReady.dressname}</td>

						<td style="width: 150px" align="right"><fmt:formatNumber
								pattern="###,###,###" value="${OrderReady.price}" /></td>
						<td>${OrderReady.amount}</td>
						<td style="width: 150px" align="right"><fmt:formatNumber
								pattern="###,###,###" value="${OrderReady.sum}" /></td>
					</tr>
				</table>
				<table id="orderList">
					<tr>
						<th style="width: 70px; padding: 7px;">[기본 배송]</th>
						<th style="text-align: right; padding-right: 30px; width: 250px;"
							align="right">상품구매금액 : <fmt:formatNumber
								pattern="###,###,###" value="${OrderReady.sum}" /> 원 + 배송비
							2,500 원 = 총 <fmt:formatNumber pattern="###,###,###"
								value="${OrderReady.sum + 2500}" /> 원
						</th>
					</tr>
				</table>
				<div id="order_Information">배송 정보</div>
				<table id="order_Information">
					<tr>
						<th style="border-right: 1px solid; padding: 20px; width: 30%;">받으시는
							분</th>
						<th><input type="text" class="text_box" name="ordername"
							required></th>
					</tr>
					<tr>
						<th style="border-right: 1px solid; padding: 20px;">주소</th>
						<th><input type="text" class="text_box" name="address"
							required></th>
					</tr>
					<tr>
						<th style="border-right: 1px solid; padding: 20px;">휴대전화<br>(*
							- 빼고 입력해주세요 )
						</th>
						<th><input type="text" class="text_box" name="phone" required></th>
					</tr>
					<tr>
						<th style="border-right: 1px solid; padding: 20px;">이메일</th>
						<th><input type="text" class="text_box" name="email" required></th>
					</tr>
					<tr>
						<th style="border-right: 1px solid; padding: 20px;">배송메시지</th>
						<th><input type="text" class="text_box" name="orderMessage"></th>
					</tr>
				</table>

				<div id="order_Information">결제 수단</div>
				<table id="order_Information">
					<tr>
						<th style="border-right: 1px solid; padding: 20px;">입금자 명</th>
						<th><input type="text" class="text_box" name="depositor"></th>
					</tr>
					<tr>
						<th style="border-right: 1px solid; padding: 20px;">입금 은행</th>
						<th><select size='1' name="bank" class="text_box" required>
								<option value='' selected>-- 선택 --</option>
								<option value='NH 농협은행 : 356-1174-7453-33'>NH 농협은행 :
									356-747410-5333</option>
								<option value='KB 국민은행 : 519-018283-01-123'>KB 기업은행 :
									519-018283-01-123</option>
								<option value='SC 제일은행 : 528-20-199230'>SC 제일은행 :
									528-20-199230</option>
						</select></th>
					</tr>
				</table>
				<table id="orderList">
					<tr>
						<th style="width: 70px; padding: 7px;">[기본 배송]</th>
						<th style="text-align: right; padding-right: 30px; width: 250px;"
							align="right">상품구매금액 : <fmt:formatNumber
								pattern="###,###,###" value="${OrderReady.sum}" /> 원 + 배송비
							2,500 원 = 총 <fmt:formatNumber pattern="###,###,###"
								value="${OrderReady.sum + 2500}" /> 원
						</th>
					</tr>
				</table>
				<div style="width: 100%; text-align: center;">
					<input type="submit" value="결제하기" id="detilButton">
					<!-- onclick="javascript:orderSuccess()" -->
				</div>
			</form>
		</div>
	</div>

	<div id="bott">
		<jsp:include page="../section/footer.jsp" />
	</div>

	</div>
</body>
</body>
</html>