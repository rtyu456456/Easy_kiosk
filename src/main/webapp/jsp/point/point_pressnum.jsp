
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

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/05_8자리_전화번호를_입력해주세요.mp3">
	</audio>
	
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
				<div class="phoneNumber-container"> <br> 
				<span class="point-pressnum-010">010 - </span>
				<input type="text" id="firstInput" name="firstInput" readonly="readonly" class="point-pressnum-firstInput">
				<span class="point-pressnum-hyphen">-</span>
				<input type="text" id="secondInput" name="secondInput" readonly="readonly" class="point-pressnum-secondInput">
				<br>
				</div>
				<button type="button" onclick="addNumberToInput(1)" class="num1">1</button>
				<button type="button" onclick="addNumberToInput(2)" class="num2">2</button>
				<button type="button" onclick="addNumberToInput(3)" class="num3">3</button>
				<br>
				<button type="button" onclick="addNumberToInput(4)" class="num4">4</button>
				<button type="button" onclick="addNumberToInput(5)" class="num5">5</button>
				<button type="button" onclick="addNumberToInput(6)" class="num6">6</button>
				<br>
				<button type="button" onclick="addNumberToInput(7)" class="num7">7</button>
				<button type="button" onclick="addNumberToInput(8)" class="num8">8</button>
				<button type="button" onclick="addNumberToInput(9)" class="num9">9</button>
				<br>
				<button type="button" onclick="clearNumber()" class="clear-num">지우기</button>
				<button type="button" onclick="addNumberToInput(0)" class="num0">0</button>
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