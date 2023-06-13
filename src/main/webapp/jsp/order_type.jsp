<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/normalize.css">
</head>
<body>
	<form action="OrderTypeC" method="post">
		<button type="button" onclick="history.back()">BACK</button>
		<button name="orderType" value="normalOrder">NORMAL ORDER</button>
		<button name="orderType" value="simpleOrder">SIMPLE ORDER</button>
	</form>
</body>
</html>