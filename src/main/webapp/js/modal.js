const modalid = document.getElementById("modal");
const closeModal = modal.querySelector(".close-modal");
const modalPrice = modal.querySelector(".modal-price");
const count = document.getElementById("count");

/*장바구니 items*/
const selectedImg = document.getElementById("pocketImg");
const selectedName = document.getElementById("pocketName");
const selectedIce = document.getElementById("pocketIce");
const selectedCount = document.getElementById("pocketCount");
const selectedPrice = document.getElementById("pocketPrice");
const selectedSize = document.getElementById("pocketSize");



let cart = {};

const iceButton = document.getElementById("ice");
const hotButton = document.getElementById("hot");

const pocket = document.getElementById("in-my-pocket");
let minusBtn = document.getElementById("minus-button");
let plusBtn = document.getElementById("plus-button");

let sizeM = document.getElementById("m-size");
let sizeL = document.getElementById("l-size");
let sizeW = document.getElementById("w-size");


/*cart라는 객체를 json을 통해 localStorage에 담고 다시 json을 통해 js로 옮기는 과정*/
function addCartItem(cart) {
	console.log(cart);

	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");
	console.log(cartItems);

	cartItems.push(cart);
	console.log(cartItems);
	console.log(JSON.stringify(cartItems));

	localStorage.setItem("cartItems", JSON.stringify(cartItems));
}


function displayCartItems() {

	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	let basketContainer = document.getElementById("basketContainer");

	basketContainer.innerHTML = "";

	let totalCartPrice = 0;
	cartItems.forEach((item, index) => {
		console.log('==============');
		console.log(item.img);
		
		
		totalCartPrice += item.price;
		
		let itemContainer = document.createElement("div");
		itemContainer.style.textAlign = "center";
		itemContainer.style.border = "1.6px solid #222";
		itemContainer.style.borderRadius = "6px";
		itemContainer.style.backgroundColor = "#eed";
		itemContainer.classList.add("itemContainer");

		let itemImg = document.createElement("img");
		itemImg.src = item.img;
		let itemBtn = document.createElement("div");
		itemBtn.style.display = "flex";
		itemBtn.style.justifyContent = "center";
		itemBtn.style.alignItems = "center";

		let minusBtn = document.createElement("button");
		minusBtn.innerText = "-";
		minusBtn.style.marginRight = "5px";
		minusBtn.style.padding = "2px 8px";
		minusBtn.style.fontSize = "18px";
		minusBtn.style.fontWeight = "600";
		minusBtn.style.color = "#011E61";
		minusBtn.style.backgroundColor = "white";
		minusBtn.onclick = () => {
			if (item.count > 1) {
				item.count--;
				updateCartItem(index, item);
			}
		};

		let itemBtnText = document.createElement("span");
		itemBtnText.innerText = item.count;

		let plusBtn = document.createElement("button");
		plusBtn.innerText = "+";
		plusBtn.style.marginRight = "5px";
		plusBtn.style.padding = "2px 8px";
		plusBtn.style.fontSize = "18px";
		plusBtn.style.fontWeight = "600";
		plusBtn.style.color = "#011E61";
		plusBtn.style.backgroundColor = "white";
		plusBtn.onclick = () => {
			item.count++;
			updateCartItem(index, item);
		};

		itemBtn.appendChild(minusBtn);
		itemBtn.appendChild(itemBtnText);
		itemBtn.appendChild(plusBtn);

		let deleteBtnContainer = document.createElement("div");
		deleteBtnContainer.style.textAlign = "end";
		deleteBtnContainer.style.marginTop = "-8.8px";
		deleteBtnContainer.style.marginRight = "-1.2px";
		deleteBtnContainer.style.marginBottom = "10px";

		let deleteBtn = document.createElement("button");
		deleteBtn.classList.add("deleteBtn");
		deleteBtn.innerText = "x";
		deleteBtn.style.fontSize = "18px";
		deleteBtn.style.fontWeight = "500";
		deleteBtn.style.color = "#011E61";
		deleteBtn.style.backgroundColor = "grey";
		deleteBtn.onclick = () => {
			deleteCartItem(index);
		};

		deleteBtnContainer.appendChild(deleteBtn);

		itemContainer.appendChild(deleteBtnContainer);
		itemContainer.appendChild(itemImg);
		itemContainer.appendChild(itemBtn);

		basketContainer.appendChild(itemContainer);
	});

	let basketTotalPrice = document.getElementById("basket-total-price");
	basketTotalPrice.innerText = "₩" + totalCartPrice + "원";

}

function updateCartItem(index, item) {
	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	item.price = item.unitPrice * item.count;

	cartItems[index] = item;

	localStorage.setItem("cartItems", JSON.stringify(cartItems));

	displayCartItems();
}

function deleteCartItem(index) {

	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	cartItems.splice(index, 1);

	localStorage.setItem("cartItems", JSON.stringify(cartItems));

	displayCartItems();
}


