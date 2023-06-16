<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Easy_kiosk</title>
<link rel="stylesheet" type="text/css" href="css/Menuitem.css">
<script type="text/javascript" src="js/modal.js" defer></script>
<script src="https://unpkg.com/typeit@8.7.1/dist/index.umd.js"></script>
<script type="text/javascript" src="js/type.js" defer></script>
</head> 
<body>
	  <h2 class="typeit">어서오세요 <strong>Easy-kiosk</strong> 입니다</h2>
 	  <h1 class="title">Easy_kiosk 메뉴</h1>
  <div class="grid-container">
  	<c:forEach items="${M}" var="m">
  	<div class="grid-item" onclick="openModal('EDIYA_COFFEE/${m.img}', '${m.name }', ${m.price }, '${m.ice }')">
  	  <img alt="coffee" src="EDIYA_COFFEE/${m.img }" style="max-width: 80px; max-height: 120px" />
      <h3>${m.name}</h3>
      <p style="color: rgb(255, 128, 192); font-weight: 600; font-size: 20px;">
      	  ${m.price}원</p>
    </div>
  	</c:forEach>
  </div>
  
  <dialog id="myModal" class="modal">
      <img id="modalImage" src="#" alt="메뉴 이미지" />
      <h2 class="modal-name"></h2>
      <button class="modal-ice">Ice</button>
      <button class="modal-hot">Hot</button> <br> <br>
      <button class="size-btn">사이즈 : Small</button>
      <button class="size-btn">사이즈 : Medium</button>
      <button class="size-btn">사이즈 : Large</button>
      <p style="font-weight: 600;">Easy 카페의 시그니처 커피메뉴로서 <br>
     	 과테말라 아야르자 원두를 블렌딩하여 <br> 
     	 균형감 있는 풍미를 바디에 담고있습니다</p>
      <div>
     	 <button id="minus-btn">수량 -</button>
         <span class="modal-price"><span id="total-price"></span>원</span>
      	 <button id="plus-btn">수량 +</button>
       	 <button id="total-count"></button> <br> <br>
      	 <button id="close-btn">주문 취소</button> <br> <br>
<!--       	 <form action=""> -->
           <input type="hidden" id="cname" />
      	   <input type="hidden" id=" cprice" />
      	   <input type="hidden" id="ccnt" />
      	   <input type="hidden" id="cice" />
      	   <button id="cart-btn">주문 담기</button>
<!--       	 </form> -->
      </div>
  </dialog>
	
	
</body>
</html>