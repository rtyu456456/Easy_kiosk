<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
<!-- <script type="text/javascript" src="js/result.js"></script> -->
</head>
<body>

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/09_결제가_완료됐습니다_영수증을_출력하시겠어요.mp3">
	</audio>

	<span class="result-desc">결제가 완료됐습니다. 이용해 주셔서 감사합니다.</span>
	<br><span class="result-ordernum-text">주문번호</span>
	<br><div class="result-ordernum">${sessionScope.orderNum }</div>
	<br><span class="result-receipt-text">영수증을 출력하시겠습니까?</span>
	<form action="ReceiptC">
		<button class="result-receipt-yes">예</button>
		<button type="button" onclick="location.href='HC'" class="result-receipt-no">아니오</button>
	</form>
	<p class="result-countdown"><span id="countdown"></span>초 후에 창이 닫힙니다.</p>
</body>
</html>