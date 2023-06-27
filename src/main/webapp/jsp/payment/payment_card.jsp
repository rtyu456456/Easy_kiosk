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

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/08_IC_카드를_넣어주세요.mp3">
	</audio>

	<form action="ResultC">
	<img src="./img/cardIcon.png" class="payment-card-img">
	<span class="payment-card-title">IC카드를 넣어주세요<br></span>
	<span class="payment-card-desc">
	<c:if test="${sessionScope.orderType eq 'normalOrder' && sessionScope.howPoint eq 'usePoint'}"> <!-- 포인트 기능 사용시 -->
	<!-- 일반 주문이고 포인트 사용시에만 출력 -->
	총 구매 가격 : ${sessionScope.user.totalPrice}원<br>
	사용 포인트 &nbsp: ${sessionScope.user.savingPoint }원<br>
	남은 포인트 &nbsp: ${sessionScope.user.remainPoint }원<br>
	<span class="payment-card-finalPrice-text">결제 가격 : </span><span class="payment-card-finalPrice">${sessionScope.user.finalPrice}원</span>
	</c:if>
	<c:if test="${sessionScope.orderType eq 'normalOrder' && sessionScope.howPoint eq 'savePoint'}">
	결제 후 적립될 포인트 &nbsp: ${sessionScope.user.remainPoint }원<br>
	<span class="payment-card-finalPrice-text">결제 가격 : </span><span class="payment-card-finalPrice">${sessionScope.user.finalPrice}원</span>
	</c:if>
	<c:if test="${sessionScope.orderType eq 'simpleOrder' || sessionScope.howPoint eq null }">
	<span class="payment-card-finalPrice-text">결제 가격 : </span><span class="payment-card-finalPrice">${sessionScope.user.totalPrice}원</span>
	</c:if>
	</span>
	<input name="totalPrice" type="hidden">	
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
	 <script>
	 /* const finalPrice = document.querySelector(".payment-card-finalPrice");

	 var jsonData = localStorage.getItem('cartItems');
	 var parsedData = JSON.parse(jsonData);

	 var totalPrice = 0; // 가격의 합계를 저장할 변수

	 for (var i = 0; i < parsedData.length; i++) {
	   totalPrice += parsedData[i].price;
	 }
	 finalPrice.innerText = totalPrice + "원";
	 console.log(totalPrice);
	 const total = document.querySelector("input[name='totalPrice']");
	 total.value = totalPrice;
	 console.log("total.value : ", total.value); */
	 </script>
</body>
</html>