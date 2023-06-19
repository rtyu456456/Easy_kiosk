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
					<img alt="" src="img/직원호출.png"><br> 직원호출
				</button>
				<button id="before-button">
					<img alt="" src="img/leftArrow.png"><br> 이전으로
				</button>
			</div>
		</div>


		<div class="easy-contents">
			<div id="left-arrow">
				<c:choose>
					<c:when test="${curPageNo > 1 }">
						<button id="page-button"
							onclick="location.href='EasyPageController?p=${curPageNo - 1 }'">
							<img alt="" src="img/contents-left-arrow.png">
						</button>
					</c:when>
					<c:otherwise>
						<button id="page-button" disabled="disabled">
							<img alt="" src="img/contents-left-arrow.png">
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
						<img alt="" src="img/contents-left-arrow.png">
					</button>

				</c:when>
				<c:otherwise>
					<button id="page-button" disabled="disabled">
						<img alt="" src="img/contents-left-arrow.png">
					</button>
				</c:otherwise>
			</c:choose>
			</div>
		</div>


		<div class="easy-footer">
			<div class="footer-page"></div>
			<div class="footer-button">
				<button>결제하기</button>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="js/modal.js"></script>
	<script type="text/javascript" src="js/css.js"></script>

</body>
</html>