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


	if(size == 0){
		sizeM.style.display = 'none';
		sizeL.style.display = 'none';
		sizeW.textContent = "";
	}

	sizeM.addEventListener("click", ()=>{
		size = "M사이즈";
		console.log(size);
	})

	sizeL.addEventListener("click", ()=>{
		size = "L사이즈";
		console.log(size);
	})


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
	} else{
		iceButton.style.display = 'none';
		hotButton.style.display = 'none';
		console.log("디저트");
	}

	iceButton.addEventListener("click", () => {
		useice = "ICE";
		console.log("Ice");
		console.log(useice);
	})

	hotButton.addEventListener("click", () => {
		useice = "HOT";
		console.log("Hot");
		console.log(useice);
	})



class selectedMenu{
	constructor(){
		this.img = imgSrc;
        this.name = easyName;
        this.ice = useice;
        this.count = totalCount;
        this.price = easyPrice;
        this.size = size;
    }
	
}

	pocket.addEventListener("click", () => {
		/*console.log(easyName);
		console.log(useice);
		console.log(totalCount);
		console.log(easyPrice);*/

		const selectMenu = new selectedMenu();
		console.log(selectMenu.name);
		console.log(selectMenu.img);
		console.log(selectMenu.ice);
		console.log(selectMenu.count);
		console.log(selectMenu.price);
		console.log(selectMenu.size);
		
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
		console.log(selectedImg.value);

	})


}


	closeModal.addEventListener("click", ()=>{
		iceButton.textContent = "얼음";
		hotButton.textContent = "뜨겁게";
		modal.close();
	})
	
	
	
	

		
	



