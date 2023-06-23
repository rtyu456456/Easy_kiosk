<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 적립 여부</title>
</head>
<body class="main-view">

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/04_포인트를_사용하시거나_적립하시겠어요.mp3">
	</audio>

	<form action="EarnPointC" method="post">
		<img src="./img/pointRound.png" class="point-round">
		<span class="point-text">P</span><br>
		<span class="point-confirm-desc">포인트를<br>
		사용/적립하시겠어요?</span><br>
		<button class="point-confirm-yes">예</button>
		<button type="button" onclick="location.href='PaymentMethodC'" class="point-confirm-no">아니오</button>
	</form>
</body>
</html>