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
	<div class="manage-menu-container">
		<div class="manage-item">분류</div>
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
			<a href="ManageMenuC?type=SEASON"> 시즌 </a>
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

	<div class="manage-menu-container">
		<div class="manage-item">상품명</div>
		<div class="manage-item">가격</div>
		<div class="manage-item">이미지</div>
		<div class="manage-item">온도옵션</div>
		<div class="manage-item">일반메뉴분류</div>
		<div class="manage-item">간단메뉴분류</div>
		<div class="manage-item">날씨별 추천분류</div>
		<div class="manage-item">재고현황</div>
	</div>
	<c:forEach items="${menus }" var="m">
		<div class="manage-menu-container">
			<div class="manage-item">${m.m_name }</div>
			<div class="manage-item">${m.m_price }</div>
			<div class="manage-item">${m.m_img }</div>
			<div class="manage-item">${m.m_ice }</div>
			<div class="manage-item">${m.m_type }</div>
			<div class="manage-item">${m.m_type_easy }</div>
			<div class="manage-item">${m.m_weather }</div>
			<div class="manage-item">${m.m_stock }</div>
			<div>
				<button onclick="location.href='UpdateMenuC?m_no=${m.m_no }'">수정</button>
			</div>
			<div>
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

</body>
</html>