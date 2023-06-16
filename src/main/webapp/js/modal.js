const modal = document.getElementById("modal");
const modalImg = document.getElementById("modal-img");
const closeModal = document.getElementById("close-modal");
const modalName = modal.querySelector(".modal-name");
const modalPrice = modal.querySelector(".modal-price");
const iceButton = document.getElementById("ice");
const hotButton = document.getElementById("hot");
const count = document.getElementById("count");
const pocket = document.getElementById("in-my-pocket");
const selectedName = document.getElementById("pocketName");
const selectedIce = document.getElementById("pocketIce");
const selectedCount = document.getElementById("pocketCount");
const selectedPrice = document.getElementById("pocketPrice");


function modalPage(imgSrc, easyName, easyPrice, useice) {
	console.log(modalPrice);
	console.log(easyName);
	console.log(easyPrice);
	console.log(imgSrc);
	console.log(useice);


	if (useice == 2) {
		iceButton.style.display = 'block';
		hotButton.style.display = 'block';
	} else if (useice == 1) {
		iceButton.style.display = 'block';
		hotButton.style.display = 'none';
		iceButton.textContent = "Only Ice";
		console.log("Ice");
	} else if (useice == 0) {
		iceButton.style.display = 'none';
		hotButton.style.display = 'block';
		hotButton.textContent = "Only Hot";
		console.log("Hot");
	}


	iceButton.addEventListener("click", () => {
		console.log("Ice");
	})

	hotButton.addEventListener("click", () => {
		console.log("Hot");
	})


	modalName.textContent = easyName;
	modalImg.src = imgSrc;

	modal.showModal();

	let totalCount = 1;
	let c = 1;
	modalPrice.textContent = easyPrice;
	count.textContent = totalCount;

	let Price = easyPrice;
	let plusPrice = document.getElementById("plus-price");
	plusPrice.addEventListener("click", () => {
		easyPrice += Price;
		console.log(easyPrice);
		modalPrice.textContent = easyPrice;


		totalCount += c;
		count.textContent = totalCount;
	})


	let minusPrice = document.getElementById("minus-price");
	minusPrice.addEventListener("click", () => {
		if (easyPrice > Price) {
			easyPrice -= Price;
		} else {
			easyPrice = Price;
		}
		console.log(easyPrice);


		totalCount -= c;
		if (totalCount < 1) {
			totalCount = 1;
		}

		count.textContent = totalCount;
		modalPrice.textContent = easyPrice;
	})


class selectedMenu{
	constructor(){
        this.name = easyName;
        this.ice = useice;
        this.count = totalCount;
        this.price = easyPrice;
    }
	
}

	pocket.addEventListener("click", () => {
		
		/*console.log(easyName);
		console.log(useice);
		console.log(totalCount);
		console.log(easyPrice);*/

		const selectMenu = new selectedMenu();
		console.log(selectMenu.name);
		console.log(selectMenu.ice);
		console.log(selectMenu.count);
		console.log(selectMenu.price);
		
		selectedName.value = selectMenu.name;
		selectedIce.value = selectMenu.ice;
		selectedCount.value = selectMenu.count;
		selectedPrice.value = selectMenu.price;	
		
		
	

	})


}








closeModal.addEventListener("click", closeM);

function closeM() {
	modal.close();
}