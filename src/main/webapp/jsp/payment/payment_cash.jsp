<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현금 결제</title>
</head>
<body id="payment-cash-body">

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/08_카운터에서_현금_결제를_해주세요.mp3">
	</audio>

	<form action="ResultC">
	<img src="./img/cashIcon.png" class="payment-cash-img">
	<div class="payment-cash-title">카운터의 점원에게
	<br>현금결제 부탁합니다.</div>
	<span class="payment-cash-desc">
	<c:if test="${sessionScope.howPoint != null}"> <!-- 포인트 기능 사용시 -->
	<c:if test="${sessionScope.orderType eq 'normalOrder' && sessionScope.howPoint eq 'usePoint'}">
	<!-- 일반 주문이고 포인트 사용시에만 출력 -->
	총 구매 가격 : ${sessionScope.user.totalPrice}원<br>
	사용 포인트 &nbsp: ${sessionScope.user.savingPoint }원<br>
	</c:if>
	남은 포인트 &nbsp: ${sessionScope.user.remainPoint }원<br>
	</c:if>
	</span>
	<span class="payment-cash-finalPrice-text">결제 가격 : </span><span class="payment-cash-finalPrice">${sessionScope.user.finalPrice}원</span>
		<button class="payment-cash-button">확인</button>
	</form>
</body>
</html>