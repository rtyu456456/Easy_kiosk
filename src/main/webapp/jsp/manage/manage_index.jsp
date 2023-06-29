<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/manage.css">
</head>
<body>
	<div class="manage-container">
		<div class="manage-logo">로고</div>
		<div class="manage-navbar">
			<ul>
				<li><a href="ManageMainC">주문관리</a></li>
				<li><a href="ManageMenuC">메뉴관리</a></li>
				<li><a href="ManageSalesC">매상관리</a></li>
			</ul>
		</div>
		<div class="manage-search">검색, 필터링, 날짜지정</div>
		<div class="manage-main">
			<jsp:include page="${contentPage }"></jsp:include>
		</div>
	</div>

</body>
<script src="js/updateMenu.js"></script>
<script src="js/addMenu.js"></script>
<script src="js/deleteMenu.js"></script>
</html>