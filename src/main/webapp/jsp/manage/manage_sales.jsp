<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.0/dist/chart.umd.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<canvas id="myChartOne"></canvas>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
 let myChartOne = document.getElementById('myChartOne').getContext('2d');
 
 let barChart = new Chart(myChartOne, {
	 type : 'pie',
 	 data : {
 		 labels : ['학원', '연구원', '출판사', '미디어사', '위니브'],
 		 datasets : [{
 			label : '일별 매출액',
 			data : [
 				10,
 				100,
 				100,
 				200,
 				500
 			]
 		 }]
 	 } 
	 
 });


</script>

</html>