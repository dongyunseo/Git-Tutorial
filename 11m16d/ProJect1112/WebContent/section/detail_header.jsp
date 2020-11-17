<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/17d793186c.js"crossorigin="anonymous"></script>
<script src="../script/header.js" defer>
</script>
</head>
<body>
	<nav class="navber">
		<div class="logo">
			<c:choose>
				<c:when test="${empty sessionScope.login_Name}">
					<ul class="nav__Login">
						<li><a href="../Member/mainLoginPage.jsp">LOGIN</a></li>
						<li><a href="../Member/signupPage.jsp">JOIN</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav__Login">
						<li style="color: white;">Login : ${sessionScope.login_Id }</li>
						<li><a href="../logout.so" onclick="return logout();">LOGOUT</a></li>
						<li><a href="../cart/cartSelect.co">Cart</a></li>
						<li><a href="../order/orderSelect.co">Order</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="menu">
				<li><a href="../Main&Category/main.do" class=" ">HomePage</a></li>
				<li><a href="../Main&Category/outer.do">OUTER</a></li>
				<li><a href="../Main&Category/shipts.do">SHIPTS</a></li>
				<li><a href="../Main&Category/tee.do">TEE</a></li>
				<li><a href="../Main&Category/bottom.do">BOTTOM</a></li>
				<li><a href="../Main&Category/acc.do">ACC</a></li>
		</div>
		<a href="#" class="toggleBtn"><i class="fas fa-bars"></i> </a>
	</nav>
</body>

</html>