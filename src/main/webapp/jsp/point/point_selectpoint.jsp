<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 사용 여부</title>
</head>
<body class="main-view">

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/06_포인트_이용_방식을_선택해주세요.mp3">
	</audio>

	<form action="UsePointC" method="post">
		<div class="point-selectpoint-top-blue">
			<span class="point-selectpoint-phonenumber">${sessionScope.user.phoneNumber }님의</span><br>
			<span class="point-selectpoint-nowpoint-text">현재 포인트 : <span class="point-selectpoint-nowpoint">${sessionScope.user.savingPoint }원</span></span>
			<c:if test="${sessionScope.user.savingPoint != 0}">
				<!-- 포인트가 있을때만 출력 -->
				<button name="usePoint" value="usePoint" class="point-selectpoint-usepoint">사용하기</button>
			</c:if>
		</div>
		<div class="point-selectpoint-under-white">
			<span class="point-selectpoint-pluspoint-text">예상 적립 포인트 : <span class="point-selectpoint-pluspoint">600원</span></span>
			<button type="button" onclick="location.href='PaymentMethodC?savePoint=savePoint'" class="point-selectpoint-savepoint">적립하기</button>
		</div>
	<!--
	<button type="button" onclick="location.href='PaymentMethodC'" name="savePoint" value="savePoint">적립 받기</button>
	이렇게 하면 onclick="location.href='PaymentMethodC'" 부분이 문제이다. 뒤에 ?파라미터명, value이름을 넣어줘야한다.
	 -->
	</form>
</body>
</html>
