
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/detail.css">
<link rel="stylesheet" href="../css/ReviewList.css">
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
	function btn() {
		alert('로그인 하세요');
		document.cartInsert.action = "../Member/mainLoginPage.jsp";
		document.cartInsert.submit();
	}
	function btn() {
		alert('로그인 하세요');
		document.dressbuy.action = "../Member/mainLoginPage.jsp";
		document.dressbuy.submit();
	}
	function cartselect() {
		alert('장바구니에 담았습니다. ');
		document.dressbuy.action = "../cart/cartInsert.co";
		document.dressbuy.submit();
	}
	function orderselect() {
		alert('구매 페이지로 이동합니다.');
		document.dressbuy.action = "../order/orderHalf.jsp";
		document.dressbuy.submit();
	}
	function ReviewSelect() {
		alert('리뷰 작성완료.');
		document.Review.action = "../dressDetails/dressDetails_Review.do";
		document.Review.submit();
	}
</script>
<style>
#ReviewSelect {
	font-size: 12px;
	text-align: center;
	margin: auto;
	color: #999;
	width: 100%;
	margin-bottom: 80px;
}
</style>
</head>
<body onload="init();">
	<div id="header">
		<jsp:include page="../section/detail_header.jsp" />
	</div>

	<div class="dress_Information">
		<form name="dressbuy" method="post" style="padding-bottom: 60px;">
			<div class="dress_img">${dto.dressimg }</div>
			<div class="dress_Side">
				<div class="dress_price">${dto.price}원</div>
				<div class="dress_name">${dto.dressname }</div>
				<hr class="dress_line">
				<input type="hidden" name="dressimg" value="${dto.dressimg }">
				<input type="hidden" name="dressid" value="${dto.dressid }">
				<input type="hidden" name="dressname" value="${dto.dressname }">
				<div class="totalprice">
					Total :&nbsp;&nbsp; <input type="text" id="totalp" name="sum"
						readonly>원
				</div>
				<div class="totalprice_but">
					수량 : <input type=hidden name="sell_price" value=${dto.price}>
					<input type="text" name="amount" value="1" size="3"
						onchange="change();"> <input type="button" value=" + "
						onclick="add();"> <input type="button" value=" - "
						onclick="del();"> <br> <input type="hidden"
						name="price" value="${dto.price }">
				</div>
			</div>
			<div id="cart_order">
				<c:choose>
					<c:when test="${empty sessionScope.login_Name}">
						<input type="submit" value="장바구니 담기 " id="detilButton"
							onclick="javascript:btn()" />
						<input type="submit" value="바로 구매 " id="detilButton"
							onclick="javascript:btn()" />
					</c:when>
					<c:otherwise>
						<input type="submit" value="장바구니 담기 " id="detilButton"
							onclick="javascript:cartselect()">

						<input type="submit" value="바로 구매 " id="detilButton"
							onclick="javascript:orderselect()" />
					</c:otherwise>
				</c:choose>
			</div>
		</form>
	</div>
	<div id="imglist">
		<div id="listimg">${dto.dressimg }</div>
		<div id="FABRIC">
			FABRIC INFO<br> <br> 사이즈 - 타이트한핏 / 적당한핏 / 루즈한핏<br> 두께감
			- 얇은 / 적당함 / 두꺼움 <br> 신축성 - 좋은 /보통 / 없음<br> 비침 - 있음 / 약간있음
			/ 없음<br> 안감 - 있음 / 없음<br> <br> <br> COLOR<br>
			<br> 크림,블랙,화이트 <br> <br> <br> FABRIC <br> <br>
			코튼<br> <br> <br> WASHING<br> <br> 모든 의류는 첫
			세탁시 드라이크리닝을 권장합니다. <br>드라이크리닝이 어려울시 손세탁을 하시면 변형을 최소화 하실수 있습니다.<br>
			<br> <br> SIZE <br>(단위cm)<br> <br>[FREE
			100-105] 어깨 47 / 가슴 62 / 소매 22 / 총기장 77<br> (사이즈는 측정 방법에 따라
			2-3cm정도 오차가 생길수 있습니다.) <br> <br> <br> PROUCTION <br>
			<br> 제조자 / 동윤브로 제휴 업체 제조국 / 한국제조년월 / 2020년 07월 <br> 품질보증기간
			/ 소비자 분쟁 해결 기준에 따름 AS 책임자와 전화번호 / 서동윤의 고객센터<br> 010-9105-2766<br>
		</div>
		<div id="listimg">
			<span>${dto.dressimg }</span>
		</div>
	</div>
	<div id="ReviewList">Review List</div>


	<div class="reivew_box">
		<c:forEach items="${ReviewdressidList}" var="reviewVO">
			<ul class="reivew_list">
				<li class="reivew_img">${reviewVO.reviewimg }</li>
				<li class="reivew_title"><details>
						<summary>리뷰 제목 : ${reviewVO.reviewtitle}</summary>
						<p>리뷰 내용 : ${reviewVO.reviewcontent}</p>
					</details></li>
				<li class="reivew_name"><details>
						<summary>리뷰 작성자 : ${reviewVO.id} </summary>
						<p>리뷰 작성일 : ${reviewVO.reviewDate}</p>
						<p>별점 : ${reviewVO.reviewscore}</p>
					</details></li>
			</ul>
		</c:forEach>
	</div>
	<div>
		<ul class="PageNumber">
			<li><a
				href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }
				&page=${reviewCountDto.firstPageNum }&pageDataCount=${reviewCountDto.pageDataCount}">
					<< </a></li>
			<li><a
				href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }
				&page=${reviewCountDto.prevPageNum }&pageDataCount=${reviewCountDto.pageDataCount}">
					<</a></li>
			<c:forEach var="num" begin="${reviewCountDto.startPageNum }"
				end="${reviewCountDto.endPageNum }" step="1">
				<li><a
					href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }
							&page=${num }&pageDataCount=${reviewCountDto.pageDataCount}">
						${num }</a></li>
			</c:forEach>
			<li><a
				href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }
				&page=${reviewCountDto.nextPageNum }&pageDataCount=${reviewCountDto.pageDataCount}">
					> </a></li>
			<li><a
				href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }
				&page=${reviewCountDto.lastPageNum }&pageDataCount=${reviewCountDto.pageDataCount}">
					>> </a>
		</ul>
	</div>

	<div id="ReviewSelect">
		<form method="post" name="Review" enctype="multipart/form-data">
			<div id="QQAA">Review 작성</div>
			<div id="Insert">
				<input type="hidden" name="id" value="${sessionScope.login_Id }">
				<input type="hidden" name="dressid" value="${dto.dressid }">
				<input type="hidden" name="dressname" value="${dto.dressname }">

				<br /> <input type="text" placeholder="제목" name="reviewtitle"
					required class="Datail_title" /> <br /> <br /> <input
					type="text" placeholder="내용" name="reviewcontent" required
					class="Datail_content" " /> <br /> <br />
			</div>
			<input type="file" name="reviewImg" id="Img"><select size='1'
				class="Imgselect" name="reviewscore" required>
				<option value='' selected>-- 선택 --</option>
				<option value='★★★★★아주 좋아요'>★★★★★아주 좋아요</option>
				<option value='☆★★★★마음에 들어요'>☆★★★★마음에 들어요</option>
				<option value='☆☆★★★보통이에요'>☆☆★★★보통이에요</option>
				<option value='☆☆☆★★그냥 그래요'>☆☆☆★★그냥 그래요</option>
				<option value='☆☆☆☆★별로에요'>☆☆☆☆★별로에요</option>
			</select>
			<p>
				<c:choose>
					<c:when test="${empty sessionScope.login_Name}">
						<input type="submit" value="작성하기" class="QandA_in"
							onclick="javascript:btn()" />
						<br />
						<br />
					</c:when>
					<c:otherwise>
						<input type="submit" value="작성하기" class="QandA_in"
							onclick="javascript:ReviewSelect()" />
						<br />
						<br />
					</c:otherwise>
				</c:choose>
			</p>
		</form>
	</div>
	<div id="QandA_list">
		<form name="cartInsert" method="post" action="dressDetails_view.do">
			<input type="hidden" name="dressid" value="${dto.dressid }">

			<div id="QQAA">Q&A List</div>
			<div id="list">
				<table id="Qlist">
					<tr>
						<th style="width: 70px; height: 30px;">Number</th>
						<th style="width: 570px; height: 30px;">TITLE</th>
						<th style="width: 130px; height: 30px;">작성자</th>
						<th style="width: 130px; height: 30px;">날짜</th>
						<th style="width: 130px; height: 30px;">글 삭제</th>
					</tr>
					<c:forEach items="${dressDetails}" var="qandAVo">
						<input type="hidden" name="loginid"
							value=${sessionScope.login_Id }>
						<input type="hidden" name="QandAID" value=${qandAVo.id }>
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

							<c:choose>
								<c:when test="${empty sessionScope.login_Name}">
									<td class="delete"><input type="submit"
										value="${qandAVo.qandaid}" id="QandAdelButton"
										onclick="javascript:btn()"
										style="border: 0px; background: white;" /></td>
								</c:when>
								<c:otherwise>
									<td class="delete"><input type="submit"
										onclick="return confirm('정말로 삭제하시겠습니까?')" name="qandaid"
										value="${qandAVo.qandaid}"
										style="border: 0px; background: white;"></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
	<!-- action="QandAInsert.so" -->
	<div id="QQAA">Q&A 작성</div>
	<div id="QandA_insert">
		<form method="post" name="QandAform" action="dressDetails_view.do">
			<div id="Insert">
				<input type="hidden" name="dressid" value="${dto.dressid }">
				<br /> <input type="text" placeholder="제목" name="qandatitle"
					required class="Datail_title" /> <br /> <br /> <input
					type="text" placeholder="내용" name="qandacontent" required
					class="Datail_content" /> <br /> <br />
			</div>

			<p>
				<c:choose>
					<c:when test="${empty sessionScope.login_Name}">
						<input type="submit" value="작성하기" class="QandA_in"
							onclick="javascript:btn()" />
						<br />
						<br />
					</c:when>
					<c:otherwise>
						<input type="submit" value="작성하기" class="QandA_in" />
						<br />
						<br />
					</c:otherwise>
				</c:choose>
			</p>
		</form>
	</div>
	<div id="bott">
		<jsp:include page="../section/footer.jsp" />
	</div>
</body>
</html>