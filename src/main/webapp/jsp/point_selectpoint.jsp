<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UsePointC">
	<h1>use point</h1>
	${sessionScope.user.phoneNumber }님의 포인트가 ?? 적립되어 현재 ${sessionScope.user.point }원입니다.
	<br> 포인트를 모두 사용해서 할인을 받으시겠습니까? 사용하지 않으시면 적립됩니다.
	<button>네</button>
	<button type="button" onclick="location.href='PaymentMethodC'">아니오</button>
	</form>
</body>
</html>
