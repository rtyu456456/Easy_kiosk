<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="PaymentMethodC" method="get">
	총 구매 가격 : 6000<br>
	사용 포인트 : ${sessionScope.user.savingPoint }원<br>
	결제되는 가격 : ${sessionScope.user.finalPrice }원<br>
	<!--
		if 현재소유 포인트 > 총 구매가격
		결제되는 가격 == 0원
		(else)if 현재소유 포인트 < 총 구매가격
		결제되는 가격 == 총 구매가격 - 사용되는 포인트
	-->
	남은 포인트 : ${sessionScope.user.remainPoint }원
	<!--
		if 현재소유 포인트 > 총 구매가격
		남은 포인트 == 현재소유 포인트 - 총 구매 가격
		(else)if 현재소유 포인트 < 총 구매가격
		남은 포인트 == 0원
	 -->
	 	<button>결제 화면으로</button>
	 </form>
</body>
</html>