const callButton = document.getElementById("call-button");
const staffCall = document.getElementById("staff-call");
const closeButton = document.getElementById("close-button");

callButton.addEventListener("click", () => {
	const c = confirm("직원에게 도움을 요청하시겠습니까?");
	if (c == true) {
		staffCall.showModal();
	}
})

closeButton.addEventListener("click", () => {

	staffCall.close();

})


const homeBtn = document.getElementById("home");

homeBtn.onclick = () => {
	localStorage.removeItem("cartItems");
}


const grid_content_box = document.querySelector(".grid-content-box");
function getCartItems() {

	if (localStorage.getItem("cartItems") === 14) {
		alert("최대 수량은 15개까지입니다.");
		// 버튼 비활성화	
		grid_content_box.disabled = ture;

	} else {

		// 버튼 활성화	
		grid_content_box.disabled = false;
	}


	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	return cartItems;
}

const aside__payBtn = document.querySelector(".aside__payBtn");

aside__payBtn.onclick=()=>{
	if (localStorage.getItem("cartItems") === "[]") {
		alert("상품을 담아주세요");
		return false; 
	}else{
	const cartItems = getCartItems(); // 장바구니 아이템들의 정보를 가져오는 함수 호출
	let cartItems2 = JSON.stringify(cartItems);
	console.log(cartItems2);

	document.querySelector('input[name=items]').value = cartItems2;
	document.querySelector('#testForm').submit();
	}
	
}


const contentPage = document.querySelector(".grid-content-box");
console.log(contentPage.value);
if (contentPage.value === "0") {
	contentPage.classList.add("disabled");
	contentPage.disabled = true;
	contentPage.style.backgroundColor = 'gray';
	let soldoutImg = document.createElement("img");
	soldoutImg.src = "img/SoldOut.png";
	soldoutImg.style.position = "absolute";
	soldoutImg.style.top = "80px";
	soldoutImg.style.right = "45px";
	soldoutImg.style.width = "250px";
	soldoutImg.style.height = "250px";

	contentPage.appendChild(soldoutImg);
}








