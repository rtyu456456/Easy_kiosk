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
			<a href="ManageMenuC?type=FLATCCINO"> 플랫치노 </a>
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
					<button
						onclick="openUpdate('${m.m_no}','${m.m_name}','${m.m_price}','${m.m_img}','${m.m_ice}','${m.m_size}','${m.m_type}','${m.m_type_easy}','${m.m_option}','${m.m_desc}','${m.m_weather}','${m.m_soldout}','${m.m_order}')">수정</button>
					<button onclick="delMenu('${m.m_no}')">삭제</button>
				</div>
			</div>
		</c:forEach>
		<dialog id="updateModal">
		<form action="UpdateMenuC" method="post" enctype="multipart/form-data">
			<div>
				<input hidden name="m_no"> 메뉴명 : <input name="m_name"
					placeholder="메뉴명">
			</div>
			<div>
				가격 : <input name="m_price" placeholder="가격">
			</div>
			<div>
				메뉴사진 : <input name="m_img" type="file"> <input hidden
					name="m_old_img">
			</div>
			<div>
				아이스핫 구분 : <select name="m_ice">
					<option value=0>Hot만</option>
					<option value=1>Ice만</option>
					<option value=2>둘다</option>
					<option value=3>구분없음</option>
				</select>
			</div>
			<div>
				사이즈 구분 : <select name="m_size">
					<option value=0>구분없음</option>
					<option value=1>구분있음</option>
				</select>
			</div>
			<div>
				일반분류 : <select name="m_type">
					<option value="COFFEE">커피</option>
					<option value="BLENDING_TEA">블렌딩 티</option>
					<option value="BEVERAGE">베버리지</option>
					<option value="FLATCCINO">플랫치노</option>
					<option value="SHAKE_ADE">셰이크&에이드</option>
					<option value="ICE_FLAKE">빙수</option>
					<option value="BREAD">빵</option>
					<option value="DESSERT">디저트</option>
				</select>
			</div>
			<div>
				간단분류 : <select name="m_type_easy">
					<option value="COFFEE">커피</option>
					<option value="BEVERAGE">음료</option>
					<option value="TEA">차</option>
					<option value="DESSERT">디저트</option>
					<option value="NONE">지정안함</option>
				</select>
			</div>
			<div>
				옵션여부 : <input type="checkbox" name="m_option" value="SYRUP">
				시럽 <input type="checkbox" name="m_option" value="SHOT"> 샷 <input
					type="checkbox" name="m_option" value="CREAM"> 크림
			</div>
			<div>
				메뉴설명 :
				<textarea name="m_desc" style="resize: none;"></textarea>
			</div>
			<div>
				날씨별 추천여부 : <select name="m_weather">
					<option value="0">맑음</option>
					<option value="1">비</option>
					<option value="2">눈</option>
					<option value="3">지정안함</option>
				</select>
			</div>
			<div>
				재고여부 : <select name="m_soldout">
					<option value="0">매진</option>
					<option value="1">재고있음</option>
				</select>
			</div>
			<div>
				총주문수 : <input name="m_order" placeholder="총주문수">
			</div>

			<button id="confirmUpdate">수정</button>
		</form>
		<button id="closeUpdate">닫기</button>
		</dialog>
		<div>
			<button id="openAdd">메뉴추가</button>
			<input hidden value=${param.type } name="type">
			<dialog id="addModal">
			<form action="AddMenuC" method="post" enctype="multipart/form-data">
				<div>
					메뉴명 : <input name="m_name" placeholder="메뉴명">
				</div>
				<div>
					가격 : <input name="m_price" placeholder="가격">
				</div>
				<div>
					메뉴사진 : <input name="m_img" type="file">
				</div>
				<div>
					아이스핫 구분 : <select name="m_ice">
						<option value=0>Hot만</option>
						<option value=1>Ice만</option>
						<option value=2>둘다</option>
						<option value=3>구분없음</option>
					</select>
				</div>
				<div>
					사이즈 구분 : <select name="m_size">
						<option value=0>구분없음</option>
						<option value=1>구분있음</option>
					</select>
				</div>
				<div>
					일반분류 : <select name="m_type">
						<option value="COFFEE">커피</option>
						<option value="BLENDING_TEA">블렌딩 티</option>
						<option value="BEVERAGE">베버리지</option>
						<option value="FLATCCINO">플랫치노</option>
						<option value="SHAKE_ADE">셰이크&에이드</option>
						<option value="ICE_FLAKE">빙수</option>
						<option value="BREAD">빵</option>
						<option value="DESSERT">디저트</option>
					</select>
				</div>
				<div>
					간단분류 : <select name="m_type_easy">
						<option value="COFFEE">커피</option>
						<option value="BEVERAGE">음료</option>
						<option value="TEA">차</option>
						<option value="DESSERT">디저트</option>
						<option value="NONE">지정안함</option>
					</select>
				</div>
				<div>
					옵션여부 : <input type="checkbox" name="m_option" value="SYRUP">
					시럽 <input type="checkbox" name="m_option" value="SHOT"> 샷 <input
						type="checkbox" name="m_option" value="CREAM"> 크림
				</div>
				<div>
					메뉴설명 :
					<textarea name="m_desc"></textarea>
				</div>
				<div>
					날씨별 추천여부 : <select name="m_weather">
						<option value="0">맑음</option>
						<option value="1">비</option>
						<option value="2">눈</option>
						<option value="3">지정안함</option>
					</select>
				</div>
				<div>
					재고여부 : <select name="m_soldout">
						<option value="0">매진</option>
						<option value="1">재고있음</option>
					</select>
				</div>
				<div>
					총주문수 : <input name="m_order" placeholder="총주문수">
				</div>

				<button id="confirmAdd">추가</button>
			</form>
			<button id="closeAdd">닫기</button>
			</dialog>
		</div>
		<div>
			<a href="MenuPageC?p=1"> [맨처음] </a>
			<c:if test="^"></c:if>
				<a href="MenuPageC?p= "> 이전 </a>
			<c:forEach begin="1" end="5" var="i">
				<a href="MenuPageC?p=${i }"> [${i }] </a>
			</c:forEach>
				<a href="MenuPageC?p=${i } "> 다음 </a>
			<a href="MenuPageC?p=${pageCount }"> [끝] </a>
		</div>
	</div>
</body>

</html>