<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Adminheader.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<style>
#Admin {
	text-align: center;
}

#Admincategory {
	font-family: Go, Arial, malgun gothic, 맑은고딕, NanumGothic, dotum, 돋움,
		sans-serif;
	font-weight: bold;
	width: 1000px;
	height: 100px;
	margin: auto;
}
</style>
<body>
<body>
	<div id="category">
		<div id="cate">
			<a href="../AdminProductManager/AdminPdOuter.ao" class=" "> <!-- 클릭시 'on' 클래스 추가 -->
				<span class="m_name">OUTER</span>
			</a>
		</div>
		<div id="cate">
			<a href="../AdminProductManager/AdminProductShipts.ao" class=" ">
				<!-- 클릭시 'on' 클래스 추가 --> <span class="m_name">SHIPTS</span>
			</a>
		</div>
		<div id="cate">
			<a href="../AdminProductManager/AdminProductTee.ao" class=" "> <!-- 클릭시 'on' 클래스 추가 -->
				<span class="m_name">TEE</span>
			</a>
		</div>
		<div id="cate">
			<a href="../AdminProductManager/AdminProductBottom.ao" class=" ">
				<!-- 클릭시 'on' 클래스 추가 --> <span class="m_name">BOTTOM</span>
			</a>
		</div>
		<div id="cate">
			<a href="../AdminProductManager/AdminProductAcc.ao" class=" "> <!-- 클릭시 'on' 클래스 추가 -->
				<span class="m_name">ACC</span>
			</a>
		</div>
	</div>
</body>
</body>
</html>