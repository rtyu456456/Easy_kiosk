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
    <link rel="stylesheet" type="text/css" href="css/generalMenu/GeneralMenu.css" />
    <link rel="stylesheet" type="text/css" href="css/generalMenu/GeneralMenuItem.css" />
	<title>일반메뉴 메뉴아이템</title>
</head>
<body>
	<main class="main">
	  <div class="grid-container">
	  	<c:forEach items="${M}" var="m">
	  	<div class="grid-item" data-value="${m.soldout}" onclick="openModal('${m.img}', '${m.name }', ${m.price }, '${m.ice }', '${m.desc }', '${m.option }', '${m.size }')">
	  	<c:if test="${m.soldout == 0 }">
	  	<img alt="soldOutImg" src="img/soldOutPng.png" style="margin-top: 26px;">
	  	</c:if>
	  	<c:if test="${m.soldout == 1 }">
	  	<img src="${m.img }" style="position: relative; top: 15px;"/>
	  	</c:if>
	    <h3 style="margin-bottom: 6px; font-weight: 800;">${m.name}</h3>
	    <p style="margin-top: 6px; font-weight: 800; font-size: 24px; color: #BD433B;">${m.price}원</p>
	    </div>
	  	</c:forEach>
	  </div>
	  
	  <dialog id="optionModal" class="modal">
		 <div class="optionIntroduce1">
		  	<div class="optionImg">
	      		<img id="modalImage" src="#" alt="메뉴 이미지" />
		  	</div>
		  	<div class="optionNamePrice">
	      		<h2 class="modal-name"></h2>
		        <span id="total-price"></span>
		  	</div>
		 </div>
		 
		 <div class="optionCnt">
		     	 <button id="minus-btn">수량 -</button>
		       	 <button id="total-count"></button> <br> <br>
		      	 <button id="plus-btn">수량 +</button>
		 </div>
		 
		 <div class="optionDesc">
		 	<p class="m-desc"></p>
		 </div>
		 
		 <div class="optionBtn" style="margin-bottom: 12px">
		     	 <button id="modal-ice" class="yesBtn" value="ice" name="iceOrHot">Ice</button>
		      	 <button id="modal-hot" class="noBtn" value="hot" name="iceOrHot">Hot</button>
		 </div>
		 
		 <div class="optionBtn sizeContainer" style="margin-left: -78px">
		 		 <span>사이즈</span>
		     	 <button id="size-medium" class="yesBtn" value="medium" name="optionSize">
		     	 Medium</button>
		      	 <button id="size-large" class="noBtn" value="large" name="optionSize">
		      	 Large</button>
		 </div>
		 
		 <div class="optionBtn secondOption" style="margin-left: -78px">
		 		 <span>&ensp;&ensp;&ensp;&ensp;샷</span>
		     	 <button id="shot-yes" class="yesBtn" value="yes" name="shot">Yes</button>
		      	 <button id="shot-no" class="noBtn" value="no" name="shot">No</button>
		 </div>
		 
		 <div class="optionBtn secondOption" style="margin-left: -78px">
		 		 <span>&ensp;&ensp;시럽</span>
		     	 <button id="syrup-yes" class="yesBtn" value="yes" name="syrup">Yes</button>
		      	 <button id="syrup-no" class="noBtn" value="no" name="syrup">No</button>
		 </div>
		 
		 <div class="optionBtn secondOption" style="margin-left: -78px">
		 		 <span>&ensp;&ensp;크림</span>
		     	 <button id="cream-yes" class="yesBtn" value="yes" name="cream">Yes</button>
		      	 <button id="cream-no" class="noBtn" value="no" name="cream">No</button>
		 </div>
		 
	      <div class="orderContainer">
	      	   <input type="hidden" id="cartImageSrc" />
	           <input type="hidden" id="cartName" />
	      	   <input type="hidden" id="cartPrice" />
	      	   <input type="hidden" id="cartCnt" />
	      	   <input type="hidden" id="cartIceOrHOt" />
	      	   <button id="close-btn">주문 취소</button> <br> <br>
	      	   <button id="cart-btn">주문 담기</button>
	      </div>
	      
	  </dialog>
    </main>
</body>
    <script type="text/javascript" src="js/MenuItemModal.js" defer></script>
</html>