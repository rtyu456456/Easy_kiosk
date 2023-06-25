<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table id="cartTable2">
		<tr>
			<td class="box1"></td>
		</tr>
		<tr id="menu">
			<td colspan="2"></td>
		</tr>
	</table>
	<table id="cartTable">
		<tr>
			<td id="line"></td>
		</tr>
		<tr>
			<td id="mungu" style="text-align: right">총 결제 금액</td>
		</tr>
		<tr>
			<td id="totalPrice" style="text-align: right"></td>
		</tr>
		<tr id="paybox">
			<td style="vertical-align: middle;"><img alt=""
				src="css/shopping_list/img/cardIcon.png"></td>

			<td id="paybox_comment">
				<form action="PaymentMethodC" method="get">
					<button style="all: unset;">결제하기</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>