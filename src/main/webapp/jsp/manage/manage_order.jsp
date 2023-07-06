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
	<div class="manage-menu-wrapper">
		<c:forEach items="${orders }" var="s">
			<div class="manage-menu-main">
				<div class="manage-item">${s.s_no }</div>
				<div class="manage-item">${s.s_tel }</div>
				<div class="manage-item">${s.s_menu }</div>
				<div class="manage-item">${s.s_count }</div>
				<div class="manage-item">${s.s_price }</div>
				<div class="manage-item">${s.s_type }</div>
				<div>
					<button onclick="location.href='ConfirmOrderC?s_no=${s.s_no }'">확인</button>
					<button onclick="cancelOrder(${s.s_no })">취소</button>
				</div>
			</div>
		</c:forEach>
		<form action="ConfirmOrderC" method="post">
			<button>일괄확인</button>
		</form>
	</div>

</body>
</html>