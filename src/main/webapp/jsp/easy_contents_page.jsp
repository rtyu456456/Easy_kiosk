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
	<div> 
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
	 	<button id="ice">ICE</button>
	 	</div>
	 	<div class="count">
		<button id="minus-price">-</button>
	 	<div id="count"> 수량 ? </div>
		<button id="plus-price">+</button>
		</div>
	 	<div><span class="modal-price"></span>원</div>
		<button id="close-modal">주문 취소</button>
		<button>장바구니 담기</button>
		</div>
		</dialog>


		<div class="contents-under">
			<c:choose>
				<c:when test="${curPageNo > 1 }">
					<button
						onclick="location.href='EasyPageController?p=${curPageNo - 1 }'">이전</button>
				</c:when>
				<c:otherwise>
					<button disabled="disabled">이전</button>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${curPageNo < pageCount }">
					<button
						onclick="location.href='EasyPageController?p=${curPageNo + 1 }'">다음</button>
				</c:when>
				<c:otherwise>
					<button disabled="disabled">다음</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>



</body>

</html>