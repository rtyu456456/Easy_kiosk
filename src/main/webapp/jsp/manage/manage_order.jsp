<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr id="manage-order-header">
			<td>주문번호</td>
			<td>메뉴</td>
			<td>수량</td>
			<td>가격</td>
			<td>매장/포장</td>
		</tr>
		<c:forEach items="${orders }" var="s">
			<tr id="manage-order-orders">

				<td width="80px">${s.s_no }</td>
				<td>${s.s_menu }</td>
				<td>${s.s_count }</td>
				<td>${s.s_price }</td>
				<td>${s.s_type }</td>
				<td id="manage-order-confirm">
					<button onclick="location.href='ConfirmOrderC?s_no=${s.s_no }'">확인</button>
					<button onclick="cancelOrder(${s.s_no })">취소</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<form action="ConfirmOrderC" method="post">
					<button>일괄확인</button>
				</form>
			</td>
		</tr>

	</table>
</body>
</html>