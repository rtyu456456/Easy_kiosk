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
	 
		<div class="contents">
			<c:forEach var="menus" items="${menus }">
				<button class="content-box"
					onclick="modalPage('img/${menus.m_img}', '${menus.m_name }', ${menus.m_price }, '${menus.m_ice }')">
					<div>
						<img src="img/${menus.m_img }"> 
					</div>
					<div>${menus.m_name}</div>
					<div>${menus.m_price }원</div>
				</button>
			</c:forEach>
		</div>


		<dialog id="modal"> 
		<div class="con">
		<img id="modal-img" src="#"/>
	 	<div class="modal-name">상품명</div>
	 	<div>설명 </div>
	 	<div>사이즈</div>
	 	<div class="useIce">
	 	<button id="hot">HOT</button>
	 	&nbsp;
	 	<button id="ice">ICE</button>
	 	</div>
	 	<div class="count">
		<button id="minus-price">-</button>
	 	<div id="count"> 수량 ? </div>
		<button id="plus-price">+</button>
		</div>
	 	<div><span class="modal-price"></span>원</div>
	 	
	 	
		<button class="modal-button"  id="close-modal">주문 취소</button>
		
	 	<form action="BasketController">
	 	<input hidden id="pocketName" name="pocketName">
	 	<input type="hidden" id="pocketIce" name="pocketIce">
	 	<input type="hidden" id="pocketCount" name="pocketCount">
	 	<input type="hidden" id="pocketPrice" name="pocketPrice">
		<button class="modal-button" id="in-my-pocket">장바구니 담기</button>
	 	</form>
		</div>
		</dialog>

	



</body>

</html>