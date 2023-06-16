<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Easy_kiosk</title>
<link rel="stylesheet" type="text/css" href="css/Main_M.css">
</head>
<body>
	<div class="container">
	
		<aside class="left--aside">
			<div class="left--aside__logo">
				<img alt="logo" src="imgs/EDIYA-COFFEE.png" />
			</div>
		
			<nav class="left--aside__nav">
				<ul>
					<li> <button onclick="location.href='HC'">커피</button> </li>
					<li> <button onclick="location.href='TC'">차</button> </li>
					<li> <button onclick="location.href='BC'">음료</button> </li>
					<li> <button onclick="location.href='DC'">디저트</button> </li>
					<li> <button onclick="location.href='SC'">쉐이크 &<br> 에이드</button> </li>
				</ul>
			</nav>
			
			<section class="left--aside__footer">
				<div> <button>직원호출</button> </div>
				<div> <button>이전으로</button> </div>
				<div> <button>처음으로</button> </div>
			</section>
			
		</aside>
		
		<main class="main">
			<section class="main__menu">
				<jsp:include page="${contentPage }"></jsp:include>
			</section>
			
			<div class="main__footer">
				<ul class="main_footer_arrow">
					<li> <button>이전</button> </li>
					<li> <button>현재 페이지 표시</button> </li>
					<li> <button>다음</button> </li>
				</ul>
			</div>
		
		</main>
		
		<aside class="right--aside">
			<div class="right--aside__cart">
			
				<div class="cart__item">
					<div class="s1">선택메뉴1</div>
					<div class="s1">선택메뉴2</div>
					<div class="s1">선택메뉴3</div>
					<br>
					<br>
					<br>
					<div class="s1">총 금액 : xxxx원</div>
				</div>	
			</div>
			
			<div class="cart--paybtn"> <button>결제하기</button> </div>
			
		</aside>
			 
	</div>
	
	
	
</body>
</html>