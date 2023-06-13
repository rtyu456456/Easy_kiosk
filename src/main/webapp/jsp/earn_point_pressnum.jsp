<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호 버튼 입력</title>
<script type="text/javascript">
	function displayNumber(buttonNumber) {
		var phoneNumberInput = document.getElementById("phoneNumber");
		var phoneNumber = phoneNumberInput.value;
		if (phoneNumber.length < 8) {
			phoneNumber += buttonNumber;
			phoneNumberInput.value = phoneNumber;
		} 
	}
	function clearNumber() {
		document.getElementById("phoneNumber").value = "";
	}
	function deleteLastDigit() {
		var phoneNumber = document.getElementById("phoneNumber").value;
		if (phoneNumber.length > 0) {
			phoneNumber = phoneNumber.slice(0, -1);
			document.getElementById("phoneNumber").value = phoneNumber;
		}
	}
	function validateForm() {
		var phoneNumber = document.getElementById("phoneNumber").value;
		if (phoneNumber.length < 8) {
			alert("전화번호는 8자리 이상이어야 합니다.");
			clearNumber();
			return false;
		}
	}
</script>
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
	</form>
</body>
</html>