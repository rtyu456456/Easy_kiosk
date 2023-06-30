<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://kit.fontawesome.com/8990da9a35.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/GeneralMenu.css" />
	<title>일반메뉴 네비게이션</title>
	<script type="text/javascript">
		function callEmployee() {
			alert('직원을 호출하였습니다 고객님 잠시만 기다려주세요');
		}
	</script>
</head>
<body>
	<nav class="nav">
        <div class="nav__top">
          <button id="home" onclick="location.href='HC'; removePage();"><i class="fa-solid fa-house"></i></button> 
          <span>처음으로</span>
        </div>
        
        <ul class="nav__menu">
          <li>
            <button onclick="location.href='GeneralCoffeeCon'; savePage('GeneralCoffeeCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralCoffeeCon">
              커피
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralBeverageCon'; savePage('GeneralBeverageCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralBeverageCon">
              음료
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralBlendingTeaCon'; savePage('GeneralBlendingTeaCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralBlendingTeaCon">
              블렌딩 티
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralFlatccinoCon'; savePage('GeneralFlatccinoCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralFlatccinoCon">
              플랫치노
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralShakeAdeCon'; savePage('GeneralShakeAdeCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralShakeAdeCon">
              쉐이크&<br />에이드
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralIceFlakeCon'; savePage('GeneralIceFlakeCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralIceFlakeCon">
              빙수
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralBreadCon'; savePage('GeneralBreadCon');" class="nav__menu__btns" data-page="Easy_kiosk/GeneralBreadCon">
              빵
            </button>
          </li>
        </ul>
        
        <div class="nav__footer">
          <div class="toMainCon">
            <button id="bell" onclick="callEmployee()"><i class="fa-solid fa-bell"></i></button>
            <form action="MainC" method="post" class="toMainC" onsubmit="removePage();">
              <button id="arrow"><i class="fa-solid fa-arrow-right" ></i></button>
            </form>
          </div>
          <div class="nav__footer__notice">
          	<span>직원호출</span>
          	<span>이전으로</span>
          </div>
        </div>
        
      </nav>
</body>
</html>