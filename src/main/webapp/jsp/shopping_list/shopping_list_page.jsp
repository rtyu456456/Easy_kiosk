<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Shopping List Page</h1>
	<table border="1px">
		<tr>
			<td>메뉴명</td>
			<td>가격</td>
			<td>수량</td>
		</tr>
		<c:forEach items="${menus }" var="m">
		<tr>
			<td>${m.name }</td>
			<td class="price">${m.price }</td>
			<td>
			<input class="plus-btn" type="button" value="1">
			<div class="count">1</div>
			<input class="origin-val" type="hidden" value="${m.price }">
			<input class="minus-btn" type="button" value="-1">
  			</td>
  			
		</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript" src="js/shopping_list/shoppinglist.js"></script>
</html>