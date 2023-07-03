<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.3.0/dist/chart.umd.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/reset.css">
</head>
<body>
	<div class="container">
		<div class="manage-menu-type">
			<div class="manage-item">
				<a href="ManageSalesC?period=day"> 일별 </a>
			</div>
			<div class="manage-item">
				<a href="ManageSalesC?period=week"> 주별 </a>
			</div>
			<div class="manage-item">
				<a href="ManageSalesC?period=month"> 월별 </a>
			</div>
			<div class="manage-item">
				<a href="ManageSalesC?period=select"> 특정일자 </a>
			</div>
		</div>
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
		type : 'bar',
		data : {
			labels : [ '학원', '연구원', '출판사', '미디어사', '위니브' ],
			datasets : [ {
				label : '일별 매출액',
				data : [ 10, 100, 100, 200, 500 ]
			} ]
		}

	});
</script>
</html>