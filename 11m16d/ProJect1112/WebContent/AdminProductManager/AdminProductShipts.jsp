<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<style>
#Product {
	width: 1500px;
	height: 100%;
	margin: auto;
	text-align: center;
}

#dressimg img {
	height: 300px;
}

#list {
	float: left;
	padding: 30px;
}

#name {
	margin-top: 10px;
	font-size: 15px;
	color: #6A6B6D;
	height: 30px;
	font-weight: normal;
}

#price {
	font-size: 15px;
	color: #76777c;
	margin: auto;
	font-weight: normal;
	padding-bottom: 50px;
}
</style>
<body>
<body>

	<div id="menu">
		<jsp:include page="AdminProduct.jsp" />
	</div>
	<div id="Product">
		<h3>Shipts</h3>
		<c:forEach items="${dtos}" var="dto">
			<div id="list">
				<div id="dressimg">
					<a
						href="../AdminProductManager/AdminProductDetail.ao?dressid=${dto.dressid }">${dto.dressimg }</a>
				</div>
				<div id="name">${dto.dressname }</div>
				<div id='price'>${dto.price }원</div>

			</div>
		</c:forEach>
	</div>
	<div id="bott">
		<jsp:include page="../Adminsection/footer.jsp" />
	</div>
</body>
</body>
</html>