<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=css/menu_page.css>
<link rel="stylesheet" href=css/easy_basket.css>
<link rel="stylesheet" href=css/modal_page.css>
<script src="https://kit.fontawesome.com/6b43b4cc79.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>
<body>
	<iframe src="./mp3/silence.mp3" allow="autoplay" id="audio"
		style="display: none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/03_메뉴를_선택해주세요.mp3">
	</audio>
	<div class="containor">


		<div class="header">
			<form action="HC">
				<div class="home">
					<button id="home">
						<i class="fa-solid fa-house"></i> 처음으로
					</button>
				</div>
			</form>
			<jsp:include page="${easyTitlePage }"></jsp:include>
			<div class="header-under">
				<button id="call-button">
					<div>
						<i class="fa-solid fa-bell"></i>
					</div>
					직원호출
				</button>
				<form action="MainC" method="post">
				<button id="before-button">
					<div>
						<i class="fa-solid fa-arrow-right"></i>
					</div>
					이전으로
				</button>
				</form>
			</div>
		</div>


		<dialog id="staff-call">
		<div id="staff-call-page">
			<h1>
				카운터에 호출 요청이 전송되었습니다.<br> 잠시만 기다려 주세요.
			</h1>
			<button id="close-button">확인</button>
		</div>
		</dialog>





		<div class="easy-contents">
			<div id="left-arrow">
				<c:choose>
					<c:when test="${curPageNo > 1 }">
						<button id="page-button"
							onclick="location.href='EasyPageController?p=${curPageNo - 1 }'">
							<i id="left-arrow" class="fa-solid fa-chevron-up"></i>
						</button>
					</c:when>
					<c:otherwise>
						<button id="page-button" hidden disabled="disabled">
							<i id="left-arrow" class="fa-solid fa-chevron-up"></i>
						</button>
					</c:otherwise>
				</c:choose>
			</div>

			<div id="content-page">
				<jsp:include page="${easyContentsPage }"></jsp:include>
			</div>

			<div id="right-arrow">
				<c:choose>
					<c:when test="${curPageNo < pageCount }">

						<button id="page-button"
							onclick="location.href='EasyPageController?p=${curPageNo + 1 }'">
							<i id="right-arrow" class="fa-solid fa-chevron-up"></i>
						</button>

					</c:when>
					<c:otherwise>
						<button id="page-button" hidden disabled="disabled">
							<i id="right-arrow" class="fa-solid fa-chevron-up"></i>
						</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<aside class="aside">
			<div class="cartConParent">
				<div class="aside__grid-container" id="basketContainer"></div>
			</div>
			<span id="line"></span>
			<p class="aside__payText">총 결제 금액</p>
			<p class="aside__payPrice" id="basket-total-price"></p>
			<form action="PaymentMethodC">
				<button class="aside__payBtn">
					<i class="fa-sharp fa-solid fa-credit-card"></i> 결제하기
				</button>
			</form>
		</aside>



	</div>
	<script type="text/javascript" src="js/modal.js"></script>
	<script type="text/javascript" src="js/css.js"></script>
	<script type="text/javascript" src="js/easy_menu_page.js"></script>
	<script type="text/javascript" src="js/basket.js"></script>

</body>
</html>