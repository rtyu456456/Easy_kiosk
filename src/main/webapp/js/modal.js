const modalid = document.getElementById("modal");
const modalImg = document.getElementById("modal-img");
const closeModal = modal.querySelector(".close-modal");
const modalName = modal.querySelector(".modal-name");
const modalPrice = modal.querySelector(".modal-price");
const iceButton = document.getElementById("ice");
const hotButton = document.getElementById("hot");
const count = document.getElementById("count");
const pocket = document.getElementById("in-my-pocket");
const sizeM = document.getElementById("m-size");
const sizeL = document.getElementById("l-size");
const sizeW = document.getElementById("w-size");

const selectedImg = document.getElementById("pocketImg");
const selectedName = document.getElementById("pocketName");
const selectedIce = document.getElementById("pocketIce");
const selectedCount = document.getElementById("pocketCount");
const selectedPrice = document.getElementById("pocketPrice");
const selectedSize = document.getElementById("pocketSize");


function modalPage(imgSrc, easyName, easyPrice, useice, size) {
	console.log(modalPrice);
	console.log(easyName);
	console.log(easyPrice);
	console.log(imgSrc);
	console.log(useice);
	console.log(size);

	modal.showModal();

	modalImg.src = imgSrc;
	modalName.textContent = easyName;

	let totalCount = 1;
	let c = 1;
	modalPrice.textContent = easyPrice;
	count.textContent = totalCount;
	size = "M사이즈";
	sizeM.style.backgroundColor = '#011E61';
	sizeM.style.color = 'white';


	let Price = easyPrice;
	let priceL = Price + 500;
	let plusPrice = document.getElementById("plus-price");
	plusPrice.addEventListener("click", () => {

		if (size == "L사이즈") {
			easyPrice += priceL;
			modalPrice.textContent = easyPrice;
		} else {
			easyPrice += Price;
			console.log(easyPrice);
			modalPrice.textContent = easyPrice;
		}

		totalCount += c;
		count.textContent = totalCount;
	})


	let minusPrice = document.getElementById("minus-price");
	minusPrice.addEventListener("click", () => {

		if (size == "L사이즈") {
			if (easyPrice > priceL) {
				easyPrice -= priceL;
			} else {
				easyPrice = priceL;
			}
			modalPrice.textContent = easyPrice;
		} else {

			if (easyPrice > Price) {
				easyPrice -= Price;
			} else {
				easyPrice = Price;
			}
			modalPrice.textContent = easyPrice;
		}

		console.log(easyPrice);

		totalCount -= c;
		if (totalCount < 1) {
			totalCount = 1;
		}

		count.textContent = totalCount;
	})


	if (size == 0) {
		sizeM.style.display = 'none';
		sizeL.style.display = 'none';
		sizeW.textContent = "";
	} else {
		sizeW.textContent = "사이즈";
		sizeM.style.display = 'block';
		sizeL.style.display = 'block';
	}

	sizeM.addEventListener("click", () => {
		size = "M사이즈";
		console.log(size);
		sizeM.style.backgroundColor = '#011E61';
		sizeM.style.color = 'white';
		sizeL.style.backgroundColor = 'white';
		sizeL.style.color = '#011E61';

		easyPrice = Price;
		modalPrice.textContent = easyPrice;
		totalCount = 1;
		count.textContent = totalCount;
	})

	sizeL.addEventListener("click", () => {
		size = "L사이즈";
		console.log(size);
		sizeL.style.backgroundColor = '#011E61';
		sizeL.style.color = 'white';
		sizeM.style.backgroundColor = 'white';
		sizeM.style.color = '#011E61';

		easyPrice = priceL;
		modalPrice.textContent = easyPrice;
		totalCount = 1;
		count.textContent = totalCount;

	})


	if (useice == 2) {
		iceButton.style.display = 'block';
		hotButton.style.display = 'block';
	} else if (useice == 1) {
		iceButton.style.display = 'block';
		hotButton.style.display = 'none';
		iceButton.textContent = "Only Ice";
		console.log("Ice");
		useice = "ICE";
	} else if (useice == 0) {
		iceButton.style.display = 'none';
		hotButton.style.display = 'block';
		hotButton.textContent = "Only Hot";
		console.log("Hot");
		useice = "HOT";
	} else {
		iceButton.style.display = 'none';
		hotButton.style.display = 'none';
		console.log("디저트");
	}

	iceButton.addEventListener("click", () => {
		useice = "ICE";
		console.log("Ice");
		iceButton.style.backgroundColor = '#072261';
		iceButton.style.color = '#7c7c7c';
		hotButton.style.backgroundColor = '#BD433B';
		hotButton.style.color = 'white';

	})

	hotButton.addEventListener("click", () => {
		useice = "HOT";
		console.log("Hot");
		iceButton.style.backgroundColor = '#0B3598';
		iceButton.style.color = 'white';
		hotButton.style.backgroundColor = '#541e1b';
		hotButton.style.color = '#7c7c7c';
	})




	class selectedMenu {
		constructor() {
			this.img = imgSrc;
			this.name = easyName;
			this.ice = useice;
			this.count = totalCount;
			this.price = easyPrice;
			this.size = size;
		}
	}
	

	pocket.addEventListener("click", () => {

		if (useice == 2) {
			alert('얼음 여부를 선택하세요');
			return;
		}

		const selectMenu = new selectedMenu();

		let name = selectMenu.name;
		let price = selectMenu.price;

		console.log(name);
		console.log(price);

		var cartTable = document.getElementById("cartTable2");
		var newRow = cartTable.insertRow(cartTable.rows.length);

		var menuCell = newRow.insertCell(0);
		menuCell.innerHTML = name;

		var priceCell = newRow.insertCell(1);
		var priceValue = price;
		priceCell.innerHTML = `<span class="price" data-price="${priceValue}">${priceValue}</span>`;

		var quantityCell = newRow.insertCell(2);
		quantityCell.innerHTML = `
        <input class="plus-btn" type="button" value="1" onclick="changeQuantity(this, 'increase')">
        <div class="count">1</div>
        <input class="origin-val" value="${priceValue}" data-original-value="${priceValue}">
        <input class="minus-btn" type="button" value="-1" onclick="changeQuantity(this, 'decrease')">
        <button onclick="deleteMenu(this)">x</button>
    `;

		var prices = getPricesFromCart();
		var total = totalPrice(prices);
		updateTotalPrice(total);

		/*	console.log(selectMenu.name);
			console.log(selectMenu.img);
			console.log(selectMenu.ice);
			console.log(selectMenu.count);
			console.log(selectMenu.price);
			console.log(selectMenu.size);*/

		/*JS로 장바구니C에 파라미터값 넘기기*/
		/*location.href =
			'BasketController?name=' + selectMenu.name +
			'&ice=' + selectMenu.ice +
			'&count=' + selectMenu.count +
			'&price=' + selectMenu.price +
			'&size=' + selectMenu.size +
			'&img=' + selectMenu.img;*/

		/* easy_contents_page.jsp에서 form 태그 통해 파라미터값 넘기기 
		
		selectedName.value = selectMenu.name;
		selectedIce.value = selectMenu.ice;
		selectedCount.value = selectMenu.count;
		selectedPrice.value = selectMenu.price;	
		selectedSize.value = selectMenu.size;	
		selectedImg.value = selectMenu.img;
		
		console.log(selectedName.value);
		console.log(selectedIce.value );
		console.log(selectedCount.value);
		console.log(selectedPrice.value);
		console.log(selectedSize.value);
		console.log(selectedImg.value);*/

		modal.close();

	})
}


