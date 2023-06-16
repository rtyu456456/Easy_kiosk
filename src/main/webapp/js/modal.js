const modal = document.getElementById("myModal");
const modalImage = document.getElementById("modalImage");
const closeBtn = document.getElementById("close-btn");
const totalPriceEl = document.getElementById("total-price");
let totalCnt = document.getElementById("total-count");
const ccName = document.getElementById("cname");
const ccPrice = document.getElementById("cprice");
const ccCnt = document.getElementById("ccnt");
const ccIce = document.getElementById("cice");

 function openModal(imageSrc, name, price, ice) {
	console.log(imageSrc);
	console.log(name);
	console.log(price); // 3000원
	console.log(ice);
	
	if (ice == 2) {
		var modalIce = modal.querySelector(".modal-ice");
		var modalHot = modal.querySelector(".modal-hot");
		modalIce.style.display = "inline-block";
		modalHot.style.display = "inline-block";
//		console.log(modalIce);
//		console.log(modalHot);
//		ice = 'ice' + ' and ' + 'hot'
		console.log(ice);
	} else if (ice == 1) {
		var modalHot = modal.querySelector(".modal-hot");
		var modalIce = modal.querySelector(".modal-ice");
		modalHot.style.display = "none";
		modalIce.style.display = "inline-block";
//		ice = 'ice'
		console.log(ice);
	} else if (ice == 0) {
		var modalIce = modal.querySelector(".modal-ice");
		var modalHot = modal.querySelector(".modal-hot");
		modalIce.style.display = "none";
		modalHot.style.display = "inline-block";
//		ice = 'hot' 
		console.log(ice);
	}
	
	let totalPrice = price;
	let tCnt = 1;
	totalCnt.innerText = '총 수량 : ' + tCnt; 
	
	var plusbtn = modal.querySelector("#plus-btn");
	console.log(plusbtn);
	plusbtn.addEventListener("click", () => {
		totalPrice += price;
		console.log(totalPriceEl);
		totalPriceEl.innerText = totalPrice;
		console.log(totalPrice);
		tCnt ++;
		totalCnt.innerText = '총 수량 : ' + tCnt; 
	});

	var minusbtn = modal.querySelector("#minus-btn");
	console.log(minusbtn);
	minusbtn.addEventListener("click", () => {
		if (totalPrice > price) {
			totalPrice -= price;
		}
		console.log(totalPriceEl);
		totalPriceEl.innerText = totalPrice;
		console.log(totalPrice);
		if (tCnt > 1) {
		tCnt --;
		totalCnt.innerText = '총 수량 : ' + tCnt; 
		}
	});
	
	class Cart {
		constructor(){
			this.name = name;
			this.price = totalPrice;
			this.cnt = tCnt;
			this.iceOrHot = ice;
		}
	}
	
	const addCart = modal.querySelector("#cart-btn");
	console.log(addCart);
	addCart.addEventListener("click", () => {
		
		const cart = new Cart();
		ccName.value = cart.name;		
		ccPrice.value = cart.price;		
		ccCnt.value = cart.cnt;		
		ccIce.value = cart.iceOrHot;
		
		console.log(ccName.value);
		console.log(ccPrice.value);
		console.log(ccCnt.value);
		console.log(ccIce.value);
		
	})
	
	var modalName = modal.querySelector(".modal-name");
	modalName.innerText = name;
	var modalPrice = modal.querySelector("#total-price");
	modalPrice.innerText = price;
	modalImage.src = imageSrc;
	modal.showModal();
}

closeBtn.addEventListener("click", closeModal);

function closeModal() {
	modal.close();
}