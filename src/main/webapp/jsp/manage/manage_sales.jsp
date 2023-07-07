<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	
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
<body >
	<div class="container mt-5 ml-5">
		<c:forEach items="${sales }" var="s" >
			<input hidden class="data1" value="${s.s_date }">
			<input hidden class="data2" value="${s.s_price }">
		</c:forEach>
		<div class="row">
			<div class="col-md-14">
				<canvas id="myChartOne"></canvas>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	let myChartOne = document.getElementById('myChartOne').getContext('2d');
	let datas1 = document.querySelectorAll('.data1');
	let datas2 = document.querySelectorAll('.data2');
	
	console.log(datas1[1].value);
	let datas1arr = Array.from(datas1).map((data) => data.value);
	let datas2arr = Array.from(datas2).map((data) => data.value);
	
	
	let barChart = new Chart(myChartOne, {
		type : 'line',
		data : {
			labels : datas1arr,
			datasets : [ {
				label : '일별 매출액',
				data : datas2arr
			} ]
		}

	});
</script>
</html>