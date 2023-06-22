
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
		alert("전화번호를 8자리 입력해주세요.");
		clearNumber();
		return false;
	}
}