function modalPage(imgSrc, easyName, easyPrice, useice, size) {

	console.log(easyName);
	console.log(easyPrice);
	console.log(imgSrc);
	console.log(useice);
	console.log(size);

	modal.showModal();

	cart = { name: easyName, price: easyPrice, unitPrice: easyPrice, iceOrHot: useice, img: imgSrc, count: 1, size };

	modalPrice.innerText = cart.price;
	count.innerText = cart.count;
	let modalName = modal.querySelector(".modal-name");
	modalName.innerText = easyName;
	modalPrice.innerText = easyPrice;
	let modalImg = document.getElementById("modal-img");
	modalImg.src = imgSrc;


	if (size == 0) {
		sizeM.style.display = 'none';
		sizeL.style.display = 'none';
		sizeW.textContent = "";
	} else {
		sizeW.textContent = "사이즈";
		sizeM.style.display = 'block';
		sizeL.style.display = 'block';
		cart.size = "M사이즈";
	}



	if (useice == 2) {
		iceButton.style.display = 'block';
		hotButton.style.display = 'block';
	} else if (useice == 1) {
		iceButton.style.display = 'block';
		hotButton.style.display = 'none';
		iceButton.textContent = "Only Ice";
		console.log("Ice");
		useice = "ICE";
		cart.iceOrHot = "ICE";
	} else if (useice == 0) {
		iceButton.style.display = 'none';
		hotButton.style.display = 'block';
		hotButton.textContent = "Only Hot";
		console.log("Hot");
		useice = "HOT";
		cart.iceOrHot = "HOT";
	} else {
		iceButton.style.display = 'none';
		hotButton.style.display = 'none';
		useice = "디저트";
		cart.iceOrHot = "디저트";
		console.log("디저트");
	}

	const l = easyPrice + 500;
	const m = easyPrice;
	console.log(cart.size);

	plusBtn.onclick = () => {
		if (cart.size === "L사이즈") {
			cart.price += l;
			modalPrice.innerText = cart.price;
			cart.count++;
			count.innerText = cart.count;
		} else {
			cart.price += m;
			modalPrice.innerText = cart.price;
			cart.count++;
			count.innerText = cart.count;
		}

	};

	minusBtn.onclick = () => {

		if (cart.size === "L사이즈") {
			if (cart.price > l) {
				cart.price -= l;
				modalPrice.innerText = cart.price;
				if (cart.count > 1) {
					cart.count--;
					count.innerText = cart.count;

				}
			}
		}else{
			if (cart.price > m) {
				cart.price -= m;
				modalPrice.innerText = cart.price;
				if (cart.count > 1) {
					cart.count--;
					count.innerText = cart.count;

				}
			}
		}
			
		};

		sizeM.onclick = () => {
			if(cart.count == 1 || cart.size === "L사이즈"){
			cart.size = "M사이즈";
			console.log(cart.size);
			sizeM.style.backgroundColor = '#011E61';
			sizeM.style.color = 'white';
			sizeL.style.backgroundColor = 'white';
			sizeL.style.color = '#011E61';
			cart.price = m;
			modalPrice.innerText = cart.price;
			cart.count = 1;
			count.innerText = cart.count;
			}else{
				return;
			}

		}
		

		sizeL.onclick = () => {
			if(cart.count == 1 || cart.size === "M사이즈"){
			cart.size = "L사이즈";
			console.log(cart.size);
			sizeL.style.backgroundColor = '#011E61';
			sizeL.style.color = 'white';
			sizeM.style.backgroundColor = 'white';
			sizeM.style.color = '#011E61';
			cart.price = l;
			modalPrice.innerText = cart.price;
			cart.count = 1;
			count.innerText = cart.count;
			cart.unitPrice = l;
			}else{
				return;
			}
		}

		iceButton.onclick = () => {
			useice = "ICE";
			cart.iceOrHot = "ICE";
			iceButton.style.backgroundColor = '#072261';
			iceButton.style.color = '#7c7c7c';
			hotButton.style.backgroundColor = '#BD433B';
			hotButton.style.color = 'white';
		}

		hotButton.onclick = () => {
			useice = "Hot";
			cart.iceOrHot = "HOT";
			iceButton.style.backgroundColor = '#0B3598';
			iceButton.style.color = 'white';
			hotButton.style.backgroundColor = '#541e1b';
			hotButton.style.color = '#7c7c7c';


		}

		pocket.onclick = () => {

			sizeM.style.backgroundColor = '#011E61';
			sizeM.style.color = 'white';
			sizeL.style.backgroundColor = 'white';
			sizeL.style.color = '#011E61';

			hotButton.style.backgroundColor = '#BD433B';
			hotButton.style.color = 'white';
			iceButton.style.backgroundColor = '#0B3598';
			iceButton.style.color = 'white';
			hotButton.textContent = "뜨겁게";
			iceButton.textContent = "얼음";

			if (useice == 2) {
				alert("얼음 또는 뜨겁게를 선택해주세요.");
				return;
			}		

			addCartItem(cart);

			displayCartItems();

			selectedImg.value = cart.img;
			selectedName.value = cart.name;
			selectedPrice.value = cart.price;
			selectedCount.value = cart.count;
			selectedIce.value = cart.iceOrHot;
			selectedSize.value = cart.size;

			modal.close();
		};

	}


	closeModal.addEventListener("click", () => {

		sizeM.style.backgroundColor = '#011E61';
		sizeM.style.color = 'white';
		sizeL.style.backgroundColor = 'white';
		sizeL.style.color = '#011E61';

		hotButton.style.backgroundColor = '#BD433B';
		hotButton.style.color = 'white';
		iceButton.style.backgroundColor = '#0B3598';
		iceButton.style.color = 'white';
		hotButton.textContent = "뜨겁게";
		iceButton.textContent = "얼음";


		modal.close();
	});

	window.onload = function() {
		displayCartItems();
	};