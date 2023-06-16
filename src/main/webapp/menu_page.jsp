<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=css/menu_page.css>
<link rel="stylesheet" href=css/modal_page.css>
<script src="https://kit.fontawesome.com/6b43b4cc79.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="containor">


		<div class="header">
			<div class="logo">
				<img id="logo" src="https://www.ediya.com/images/common/top_logo.gif">
				<button id>직원 호출하기</button>
			</div>
			<jsp:include page="${easyTitlePage }"></jsp:include>
			<div class="header-under">
				<button>이전으로</button>
				<button>처음으로</button>
			</div>
		</div>


		<div class="easy-contents">
			<c:choose>
				<c:when test="${curPageNo > 1 }">
					<button id="page-button" onclick="location.href='EasyPageController?p=${curPageNo - 1 }'">
						<i class="fa-solid fa-angle-left"></i>
						</button>
				</c:when>
				<c:otherwise>
					<button id="page-button" disabled="disabled">
					<i class="fa-solid fa-angle-left"></i>
					</button>
				</c:otherwise>
			</c:choose>
			
			<div id="content-page">
				<jsp:include page="${easyContentsPage }"></jsp:include>
			</div>
			
			<c:choose>
				<c:when test="${curPageNo < pageCount }">
					
						<button id="page-button" onclick="location.href='EasyPageController?p=${curPageNo + 1 }'">
						<i class="fa-solid fa-angle-right"></i>
						</button>
						
				</c:when>
				<c:otherwise>
					<button id="page-button" disabled="disabled">
					<i class="fa-solid fa-angle-right"></i>
					</button>
				</c:otherwise>
			</c:choose>
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