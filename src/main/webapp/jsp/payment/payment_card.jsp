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
	<h1>Card</h1>
	<h2>${sessionScope.orderType}</h2>
	<h2>${sessionScope.whereToEat}</h2>
	${sessionScope.howPoint}
	<form action="ResultC">
	IC카드를 넣어주세요<br>
	<c:if test="${sessionScope.orderType eq 'normalOrder'}"> <!-- 일반 주문일때만 출력 -->
	총 구매 가격 : 6000<br>
	<c:if test="${sessionScope.user.savingPoint != 0}"> <!-- 사용 포인트가 있을 경우에만 출력 -->
	사용 포인트 : ${sessionScope.user.savingPoint }원<br>
	</c:if>
	남은 포인트 : ${sessionScope.user.remainPoint }원<br>
	</c:if>
	결제되는 가격 : ${sessionScope.user.finalPrice }원<br>
	<!--
		if 현재소유 포인트 > 총 구매가격
		결제되는 가격 == 0원
		(else)if 현재소유 포인트 < 총 구매가격
		결제되는 가격 == 총 구매가격 - 사용되는 포인트
	-->
	<!--
		if 현재소유 포인트 > 총 구매가격
		남은 포인트 == 현재소유 포인트 - 총 구매 가격
		(else)if 현재소유 포인트 < 총 구매가격
		남은 포인트 == 0원
	 -->
		<button>확인</button>
	</form>
</body>
</html>