<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://kit.fontawesome.com/f0a74bdf41.js" crossorigin="anonymous"></script>
	<div class="nav">
		<c:if test="${sessionScope.whereToEat eq null}"> <!-- 첫 화면에서만 출력 -->
		<img src="./img/Logo.png" class="nav-logo">
		<img src="./img/Title_Enter_Blue.png" class="nav-title">
		</c:if>
		<c:if test="${sessionScope.whereToEat eq 'eatin' || sessionScope.whereToEat eq 'takeout'}"> <!-- 첫 화면 이후부터 처음으로 버튼 활성화 -->
		<i class="fa-solid fa-house" onclick="location.href='HC'" id="resetLocalStorage1"></i><br>
		<span class="home-text" onclick="location.href='HC'" id="resetLocalStorage2">처음으로</span>
		</c:if>
		<c:if test="${sessionScope.whereToEat eq 'eatin' || sessionScope.whereToEat eq 'takeout'}"> <!-- 첫 화면 이후부터 뒤로가기 버튼 활성화 -->
		<img onclick="history.back()" src="./img/backArrow.png" class="back-img"><br>
		<span onclick="history.back()" class="back-text">뒤로가기</span>
		</c:if>
		<button id="km-call-button">
		<i class="fa-solid fa-bell"></i><br>
		<span class="call-text">직원 호출</span>
		</button>
	</div>
	<dialog id="km-staff-call">
        <div id="km-staff-call-page">
            <h1>
                카운터에 호출 요청이 전송되었습니다.<br> 잠시만 기다려 주세요.
            </h1>
            <button id="km-close-button">확인</button>
        </div>
     </dialog>
<script type="text/javascript" src="js/km_staff_call.js"></script>