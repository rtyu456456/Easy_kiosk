<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 방식 선택</title>
</head>
<body>

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/02_주문_방식을_선택해주세요.mp3">
	</audio>

	<form action="OrderTypeC">
		<button name="orderType" value="normalOrder" class="top-blue">
			<img src="./img/normalOrderIcon.png" class="normal-order-img"><span
				class="normal-order-text">일반 주문 ></span><br>
			<span class="normal-order-desc">다양한 메뉴와 포인트 적립 혜택을 누릴 수 있어요!</span>
		</button>
		<br>
		<button name="orderType" value="simpleOrder" class="under-white">
			<img src="./img/simpleOrderIcon.png" class="simple-order-img"><span
				class="simple-order-text">간편 주문 ></span><br>
			<span class="simple-order-desc">무엇을 고를지 망설이시는 분, 어르신, 저희 카페가
				처음이신분들께 추천!</span>
		</button>
		<br>
	</form>
</body>
</html>