<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 사용 여부</title>
</head>
<body>
	<form action="UsePointC" method="post">
	<h1>use point</h1>
	${sessionScope.user.phoneNumber }님의 현재 포인트는 ${sessionScope.user.savingPoint }원 입니다.<br>
	600(임의값)원이 적립됩니다.
	<c:if test="${sessionScope.user.savingPoint != 0}"> <!-- 포인트가 있을때만 출력 -->
	<br>포인트를 모두 사용해서 할인을 받으시겠습니까?
	<br>사용하지 않으시면 600(임의값)원이 적립됩니다.
	<button name="usePoint" value="usePoint">포인트 사용</button>
	</c:if>
	<button type="button" onclick="location.href='PaymentMethodC?savePoint=savePoint'">적립 받기</button>
	<!--
	<button type="button" onclick="location.href='PaymentMethodC'" name="savePoint" value="savePoint">적립 받기</button>
	이렇게 하면 onclick="location.href='PaymentMethodC'" 부분이 문제이다. 뒤에 ?파라미터명, value이름을 넣어줘야한다.
	 -->
	</form>
</body>
</html>