function updateTotalPrice(total) {
	var totalPriceCell = document.getElementById("totalPrice");
	if (totalPriceCell) {
		totalPriceCell.innerText = total.toLocaleString() + "원";
	}
}

function changeQuantity(btn, action) {
	const countEl = btn.parentNode.querySelector(".count");
	let count = parseInt(countEl.innerText);

	if (action == "increase") {
		count++;
	} else if (action == "decrease") {
		count = Math.max(count - 1, 0);
	}

	countEl.innerText = count;

	const priceEl = btn.parentNode.parentNode.querySelector(".price");
	const priceCell = btn.parentNode.parentNode.querySelector(".origin-val");
	const price = parseInt(priceCell.dataset.originalValue) * count;

	if (!isNaN(price)) {
		priceEl.innerText = price;
		priceEl.dataset.price = price;
	}

	var array = getPricesFromCart();
	var total = totalPrice(array);
	updateTotalPrice(total);
}

function deleteMenu(btn) {
	var row = btn.parentNode.parentNode;
	row.parentNode.removeChild(row);

	var array = getPricesFromCart();
	var total = totalPrice(array);
	updateTotalPrice(total);
	
}

function totalPrice(array) {
	let total = 0;

	for (let i = 0; i < array.length; i++) {
		total += array[i];
	}

	return total;
}

function getPricesFromCart() {
	var prices = [];
	var menus = document.querySelectorAll("#cartTable2 tr:not(:first-child)");

	menus.forEach(function(menu) {
		var priceCell = menu.querySelector(".price");
		if (priceCell && priceCell.dataset.price) {
			prices.push(parseInt(priceCell.dataset.price));
		}
	});

	return prices;
}

closeModal.addEventListener("click", () => {
	iceButton.textContent = "얼음";
	iceButton.style.backgroundColor = '#0B3598';
	iceButton.style.color = 'white';
	hotButton.textContent = "뜨겁게";
	hotButton.style.backgroundColor = '#BD433B';
	hotButton.style.color = 'white';
	sizeL.style.backgroundColor = 'white';
	sizeL.style.color = '#011E61';
	sizeM.style.backgroundColor = 'white';
	sizeM.style.color = '#011E61';


	modal.close();
})










