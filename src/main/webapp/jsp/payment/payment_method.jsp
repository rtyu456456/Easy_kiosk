<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 방식 선택</title>
</head>
<body>
	<form action="PaymentMethodC" method="post">
		<button name="card" value="card">카드</button>
		<button name="cash" value="cash">현금</button>
		<button name="qr" value="qr">QR코드</button>
	</form>
</body>
</html>