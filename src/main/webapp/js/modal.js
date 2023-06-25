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
let minusPrice = document.getElementById("minus-price");
let plusPrice = document.getElementById("plus-price");

let cartArray = [];

class selectedMenu {
	constructor(imgSrc, easyName, easyPrice, count, useice, size) {
		this.img = imgSrc;
		this.name = easyName;
		this.price = easyPrice;
		this.count = count;
		this.ice = useice;
		this.size = size;
	}
}

let imgSrc2 = "";
let easyName2 = "";
let easyPrice2 = "";
let useice2 = "";
let size2 = "";
let price = "";
let totalCount = 1;
let c = 1;



let selecteMenu;
function modalPage(imgSrc, easyName, easyPrice, useice, size) {
	console.log(modalPrice);
	console.log(easyName);
	console.log(easyPrice);
	console.log(imgSrc);
	console.log(useice);
	console.log(size);
	
	modal.showModal();
	
	if(totalCount != 1){
		totalCount = 1;
	}
	modalImg.src = imgSrc;
	modalName.textContent = easyName;

	modalPrice.textContent = easyPrice;
	count.textContent = totalCount;
	size = "M사이즈";
	sizeM.style.backgroundColor = '#011E61';
	sizeM.style.color = 'white';

	if (size == 0) {
		sizeM.style.display = 'none';
		sizeL.style.display = 'none';
		sizeW.textContent = "";
	} else {
		sizeW.textContent = "사이즈";
		sizeM.style.display = 'block';
		sizeL.style.display = 'block';
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
	
	imgSrc2 = imgSrc;
	easyName2 = easyName;
	easyPrice2 = easyPrice;
	useice2 = useice;
	size2 = size;
	price = easyPrice;

}

plusPrice.addEventListener("click", () => {
		easyPrice2 += price;
		console.log(easyPrice2);
		modalPrice.textContent = easyPrice2;

		totalCount += c;
		count.textContent = totalCount;
	})
	
	
minusPrice.addEventListener("click", () => {
	if (easyPrice2 > price) {
		easyPrice2 -= price;
	} else {
		easyPrice2 = price;
	}
	console.log(easyPrice2);

	totalCount -= c;
	if (totalCount < 1) {
		totalCount = 1;
	}

	count.textContent = totalCount;
	modalPrice.textContent = easyPrice2;
})

sizeM.addEventListener("click", () => {
	size2 = "M사이즈";
	console.log(size2);
	sizeM.style.backgroundColor = '#011E61';
	sizeM.style.color = 'white';
	sizeL.style.backgroundColor = 'white';
	sizeL.style.color = '#011E61';
	if(easyPrice2 / totalCount != price){
		easyPrice2 -= 500;
		modalPrice.textContent = easyPrice2
	}
})

sizeL.addEventListener("click", () => {
	size2 = "L사이즈";
	console.log(size2);
	sizeL.style.backgroundColor = '#011E61';
	sizeL.style.color = 'white';
	sizeM.style.backgroundColor = 'white';
	sizeM.style.color = '#011E61';
	if(easyPrice2 / totalCount == price){
		easyPrice2 += 500 * totalCount;
		modalPrice.textContent = easyPrice2
	}
})

iceButton.addEventListener("click", () => {
	useice2 = "ICE";
	console.log("Ice");
	iceButton.style.backgroundColor = '#072261';
	iceButton.style.color = '#7c7c7c';
	hotButton.style.backgroundColor = '#BD433B';
	hotButton.style.color = 'white';

})

hotButton.addEventListener("click", () => {
	useice2 = "HOT";
	console.log("Hot");
	iceButton.style.backgroundColor = '#0B3598';
	iceButton.style.color = 'white';
	hotButton.style.backgroundColor = '#541e1b';
	hotButton.style.color = '#7c7c7c';
})

pocket.addEventListener("click", () => {
	
	
	
	
	selecteMenu = new selectedMenu(imgSrc2, easyName2, easyPrice2, totalCount, useice2, size2);
	/*if (useice == 2) {
		alert('얼음 여부를 선택하세요');
		return;
	}*/
	console.log(selecteMenu)


	console.log(selecteMenu.name);
	console.log(selecteMenu.img);
	console.log(selecteMenu.ice);
	console.log(selecteMenu.count);
	console.log(selecteMenu.price);
	console.log(selecteMenu.size);

	/*JS로 장바구니C에 파라미터값 넘기기*/


	cartArray.push(selecteMenu);
	console.log(cartArray);

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


});

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
});