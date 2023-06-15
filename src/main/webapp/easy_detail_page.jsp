<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<button>Show modal</button>
	<dialog>
		<div id="">
			<img src="img/${menus.m_img }">
			<div>상품명</div>
			<div>가격</div>
			
			<button value="close">취소</button>
			<button value="confirm">확인</button>
		</div>
	</dialog>

<script type="text/javascript" src="js/modal.js"></script>
</body>
</html>