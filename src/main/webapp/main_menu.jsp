<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main Page</h1>
	<form action="HC">
	<table border="1px">
		<tr>
			<td>메뉴</td>
			<td>가격</td>
		</tr>
		<c:forEach items="${menus }" var="m">
		<tr>
			<td>${m.name}</td>
			<td>${m.price}</td>
		</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td>
				<jsp:include page="${contentPage }"></jsp:include>
			</td>	
		</tr>
	</table>
	</form>
</body>
</html>