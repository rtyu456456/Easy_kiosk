<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Card</h1>
	<h2>${sessionScope.orderType}</h2>
	<h2>${sessionScope.whereToEat}</h2>
	${sessionScope.howPoint}
	<form action="ResultC">
		<button>카드 처리 완료</button>
		<button type="button" onclick="history.back()">뒤로</button>
	</form>
</body>
</html>