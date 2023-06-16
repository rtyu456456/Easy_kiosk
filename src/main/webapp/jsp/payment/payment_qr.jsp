<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR 코드 결제</title>
</head>
<body>
	<h1>QR</h1>
	<h2>${sessionScope.orderType}</h2>
	<h2>${sessionScope.whereToEat}</h2>
	${sessionScope.howPoint}
	<form action="ResultC">
		<button>QR 코드 결제 완료</button>
		<button type="button" onclick="history.back()">뒤로</button>
	</form>
</body>
</html>