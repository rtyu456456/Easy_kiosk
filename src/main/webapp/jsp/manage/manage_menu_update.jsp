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
	<form action="UpdateMenuC" method="post" enctype="multipart/form-data">
		<div class="manage-menu-container">
			<div class="manage-item">
				<input value="${menu.m_name }" name="m_name">
			</div>
			<div class="manage-item">
				<input value="${menu.m_price }" name="m_price">
			</div>
			<div class="manage-item">
				<input placeholder="이미지" name="m_new_img" type="file">
				<input hidden name="m_old_img" value="${menu.m_img }">
			</div>
			<div class="manage-item">
				<input hidden id="m_ice" value="${menu.m_ice }">
				<select name="m_ice">
					<option value="0">핫</option>
					<option value="1">아이스</option>
					<option value="2">둘다</option>
					<option value="3">해당없음</option>
				</select>
			</div>
			<div class="manage-item">
				<input hidden id="m_type" value="${menu.m_type }">
				<select name="m_type">
					<option value="COFFEE">커피</option>
					<option value="BEVERAGE">베버리지</option>
					<option value="BLENDING_TEA">블렌딩티</option>
					<option value="SHAKE_ADE">셰이크&에이드</option>
					<option value="ICE_FLAKE">빙수</option>
					<option value="SEASON">시즌</option>
					<option value="FLATCHINO">플랫치노</option>
					<option value="BREAD">빵</option>
					<option value="DESSERT">디저트</option>
				</select>
			</div>
			<div class="manage-item">
				<input hidden id="m_type_easy" value="${menu.m_type_easy }">
				<select name="m_type_easy">
					<option value="COFFEE">커피</option>
					<option value="BEVERAGE">음료</option>
					<option value="TEA">차</option>
					<option value="DESSERT">디저트</option>
					<option value="NONE">지정안함</option>
				</select>
			</div>
			<div class="manage-item">
				<input hidden id="m_weather" value="${menu.m_weather }">
				<select name="m_weather">
					<option value="0">맑음</option>
					<option value="1">비</option>
					<option value="2">눈</option>
					<option value="3">지정안함</option>
				</select>
			</div>
			<div class="manage-item">
				<input placeholder="재고량" value="${menu.m_stock }" name="m_stock">
			</div>
		</div>
		<div>
			<button>수정</button>
			<input hidden name="m_no" value="${menu.m_no }" >
			<button type="button" onclick="location.href='ManageMenuC'">취소</button>
		</div>
	</form>


</body>
<script type="text/javascript">
// select_ice 찝기
let select_ice = document.querySelector('select[name="m_ice"]');
let iceVal = document.querySelector('#m_ice').value;
for(let i = 1; i < select_ice.options.length; i++){
	if(select_ice.options[i].value == iceVal){
		select_ice.options[i].selected = true;
	}
}

// select_type 찝기
let select_type = document.querySelector('select[name="m_type"]');
let typeVal = document.querySelector('#m_type').value;
for(let i = 1; i < select_type.options.length; i++){
	if(select_type.options[i].value == typeVal){
		select_type.options[i].selected = true;
	}
}

// select_type_easy 찝기
let select_type_easy = document.querySelector('select[name="m_type_easy"]');
let typeEasyVal = document.querySelector('#m_type_easy').value;
for(let i = 1; i < select_type_easy.options.length; i++){
	if(select_type_easy.options[i].value == typeEasyVal){
		select_type_easy.options[i].selected = true;
	}
}

// select_weather 찝기
let select_weather = document.querySelector('select[name="m_weather"]');
let weatherVal = document.querySelector('#m_weather').value;
for(let i = 1; i < select_weather.options.length; i++){
	if(select_weather.options[i].value == weatherVal){
		select_weather.options[i].selected = true;
	}
}


// 변수 지정에 귀찮게 querySelector로 일일히 집어주는 것 말고도 el문을 활용할 수 있지만
// 그 경우 js 파일을 별도로 분리할 수 없음.
// 또한 파일이 로드되기 전에 js가 돌아버리면 querySelector로 찾을 DOM객체가 없기 때문에
// script 혹은 js 파일은 가급적 로드가 된 후에 불러내도록하자

</script>
</html>