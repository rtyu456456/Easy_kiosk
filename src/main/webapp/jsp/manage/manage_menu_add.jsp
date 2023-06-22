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
		<div class="manage-item">이미지</div>
		<div class="manage-item">상품명</div>
		<div class="manage-item">가격</div>
		<div class="manage-item">온도옵션</div>
		<div class="manage-item">사이즈 구분</div>
		<div class="manage-item">일반메뉴분류</div>
		<div class="manage-item">간단메뉴분류</div>
		<div class="mange-item">옵션 추가여부</div>
		<div class="mange-item">상품 설명</div>
		<div class="manage-item">날씨별 추천분류</div>
		<div class="manage-item">매진여부</div>
		<div class="manage-item">총 주문수</div>
	</div>
	<form action="AddMenuC" method="post" enctype="multipart/form-data">
		<div class="manage-menu-container">
			<div class="manage-item">
				<input placeholder="이미지" name="m_img" type="file">
			</div>
			<div class="manage-item">
				<input placeholder="상품명" name="m_name">
			</div>
			<div class="manage-item">
				<input placeholder="가격" name="m_price">
			</div>
			<div class="manage-item">
				<select name="m_ice">
					<option value="0">핫</option>
					<option value="1">아이스</option>
					<option value="2">둘다</option>
					<option value="3">해당없음</option>
				</select>
			</div>
			<div class="manage-item">
				<select name="m_size">
					<option value="0">구분 있음</option>
					<option value="1">구분 없음</option>
				</select>
			</div>
			<div class="manage-item">
				<select name="m_type">
					<option value="COFFEE">커피</option>
					<option value="BEVERAGE">베버리지</option>
					<option value="BLENDING_TEA">블렌딩티</option>
					<option value="SHAKE_ADE">셰이크&에이드</option>
					<option value="ICE_FLAKE">빙수</option>
					<option value="FLATCCINO">플랫치노</option>
					<option value="BREAD">빵</option>
					<option value="DESSERT">디저트</option>
				</select>
			</div>
			<div class="manage-item">
				<select name="m_type_easy">
					<option value="COFFEE">커피</option>
					<option value="BEVERAGE">음료</option>
					<option value="TEA">차</option>
					<option value="DESSERT">디저트</option>
					<option value="NONE">지정안함</option>
				</select>
			</div>
			<div class="manage-item">
				<label>
				 <input type="checkbox" name="m_option" value="시럽"> 시럽
				</label>
				<label>
				 <input type="checkbox" name="m_option" value="휘핑크림"> 휘핑크림
				</label>
				<label>
				 <input type="checkbox" name="m_option" value="샷"> 샷
				</label>
			</div>
			<div class="manage-item">
				<textarea rows="" cols="" name="m_desc"></textarea>
			</div>
			<div class="manage-item">
				<select name="m_weather">
					<option value="0">맑음</option>
					<option value="1">비</option>
					<option value="2">눈</option>
					<option value="3">지정안함</option>
				</select>
			</div>
			<div class="manage-item">
				<select name="m_soldout">
					<option value="0">매진</option>
					<option value="1">재고있음</option>
				</select>
			</div>
		</div>
		<div>
			<button>등록</button>
			<button type="button" onclick="location.href='ManageMenuC?type=${param.type }'">취소</button>
		</div>
	</form>
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

		</div>
	</c:forEach>


</body>
</html>