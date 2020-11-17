<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		return confirm("로그아웃하시겠습니까?")

	}
</script>
<style>
#Admincategory {
	font-family: Go, Arial, malgun gothic, 맑은고딕, NanumGothic, dotum, 돋움,
		sans-serif;
	font-weight: bold;
	width: 1000px;
	height: 100px;
	margin: auto;
}
</style>
</head>
<body>
	<div id="one">
		<c:choose>
			<c:when test="${empty sessionScope.login_Id}">
				<div id="idLogin1">
					<a href="../Adminlogin/AdminLogin.jsp">Login</a> <a
						href="../Adminlogin/signupPage.jsp" class="Login">Join</a>
				</div>
			</c:when>
			<c:otherwise>
				<div id="idLogin2">
					${sessionScope.login_Id } 님 환영합니다. <a href="../logout.so"
						onclick="return logout();">LOGOUT</a>
				</div>

			</c:otherwise>
		</c:choose>

		<div id="Admincategory">
			<div id="cate">
				<a href="../AdminProductManager/AdminPdOuter.ao" class=" "> <span
					class="m_name">상품 관리</span>
				</a>
			</div>
			<div id="cate">
				<a href="../AdminMember/AllMemberList.jsp" class=" "> <!-- 클릭시 'on' 클래스 추가 -->
					<span class="m_name">회원 관리</span>
				</a>
			</div>
			<div id="cate">
				<a href="../AdminReview&QandA/AdminQandA.ao" class=" "> <!-- 클릭시 'on' 클래스 추가 -->
					<span class="m_name">리뷰 관리</span>
				</a>
			</div>
			<div id="cate">
				<a href="../AdminOrder/AllOrderList.ao" class=" "> <!-- 클릭시 'on' 클래스 추가 -->
					<span class="m_name">주문 관리</span>
				</a>
			</div>
		</div>
	</div>






</body>
</html>
