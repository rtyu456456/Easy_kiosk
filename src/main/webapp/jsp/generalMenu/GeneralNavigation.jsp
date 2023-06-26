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
		function toHome() {
			alert('처음으로가는버튼 클릭됨');
		}
		function callEmployee() {
			alert('직원을 호출하였습니다 고객님 잠시만 기다려주세요');
		}
		function toBefore() {
			alert('이전으로가는버튼 클릭됨');
		}
	</script>
</head>
<body>
	<nav class="nav">
        <div class="nav__top">
          <button id="home" onclick="toHome()"><i class="fa-solid fa-house"></i></button> 
          <span>처음으로</span>
        </div>
        
        <ul class="nav__menu">
          <li>
            <button onclick="location.href='GeneralCoffeeCon'" class="nav__menu__btns">
              커피
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralBeverageCon'" class="nav__menu__btns">
              음료
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralBlendingTeaCon'" class="nav__menu__btns">
              블렌딩 티
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralFlatccinoCon'" class="nav__menu__btns">
              플랫치노
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralShakeAdeCon'" class="nav__menu__btns">
              쉐이크&<br />에이드
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralIceFlakeCon'" class="nav__menu__btns">
              빙수
            </button>
          </li>
          <li>
            <button onclick="location.href='GeneralBreadCon'" class="nav__menu__btns">
              빵
            </button>
          </li>
        </ul>
        
        <div class="nav__footer">
          <button id="bell" onclick="callEmployee()"><i class="fa-solid fa-bell"></i></button>
          <button id="arrow" onclick="toBefore()"><i class="fa-solid fa-arrow-right"></i></button>
          <div class="nav__footer__notice">
          	<span>직원호출</span>
          	<span>이전으로</span>
          </div>
        </div>
        
      </nav>
</body>
</html>