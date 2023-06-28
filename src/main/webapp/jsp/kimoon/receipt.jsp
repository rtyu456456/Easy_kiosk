<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
document.addEventListener('DOMContentLoaded', function() {
	  var deleteButton1 = document.getElementById('resetLocalStorage');
	  deleteButton1.addEventListener('click', function() {
	    localStorage.clear();
	    console.log("삭제 성공");
	  });
</script>
</head>
<body>
<div style="position: relative; top:200px; left: 800px; width: 20%; border: solid black 1px; text-align: center">
	<h1>[영수증]</h1>
	<h3>주문번호 : ${sessionScope.orderNum }</h3><hr>
	<c:if test="${sessionScope.whereToEat eq 'eatin'}">
		매장 주문<br>
	</c:if>
	<c:if test="${sessionScope.whereToEat eq 'takeout'}">
		포장 주문<br>
	</c:if>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	주문일시 : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss" /><br>
	<c:if test="${sessionScope.orderType eq 'simpleOrder' || sessionScope.orderType eq 'normalOrder'}"> <!-- 간편 결제, 포인트 사용 안 할시 -->
    	결제하신 금액 : ${sessionScope.user.finalPrice }<br>
	</c:if>
	<c:if test="${sessionScope.howPoint eq 'usePoint'}"> <!-- 포인트 사용시 -->
   		구매하신 금액 : ${sessionScope.user.totalPrice }<br>
    	할인받은 금액 : ${sessionScope.user.usedPoint }<br>
		현재 포인트 : ${sessionScope.user.remainPoint }<br>
	</c:if>
	<c:if test="${sessionScope.howPoint eq 'savePoint'}"> <!-- 포인트 적립시 -->
		현재 포인트 : ${sessionScope.user.remainPoint }<br>
	</c:if>
	주문하신 메뉴 : ${sessionScope.user.totalCnt }개<br>
	추가 옵션 : ??<hr>
<button onclick="location.href='HC'" id="resetLocalStorage">처음으로</button>
</div>
</body>
</html>