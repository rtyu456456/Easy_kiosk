<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 버튼 입력</title>
<script type="text/javascript" src="js/pressnum.js"></script>
</head>
<body>
	010과 하이픈(-)을 제외한 8자리 전화번호
	<form action="EarnPointC" method="post" onsubmit="return validateForm()">
		<br> <input type="text" id="phoneNumber" name="phoneNumber" readonly="readonly">
		<br>
		<button type="button" onclick="displayNumber(1)">1</button>
		<button type="button" onclick="displayNumber(2)">2</button>
		<button type="button" onclick="displayNumber(3)">3</button>
		<br>
		<button type="button" onclick="displayNumber(4)">4</button>
		<button type="button" onclick="displayNumber(5)">5</button>
		<button type="button" onclick="displayNumber(6)">6</button>
		<br>
		<button type="button" onclick="displayNumber(7)">7</button>
		<button type="button" onclick="displayNumber(8)">8</button>
		<button type="button" onclick="displayNumber(9)">9</button>
		<br>
		<button type="button" onclick="displayNumber(0)">0</button>
		<button type="button" onclick="clearNumber()">지우기</button>
		<button type="button" onclick="deleteLastDigit()">←</button>

		<hr>
		<button>확인</button>
		<button type="button" onclick="history.back()">뒤로가기</button>
		<button type="button" onclick="location.href='HC'">처음으로</button>
	</form>
</body>
</html>