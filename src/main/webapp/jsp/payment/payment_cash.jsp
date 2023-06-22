<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현금 결제</title>
</head>
<body>
	<h1>Cash</h1>
	<h2>${sessionScope.orderType}</h2>
	<h2>${sessionScope.whereToEat}</h2>
	${sessionScope.howPoint}
	<form action="ResultC">
	카운터의 점원에게<br>
	현금결제 부탁합니다<br>
	<c:if test="${sessionScope.orderType eq 'normalOrder'}"> <!-- 일반 주문일때만 출력 -->
	총 구매 가격 : 6000<br>
	<c:if test="${sessionScope.user.savingPoint != 0}"> <!-- 사용 포인트가 있을 경우에만 출력 -->
	사용 포인트 : ${sessionScope.user.savingPoint }원<br>
	</c:if>
	남은 포인트 : ${sessionScope.user.remainPoint }원<br>
	</c:if>
	결제되는 가격 : ${sessionScope.user.finalPrice }원<br>
		<button>확인</button>
	</form>
</body>
</html>