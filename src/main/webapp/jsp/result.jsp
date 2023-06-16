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
<h1>RESULT</h1>
<hr>
~영수증~<br>
대기번호 : ??<br>
<c:if test="${sessionScope.orderType eq 'simpleOrder'}"> <!-- 간편 결제시 -->
    결제하신 금액 : ${sessionScope.user.finalPrice }<br>
</c:if>
 <c:if test="${sessionScope.howPoint eq 'usePoint'}"> <!-- 포인트 사용시 -->
   	구매하신 금액 : ${sessionScope.user.totalPrice }<br>
    할인받은 금액 : ${sessionScope.user.usedPoint }<br>
    결제하신 금액 : ${sessionScope.user.finalPrice }<br>
	현재 포인트 : ${sessionScope.user.remainPoint }<br>
</c:if>
<c:if test="${sessionScope.howPoint eq 'notUsePoint'}"> <!-- 포인트 적립시 -->
    결제하신 금액 : ${sessionScope.user.finalPrice }<br>
	현재 포인트 : ${sessionScope.user.remainPoint }<br>
</c:if>
	주문하신 메뉴 : ?? 00개<br>
	추가 옵션 : ??<br>

	<form action="HomeController" method="get">
	<button>처음</button>
	</form>
	
	<a href="HomeController"><button>처음으로</button></a> <!-- 세션 삭제 -->
<!-- 	<a href="HC"><button onclick="location.href='HC222'">처음으로</button> 세션 삭제



 --></body>
</html>