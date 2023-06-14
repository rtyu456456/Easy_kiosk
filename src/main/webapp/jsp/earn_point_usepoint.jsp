<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UsePointC">
	<h1>use point</h1>
	${sessionScope.user.phoneNumber }님의 포인트가 ?? 적립되어 현재 ${sessionScope.user.point }원입니다.
	<br> 포인트를 사용하시겠습니까?
	<button>네</button>
	<button type="button" onclick="location.href=''">아니오</button>
	</form>
</body>
</html>

<!--
String sql = select * from user where u_no = (입력받은 값);
if (rs.next){
 sql = update user set u_point = (기존값) + (받은값) where u_no = (입력받은 값);
} else {
 sql = insert into user values ((입력받은 값), (받은값));
} 
-->
