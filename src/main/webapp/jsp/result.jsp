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
	결제가 완료됐습니다. 이용해 주셔서 감사합니다.
	<br>주문번호
	<br>${sessionScope.orderNum }
	<br>영수증을 출력하시겠습니까?
	<form action="ReceiptC">
		<button>예</button>
	</form>
	<button onclick="location.href='HC'">아니오</button>
</body>
</html>