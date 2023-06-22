<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping_list/shoppinglist.css">
</head>
<body>
	<div class="container">
		<table border="1px">
			<tr>
				<td>메뉴</td>
				<td>가격</td>
			</tr>
			<c:forEach items="${menus }" var="m">
			<tr>
				<td onclick="addToCart('${m.name}','${m.price}')">${m.name}</td>
				<td>${m.price}</td>
			</tr>
			</c:forEach>
		</table>
		<table id="cartTable2">
			<tr>
				<td class="box1"></td>
			</tr>
			<tr id="menu">
				<td colspan="2">
				</td>
			</tr>
		</table>
		<table id="cartTable">
			<tr>
				<td id="line"></td>
			</tr>
			<tr>	
				<td id="mungu" style="text-align: right">총 결제 금액</td>
			</tr>
			<tr>
				<td id="totalPrice" style="text-align: right"></td>
			</tr>
			<tr id="paybox">
				<td style="vertical-align: middle;"><img alt="" src="css/shopping_list/img/cardIcon.png" ></td>
				<td id="paybox_comment">결제하기</td>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="js/shopping_list/shoppinglist.js"></script>
</body>
</html>