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
	${sessionScope.user.phoneNumber }님의 포인트가 ?? 적립되어 현재 ${sessionScope.user.savingPoint }원입니다.
	<br> 포인트를 모두 사용해서 할인을 받으시겠습니까? 사용하지 않으시면 적립됩니다.
	<button name="usePoint" value="usePoint">포인트 사용</button>
	<button type="button" onclick="location.href='PaymentMethodC?notUsePoint=notUsePoint'">적립 받기</button>
	<!--
	<button type="button" onclick="location.href='PaymentMethodC'" name="notUsePoint" value="notUsePoint">적립 받기</button>
	이렇게 하면 onclick="location.href='PaymentMethodC'" 부분이 문제이다. 뒤에 ?파라미터명, value이름을 넣어줘야한다.
	 -->
	</form>
</body>
</html>
