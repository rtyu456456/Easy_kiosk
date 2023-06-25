<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간편 주문</title>
</head>
<body>
	<iframe src="./mp3/silence.mp3" allow="autoplay" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/03_메뉴를_선택해주세요.mp3">
	</audio>
	<div style="position: relative; top: 40%; left: 50%; color: white;">
	<h1>${sessionScope.orderType}</h1>
	<h1>${sessionScope.whereToEat}</h1>
	<form action="PaymentMethodC" method="get">
		<button>결제하기</button>
	</form>
	</div>
</body>
</html>