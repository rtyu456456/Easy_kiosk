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
	 
		<div class="grid-contents">
			<c:forEach var="menus" items="${menus }">
				<button class="grid-content-box"
					onclick="modalPage('${menus.m_img}', '${menus.m_name }', ${menus.m_price }, '${menus.m_ice }')">
					<img src="${menus.m_img }"> 
					<div id="content-box-name">${menus.m_name}</div>
					<div id="content-box-price">${menus.m_price }원</div>
				</button>
			</c:forEach>
		</div>


		<dialog id="modal"> 
		<div class="con">
		<div id="modal-header">
		<img id="modal-img" src="#"/>
		<div>
	 	<div class="modal-name">상품명</div>
	 	<div id="modal-price" ><span class="modal-price"></span>원</div>
	 	<div class="count">
		<button id="minus-price">-</button>
	 	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	 	<div id="count"> 수량 ? </div>
	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<button id="plus-price">+</button>
		</div>
	 	</div>
	 	</div>
	 	
	 	<div class="useIce">
	 	<button id="hot">뜨겁게</button>
	 	&nbsp;
	 	<button id="ice">얼음</button>
	 	</div>
	 	<div id="modal-footer">
		<button id="modal-button"  class="close-modal">취소</button>
	 	<form action="BasketController">
	 	<input hidden id="pocketimg" name="pocketImg">
	 	<input hidden id="pocketName" name="pocketName">
	 	<input type="hidden" id="pocketIce" name="pocketIce">
	 	<input type="hidden" id="pocketCount" name="pocketCount">
	 	<input type="hidden" id="pocketPrice" name="pocketPrice">
		<button class="modal-button" id="in-my-pocket">선택 완료</button>
	 	</form>
		</div>
		</div>
		</dialog>

	



</body>

</html>