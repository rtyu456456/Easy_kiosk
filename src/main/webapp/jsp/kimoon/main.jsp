<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body class="main-view">

	<iframe src="./mp3/silence.mp3" id="audio" style="display:none"></iframe>
	<audio id="audio" autoplay>
		<source src="./mp3/01_Easy_Coffee에_오신_것을_환영합니다.mp3">
	</audio>
	
	<form action="MainC" method="post">
			<button type="submit" name="whereToEat" value="eatin" class="top-blue"><span class="eatin">매장 주문 ></span></button><br>
			<img src="./img/Logo.png" class="logo">
			<button type="submit" name="whereToEat" value="takeout" class="under-white"><span class="takeout">포장 주문 ></span></button>
			<img src="./img/Title_Enter_Blue.png" class="title">
	</form>
	<audio id="audio1" src="../mp3/01_Easy_Coffee에_오신_것을_환영합니다.mp3"></audio>
	<script>
		document.getElementById('audio1').play();
	</script>
</body>
</html>