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
		<button name="card" value="card" class="top-blue">
			<img src="./img/cardIcon.png" class="payment-method-card-img"><span
				class="payment-method-card-text">카드 결제 ></span><br>
				<span class="payment-method-card-desc">IC카드, 삼성 페이, Apple 페이</span>
		</button>
		<button name="cash" value="cash" class="under-white">
			<img src="./img/cashIcon.png" class="payment-method-cash-img"><span
				class="payment-method-cash-text">현금 결제 ></span><br>
				<span class="payment-method-cash-desc">선택 후 카운터에 있는 점원에게 현금 결제를 부탁드립니다</span>
		</button>
	</form>
</body>
</html>