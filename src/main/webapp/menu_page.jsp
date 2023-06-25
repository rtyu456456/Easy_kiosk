<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=css/menu_page.css>
<link rel="stylesheet" href=css/modal_page.css>
<script src="https://kit.fontawesome.com/6b43b4cc79.js"
	crossorigin="anonymous"></script>
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	
</head>
<body>
	<div class="containor">


		<div class="header">
			<div class="home">
				<button id="home">
					<i class="fa-solid fa-house"></i> 처음으로
				</button>
			</div>
			<jsp:include page="${easyTitlePage }"></jsp:include>
			<div class="header-under">
				<button id="call-button">
					<div><i class="fa-solid fa-bell"></i></div>
					직원호출
				</button>
				<button id="before-button">
					<div><i class="fa-solid fa-arrow-right"></i></div> 
					이전으로
				</button>
			</div>
		</div>

	
		<dialog id="staff-call">
		<div id="staff-call-page">	
		<h1>
		카운터에 호출 요청이 전송되었습니다.<br>
		잠시만 기다려 주세요.
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


		<div class="easy-footer">
			<div class="menu-box">
				<img alt="" src="${a.img }"> <br> 
				이름 : ${a.name } <br>
 				가격 : ${a.price } <br>
 				수량 : ${a.count }개 <br>
 				ice/hot : ${a.ice } <br>
 				사이즈 : ${a.size }
			</div>
			<div class="pay-box">
				<div class="line"></div>
				<div class="comment-total">총 결제 금액</div>
				<div class="total">원</div>
				<div class="pay-btn">
					<img alt="" src="css/img/cardIcon.png">
					<div class="comment-pay">결제하기</div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="js/modal.js"></script>
	<script type="text/javascript" src="js/css.js"></script>
	<script type="text/javascript" src="js/staff_call.js"></script>
</body>
</html>