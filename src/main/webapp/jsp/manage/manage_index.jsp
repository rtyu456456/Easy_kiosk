<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/manage.css">
</head>
<body>
	<div class="manage-container">
		<div class="manage-logo">
			<img alt="" src="./imgs/easy_kiosk_logo.png">
		</div>
		<div class="manage-navbar">
			<button id="manage-order-btn" onclick="location.href='ManageMainC'">주문관리</button>
			<button id="manage-menu-btn" onclick="location.href='ManageMenuC'">메뉴관리</button>
			<button id="manage-sales-btn" onclick="location.href='ManageSalesC'">매상관리</button>
			
		</div>
		<div class="manage-main">
			<jsp:include page="${contentPage }"></jsp:include>
		</div>
	</div>

</body>
<script src="js/manage/deleteMenu.js"></script>
<script src="js/manage/manageOrder.js"></script>

</html>