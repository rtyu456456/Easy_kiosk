<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sessionScope.orderType}</h1>
	<h1>${sessionScope.whereToEat}</h1>
	<form action="PaymentMethodC" method="get">
		<button>결제하기</button>
		<button type="button" onclick="history.back()">뒤로가기</button>
		<button type="button" onclick="location.href='HC'">처음으로</button>
	</form>
</body>
</html>