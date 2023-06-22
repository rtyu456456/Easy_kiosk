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
	<div class="manage-menu-type">
		<div class="manage-item">
			<a href="ManageMenuC?type=COFFEE"> 커피 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=BEVERAGE"> 베버리지 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=BLENDING_TEA"> 블렌딩티 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=SHAKE_ADE"> 셰이크&에이드 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=ICE_FLAKE"> 빙수 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=FLATCHINO"> 플랫치노 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=BREAD"> 빵 </a>
		</div>
		<div class="manage-item">
			<a href="ManageMenuC?type=DESSERT"> 디저트 </a>
		</div>
	</div>

	<div class="manage-menu-desc">
		<div class="manage-item">이미지</div>
		<div class="manage-item">상품명</div>
		<div class="manage-item">가격</div>
		<div class="manage-item">일반메뉴분류</div>
		<div class="manage-item">재고유무</div>
		<div class="manage-item">총 판매량</div>
	</div>
	
	<div class="manage-menu-wrapper">
		<c:forEach items="${menus }" var="m">
			<div class="manage-menu-main">
				<div class="manage-item">
					<img src="${m.m_img }">
				</div>
				<div class="manage-item">${m.m_name }</div>
				<div class="manage-item">${m.m_price }</div>
				<div class="manage-item">${m.m_type }</div>
				<div class="manage-item">${m.m_soldout }</div>
				<div class="manage-item">${m.m_order }</div>
				<div>
					<button id="update">수정</button>
					<dialog id="updatePage">${m.m_no }</dialog>
					<button onclick="location.href='DeleteMenuC?m_no=${m.m_no }'">삭제</button>
				</div>
			</div>
		</c:forEach>
		<form action="AddMenuC">
			<div>
				<button>메뉴추가</button>
				<input hidden value=${param.type } name="type">
			</div>
		</form>
	</div>
</body>
<script>
const u_button = document.getElementById("update");
const u_page = document.getElementById("updatePage");

u_button.addEventListener("click", function() {
	u_page.showModal();
});
</script>
</html>