<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="easy-title">
		<span style="display: none;" id="tb">${sessionScope.tb }</span>
		<div>
			<button id="coffee-button" onclick="location.href='CoffeeController'">커피</button>
		</div>
		<div>
			<button id="tea-button" onclick="location.href='TeaController'">차</button>
		</div>
		<div>
			<button id="dessert-button" onclick="location.href='DessertController'">디저트</button>
		</div>
		<div>
			<button id="drink-button" onclick="location.href='DrinkController'">음료</button>
		</div>
	</div>

</body>
</html>

