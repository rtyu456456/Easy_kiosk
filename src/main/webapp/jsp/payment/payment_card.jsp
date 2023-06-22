<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드 결제</title>
</head>
<body>
	<form action="ResultC">
	<img src="./img/cardIcon.png" class="payment-card-img">
	<span class="payment-card-title">IC카드를 넣어주세요<br></span>
	<span class="payment-card-desc">
	<c:if test="${sessionScope.howPoint != null}"> <!-- 포인트 기능 사용시 -->
	<c:if test="${sessionScope.orderType eq 'normalOrder' && sessionScope.howPoint eq 'usePoint'}">
	<!-- 일반 주문이고 포인트 사용시에만 출력 -->
	총 구매 가격 : 6000<br>
	사용 포인트 &nbsp: ${sessionScope.user.savingPoint }원<br>
	</c:if>
	남은 포인트 &nbsp: ${sessionScope.user.remainPoint }원<br>
	</c:if>
	</span>
	<span class="payment-card-finalPrice-text">결제 가격 : </span><span class="payment-card-finalPrice">${sessionScope.user.finalPrice }원</span>
		<button class="payment-card-button">확인</button>
	</form>
	<!-- 
	-일반, 포인트 사용시
	1. 총 구매 가격
	2. 사용 포인트
	3. 남은 포인트
	4. 결제되는 가격
	
	-일반, 포인트 적립시
	1. 적립될 포인트(남은 포인트)
	2. 결제되는 가격
	
	-일반, 포인트기능 미사용
	1. 결제되는 가격
	
	-간편
	1. 결제되는 가격
	 -->
</body>
</html>