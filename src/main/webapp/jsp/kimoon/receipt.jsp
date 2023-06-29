<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영수증</title>
<link rel="stylesheet" href="css/receipt.css">
</head>
<body>
<div class="receipt-border">

<table class="receipt-container">

	<tr><td colspan="5" class="receipt-title">[판매영수증]</td></tr>
	
	<tr><td colspan="5" class="receipt-whereToEat">
	<c:if test="${sessionScope.whereToEat eq 'eatin'}">
		(매장)
	</c:if>
	<c:if test="${sessionScope.whereToEat eq 'takeout'}">
		(포장 주문)
	</c:if>
	</td></tr>
	
	<tr><td colspan="5" class="receipt-orderNum-text">주문번호</td></tr>
	
	<tr><td colspan="5" class="receipt-orderNum">${sessionScope.orderNum }</td></tr>
	
	<tr><td colspan="5">EASY COFFEE 종각점</td></tr>
	<tr><td colspan="5">서울특별시 종로구 종로12길</td></tr>
	<tr><td colspan="5">TEL 1544-0714</td></tr>
	
	<tr><td colspan="5" class="receipt-date">
		<c:set var="now" value="<%=new java.util.Date()%>" />
		거래일시 : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm:ss" />
	</td></tr>
	
	<tr>
		<td class="receipt-border-bottom receipt-category">상품명</td>
		<td class="receipt-border-bottom receipt-category">옵션</td>
		<td class="receipt-border-bottom receipt-category">단가</td>
		<td class="receipt-border-bottom receipt-category">수량</td>
		<td class="receipt-border-bottom receipt-category">금액</td>
	</tr>
	
	<c:forEach items="${sessionScope.menus}" var="menus">
	<tr>
		<td class="receipt-menus-name receipt-border-bottom">${menus.name}</td><!-- 상품명 -->
    	<td class="receipt-border-bottom"><!-- 옵션 -->
    		<c:if test="${menus.optionSize != null && menus.optionSize eq 'medium'}">
    		일반 사이즈<br>
    		</c:if>
    		<c:if test="${menus.optionSize != null && menus.optionSize eq 'large'}">
    		큰 사이즈<br>
    		</c:if>
    		<c:if test="${menus.iceOrHot != null && menus.iceOrHot eq 'ice'}">
    		얼음<br>
    		</c:if>
    		<c:if test="${menus.iceOrHot != null && menus.iceOrHot eq 'hot'}">
    		뜨겁게<br>
    		</c:if>
    		<c:if test="${menus.shot != null && menus.shot eq 'yes'}">
    		샷 추가<br>
    		</c:if>
    		<c:if test="${menus.syrup != null && menus.syrup eq 'yes'}">
    		시럽 추가<br>
    		</c:if>
    		<c:if test="${menus.cream != null && menus.cream eq 'yes'}">
    		크림 추가<br>
    		</c:if>
    		</td>  
		<td class="receipt-menus-unitPrice receipt-border-bottom" style="text-align: right;"><!-- 단가 -->
			<fmt:formatNumber value="${menus.unitPrice}" pattern="#,###" />원
		</td>
		<td class="receipt-menus-cnt receipt-border-bottom" style="text-align: right;"><!-- 수량 -->
			${menus.cnt }개
		</td>
		<td class="receipt-menus-unitTotalPrice receipt-border-bottom" style="text-align: right;"><!-- 금액 -->
			<fmt:formatNumber value="${menus.unitPrice * menus.cnt}" pattern="#,###" />원
		</td>
	</tr>
    </c:forEach>
	
	
	
	<tr>
		<td colspan="4" class="receipt-finalPrice">결제금액</td>
		<td  class="receipt-finalPrice" style="text-align: right;">
		<fmt:formatNumber value="${sessionScope.user.finalPrice }" pattern="#,###" />원
		</td>
	</tr>
	
	<c:if test="${sessionScope.howPoint eq 'usePoint'}"> <!-- 포인트 사용시 -->
		<tr><td colspan="5">구매하신 금액 : ${sessionScope.user.totalPrice }</td></tr>
		<tr><td colspan="5">할인받은 금액 : ${sessionScope.user.usedPoint }</td></tr>
		<tr><td colspan="5">남은 포인트 : ${sessionScope.user.remainPoint }</td></tr>
	</c:if>
	
	<tr>
    	<td colspan="4">결제 종류 : 
    		<c:if test="${sessionScope.howPayment  eq 'card'}">
    		카드
    		</c:if>
    		<c:if test="${sessionScope.howPayment  eq 'cash'}">
    		현금
   	 	</c:if>
    	</td>
    </tr>
	
	<c:if test="${sessionScope.howPoint eq 'savePoint'}"> <!-- 포인트 적립시 -->
	<tr>
		<td colspan="4">현재 포인트 : ${sessionScope.user.remainPoint }</td>
	</tr>
	</c:if>
	
	<tr><td colspan="5"><button onclick="location.href='HC'" id="resetLocalStorage" class="receipt-button">처음으로</button></td></tr>
</table>

</div>
</body>
</html>