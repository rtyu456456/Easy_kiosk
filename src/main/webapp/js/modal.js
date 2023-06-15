const modal = document.getElementById("modal");
const modalImg = document.getElementById("modal-img");
const closeModal = document.getElementById("close-modal");

function modalPage(imgSrc, easyName, easyPrice){
	console.log(easyName);
	console.log(easyPrice);
	console.log(imgSrc);
	
const modalName = modal.querySelector(".modal-name");
modalName.textContent = easyName;

const modalPrice = modal.querySelector(".modal-price");
modalPrice.textContent = easyPrice;

modalImg.src = imgSrc;

modal.showModal();
}




closeModal.addEventListener("click", closeM);

function closeM(){
	modal.close();
}