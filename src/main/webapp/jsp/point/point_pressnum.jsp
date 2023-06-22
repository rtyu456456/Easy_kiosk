
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 버튼 입력</title>
<script type="text/javascript" src="js/pressnum.js"></script>
</head>
<body class="main-view">
	<div class="point-pressnum-container scroll">
		<div class="point-pressnum-textarea">
			<span class="point-pressnum-subtitle">포인트 적립을 위한</span><br> <span
				class="point-pressnum-title">휴대폰 번호</span><br> <span
				class="point-pressnum-desc">010을 제외한<br>8자리 전화번호를
				입력해주세요.
			</span>
		</div>
		<div class="point-pressnum-pressnum">
			<form action="UsePointC" method="get"
				onsubmit="return validateForm()">
				<br> <input type="text" id="phoneNumber" name="phoneNumber"
					readonly="readonly"> <br>
				<button type="button" onclick="displayNumber(1)" class="num1">1</button>
				<button type="button" onclick="displayNumber(2)" class="num2">2</button>
				<button type="button" onclick="displayNumber(3)" class="num3">3</button>
				<br>
				<button type="button" onclick="displayNumber(4)" class="num4">4</button>
				<button type="button" onclick="displayNumber(5)" class="num5">5</button>
				<button type="button" onclick="displayNumber(6)" class="num6">6</button>
				<br>
				<button type="button" onclick="displayNumber(7)" class="num7">7</button>
				<button type="button" onclick="displayNumber(8)" class="num8">8</button>
				<button type="button" onclick="displayNumber(9)" class="num9">9</button>
				<br>
				<button type="button" onclick="clearNumber()" class="clear-num">지우기</button>
				<button type="button" onclick="displayNumber(0)" class="num0">0</button>
				<button type="button" onclick="deleteLastDigit()" class="backspace">
					<img src="./img/backSpaceIcon.png">
				</button>
				<br>
				<button class="point-pressnum-confirm">확인</button>
			</form>
		</div>
	</div>
</body>
</html>