<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://kit.fontawesome.com/8990da9a35.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/GeneralMenu.css" />
    <link rel="stylesheet" type="text/css" href="css/GeneralMenuItem.css" />
    <script type="text/javascript" src="js/MenuItemModal.js" defer></script>
    <title>일반메뉴 페이지</title>
  </head>
  <body>
  <iframe src="./mp3/silence.mp3" allow="autoplay" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/03_메뉴를_선택해주세요.mp3">
	</audio>
    <div class="container">
      <jsp:include page="${navigation }"></jsp:include>  <!-- nav -->
      <div id="left-arrow">   <!-- 메뉴 왼쪽으로 넘기기 -->
				<c:choose>
					<c:when test="${curPageNo > 1 }">
						<button id="pageBtn1"
							onclick="location.href='GeneralPageCon?p=${curPageNo - 1 }'">
							<i id="left-arrow" class="fa-solid fa-chevron-up"></i>
						</button>
					</c:when>
					<c:otherwise>
						<button id="pageBtn1" disabled="disabled">
							<i id="left-arrow" class="fa-solid fa-chevron-up"></i>
						</button>
					</c:otherwise>
				</c:choose>
	  </div>
      <jsp:include page="${contentPage }"></jsp:include>
      <div id="right-arrow">  <!-- 메뉴 오른쪽으로 넘기기 -->
			<c:choose>
				<c:when test="${curPageNo < pageCount }">

					<button id="pageBtn2"
						onclick="location.href='GeneralPageCon?p=${curPageNo + 1 }'">
						<i id="right-arrow" class="fa-solid fa-chevron-up"></i>
					</button>

				</c:when>
				<c:otherwise>
					<button id="pageBtn2" disabled="disabled">
						<i id="right-arrow" class="fa-solid fa-chevron-up"></i>
					</button>
				</c:otherwise>
			</c:choose>
	  </div>
      <aside class="aside">
      	<div class="cartConParent">
      		<div class="aside__grid-container" id="cartContainer">
      		</div>
      	</div>
      	<span id="line"></span>
      	<p class="aside__payText">총 결제 금액</p>
      	<p class="aside__payPrice" id="total-cart-price"></p>
      	<form action="EarnPointC" method="get" id="testForm">
      	<input type="hidden" name="items">
      	<button onclick="getCartItems" class="aside__payBtn" type="button"><i class="fa-sharp fa-solid fa-credit-card"></i> 결제하기</button>
		</form>
      </aside>
    </div>
  </body>
</html>
