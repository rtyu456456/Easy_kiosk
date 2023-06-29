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
			<button class="grid-content-box" value="${menus.m_soldout }"
				onclick="modalPage('${menus.m_img}', '${menus.m_name }', ${menus.m_price }, '${menus.m_ice }', '${menus.m_size }')">
				<img src="${menus.m_img }">
				<div id="content-box-name">${menus.m_name}</div>
				<div id="content-box-price">${menus.m_price }원</div>
			</button>
		</c:forEach>
	</div>

	<dialog id="modal">
	<div class="con">
		<div id="modal-header">
			<img id="modal-img" src="#" />
			<div>
				<div class="modal-name">상품명</div>
				<div id="modal-price">
					<span class="modal-price"></span>원
				</div>
				<div class="count">
					<button id="minus-button">-</button>
					<div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div id="count">수량 ?</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<button id="plus-button">+</button>
				</div>
			</div>
		</div>
		<div id="size">
			<div id="w-size">사이즈 :</div>
			<button id="m-size">중</button>
			<button id="l-size">대</button>
		</div>
		<div class="useIce">
			<button id="hot">뜨겁게</button>
			&nbsp;
			<button id="ice">얼음</button>
		</div>
		<div id="modal-footer">
			<button id="modal-button" class="close-modal">취소</button>
			<input type="hidden" id="pocketImg" name="pocketImg"> 
			<input type="hidden" id="pocketName" name="pocketName"> 
			<input type="hidden" id="pocketIce" name="pocketIce"> 
			<input type="hidden" id="pocketCount" name="pocketCount"> 
			<input type="hidden" id="pocketPrice" name="pocketPrice"> 
			<input type="hidden" id="pocketSize" name="pocketSize">
			<button class="modal-button" id="in-my-pocket" onclick="addToCart()">
			선택 완료
			</button>
		</div>
	</dialog>





</body>

</html>