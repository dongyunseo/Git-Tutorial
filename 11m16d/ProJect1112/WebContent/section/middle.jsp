<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
		<div class="topslide">
			<ul>
				<c:forEach items="${dtost}" var="dto">
					<li><a
						href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }" style="width: 500px;">${dto.dressimg}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="middWeekly">
			<ul class="middList">
				<c:forEach items="${dtosm}" var="dto">
					<li"><a
						href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }">${dto.dressimg }</a></li>
				</c:forEach>
			</ul>

		</div>

		<div class="listbox">
			<c:forEach items="${dtosw}" var="dto">
				<ul class="dressimg">
					<li><a
						href="../dressDetails/dressDetails_view.do?dressid=${dto.dressid }">${dto.dressimg }</a>
					</li>
					<li>${dto.dressname }</li>
					<li>${dto.price }원</li>
				</ul>
			</c:forEach>
		</div>
		
</body>
</html>