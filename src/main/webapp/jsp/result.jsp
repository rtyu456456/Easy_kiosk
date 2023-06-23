<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
	<span class="result-desc">결제가 완료됐습니다. 이용해 주셔서 감사합니다.</span>
	<br><span class="result-ordernum-text">주문번호</span>
	<br><div class="result-ordernum">${sessionScope.orderNum }</div>
	<br><span class="result-receipt-text">영수증을 출력하시겠습니까?</span>
	<form action="ReceiptC">
		<button class="result-receipt-yes">예</button>
		<button type="button" onclick="location.href='HC'" class="result-receipt-no">아니오</button>
	</form>
</body>
</html>