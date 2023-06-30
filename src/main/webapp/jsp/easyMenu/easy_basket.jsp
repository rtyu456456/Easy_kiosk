<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="basket">
	<div class="grid-basket-container">
	<%-- <c:forEach var="basket-item" items=""> --%>
	<div class="grid-basket-item">
	<img class="basket-img" src="">
	<div class="basket-countButtons">
	<button class="minusButton">-</button>
	&nbsp;&nbsp;&nbsp;
	<span class="count-text">수량</span>
	&nbsp;&nbsp;&nbsp;
	<button class="plusButton">+</button>
	</div>
	</div>
	<%-- </c:forEach> --%>
	</div>
	<div class="basket-footer">
	<hr class="basket-line">
	<div class="basket-priceText">총 결제 금액</div>
	<div class="basket-price">5000원</div>
	<form action="PaymentMethodC">
	<button class="basket-payButton"><i class="fa-sharp fa-solid fa-credit-card"></i>결제하기</button>
	</form>
	</div>
	</div>
</body>
</html>