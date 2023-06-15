<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=css/menu_page.css>
<link rel="stylesheet" href=css/modal_page.css>
</head>
<body>
	<div class="containor">


		<div class="header">
			<div class="logo">
				<img alt="" src="https://www.ediya.com/images/common/top_logo.gif">
				<button>직원 호출하기</button>
			</div>
			<jsp:include page="${easyTitlePage }"></jsp:include>
			<div class="header-under">
				<button>이전으로</button>
				<button>처음으로</button>
			</div>
		</div>


		<div class="easy-contents">
			<div>
				<jsp:include page="${easyContentsPage }"></jsp:include></div>
		</div>


		<div class="easy-footer">
			<div class="footer-page"></div>
			<div class="footer-button">
				<button>결제하기</button>
			</div>
		</div>

	</div>
<script type="text/javascript" src="js/modal.js"></script>
</body>
</html>