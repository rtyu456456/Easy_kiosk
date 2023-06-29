/**
 * 
 */

 function cancelOrder(s_no){
	let ok = confirm("주문을 취소하시겠습니까?");
	
	if(ok){
		location.href="CancelOrderC?s_no=" + s_no;
	}
	
}

