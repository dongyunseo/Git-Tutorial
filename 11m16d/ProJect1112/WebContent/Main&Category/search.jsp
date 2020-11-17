<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/category.css">
<link rel="stylesheet" href="../css/footer.css">
</head>
<style>
</style>
<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/header.jsp" />
		</div>
	</div>
	<h3 style="width: 100%;">Search</h3>
	<div class="listbox">
		<c:choose>
			<c:when test="${Search != null}">
				<c:forEach items="${Search}" var="dto">
					<ul class="dressimg">
						<li><a
							href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }">${dto.dressimg }</a>
						</li>
						<li>${dto.dressname }</li>
						<li>${dto.price }원</li>
					</ul>
				</c:forEach>
			</c:when>
			<c:when test="${Search == null}">
				<h1>검색하신 상품이 없습니다.</h1>
			</c:when>
		</c:choose>
	</div>
	<div id="bott">
		<jsp:include page="../section/footer.jsp" />
	</div>
</body>