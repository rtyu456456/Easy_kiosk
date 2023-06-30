const modal = document.getElementById("optionModal");
const closeBtn = document.getElementById("close-btn");
const totalPriceEl = document.getElementById("total-price");
let totalCnt = document.getElementById("total-count");

const ccImageSrc = document.getElementById("cartImageSrc");
const ccName = document.getElementById("cartName");
const ccPrice = document.getElementById("cartPrice");
const ccCnt = document.getElementById("cartCnt");
const ccIce = document.getElementById("cartIceOrHOt");

let cart = {};
let selectedOptions = {
	iceOrHot: null,
	optionSize: null,
	shot: null,
	syrup: null,
	cream: null,
};

let modalIce = document.getElementById("modal-ice");
let modalHot = document.getElementById("modal-hot");

let largeBtn = document.querySelector("#size-large");
let mediumBtn = document.querySelector("#size-medium");
const addCart = modal.querySelector("#cart-btn");
const plusbtn = modal.querySelector("#plus-btn");
const minusbtn = modal.querySelector("#minus-btn");
const aside__payBtn = document.querySelector(".aside__payBtn");

// 옵션까지 똑같은 음료에 대한 장바구니내 가격계산 함수
function calSameCoffeePrice(item) {
	// 선택된 옵션에 따라 가격을 조정하여 반환
	let selectedPrice = item.optionSize === "large" ? item.unitPrice + 500 : item.unitPrice;
	return selectedPrice * item.cnt;
}

function addCartItem(cart) {
	console.log(cart);  // cart 객체는 모달열때 값세팅이 되어지도록 됨

	// cartItems가 null을 반환할경우 []가 사용되어짐 
	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");
	console.log(cartItems);

	// 동일한 메뉴와 옵션을 가진 아이템이 이미 장바구니에 있는지 확인.
	const existingItem = cartItems.find(item => isEqual(item, cart));

	if (existingItem) {
		// 동일한 아이템이 이미 존재하면 새롭게 만드는것이아니라 장바구니내 동일메뉴의 수량을 증가.
		existingItem.cnt += cart.cnt;
		existingItem.price = calSameCoffeePrice(existingItem); // 가격을 올바르게 계산하여 업데이트합니다.
	} else {
		// 장바구니에 새로운 아이템을 추가
		cartItems.push(cart);
	}

	// 빈cartItems 배열에 세팅된 cart객체를 여기서 담아줌
	console.log(JSON.stringify(cartItems));

	// 로컬스토리지에는 문자열만 들어갈수있기때문에 cartItems(Json)을 문자열로 바꿔서 넣어줌
	localStorage.setItem("cartItems", JSON.stringify(cartItems));

}

function isEqual(item1, item2) {
	return (
		item1.name === item2.name &&
		item1.iceOrHot === item2.iceOrHot &&
		item1.optionSize === item2.optionSize &&
		item1.shot === item2.shot &&
		item1.syrup === item2.syrup &&
		item1.cream === item2.cream
	);
}

function displayCartItems() {
	// 카트아이템스 가져오기
	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	let cartContainer = document.getElementById("cartContainer");

	cartContainer.innerHTML = "";

	let totalCartPrice = 0;

	// cartItems 반복문 돌려서 장바구니 부분 세팅해주기 
	cartItems.forEach((item, index) => {

		// 총가격에 상품가격 더해주기
		totalCartPrice += item.price;

		// 상위 요소를 생성 // iceOrHot 여부에 따라서 배경색 유동적으로 설정
		let itemContainer = document.createElement("div");
		itemContainer.style.textAlign = "center";
		itemContainer.style.borderRadius = "6px";
		itemContainer.style.margin = "5px";
		itemContainer.style.padding = "6px 25px";
		if (item.iceOrHot === null) {
//			itemContainer.style.backgroundColor = "#fad390";
			itemContainer.style.backgroundColor = "rgba( 245, 166, 35, 0.2 )";
			itemContainer.style.boxShadow = "0 2px 8px 0 rgba(31, 38, 135, 0.37)";
			itemContainer.style.backdropFilter = "blur(16px)";
			itemContainer.style.webkitBackdropFilter = "blur(16px)";
			itemContainer.style.border = "1.6px solid rgba( 255, 255, 255, 0.18 )";
		} else {
			itemContainer.style.backgroundColor = item.iceOrHot === "ice" ? "rgba( 74, 144, 226, 0.25 )" : "rgba( 208, 2, 27, 0.25 )";
			itemContainer.style.border = item.iceOrHot === "ice" ? "1.6px solid #011E61" : "1.6px solid #BD433B";   
		}
		itemContainer.classList.add("itemContainer");

		// 이미지세팅
		let imgEl = document.createElement("img");
		imgEl.src = item.imageSrc;

		let quantityContainer = document.createElement("div");
		quantityContainer.style.display = "flex";
		quantityContainer.style.justifyContent = "center";
		quantityContainer.style.alignItems = "center";

		let minusBtn = document.createElement("button");
		minusBtn.innerText = "-";
		minusBtn.style.marginRight = "6px";
		minusBtn.style.padding = "1px 9px";
		minusBtn.style.fontSize = "24px";
		minusBtn.style.fontWeight = "500";
		minusBtn.style.color = "#dee";
		minusBtn.style.backgroundColor = "rgba( 228, 41, 59, 1 )";
		minusBtn.onclick = () => {
			if (item.cnt > 1) {
				item.cnt--;
				updateCartItem(index, item);
			}
		};

		let quantityEl = document.createElement("span");
		quantityEl.innerText = item.cnt;

		let plusBtn = document.createElement("button");
		plusBtn.innerText = "+";
		plusBtn.style.marginLeft = "6px";
		plusBtn.style.padding = "1px 9px";
		plusBtn.style.fontSize = "24px";
		plusBtn.style.fontWeight = "500";
		plusBtn.style.color = "#dee";
		plusBtn.style.backgroundColor = "rgba( 17, 94, 228, 1 )";
		plusBtn.onclick = () => {
			item.cnt++;
			updateCartItem(index, item);
		};

		quantityContainer.appendChild(minusBtn);
		quantityContainer.appendChild(quantityEl);
		quantityContainer.appendChild(plusBtn);

		// 삭제 버튼의 컨테이너 생성, 나중에 css파일에 이쪽에서 제어하는 css부분들 분리해줄예정
		let deleteBtnContainer = document.createElement("div");
		deleteBtnContainer.style.textAlign = "end";
		deleteBtnContainer.style.marginTop = "-6.8px";
		deleteBtnContainer.style.marginRight = "-26px";
		deleteBtnContainer.style.marginBottom = "10px";

		let deleteBtn = document.createElement("button");
		deleteBtn.classList.add("dBtn");
		deleteBtn.innerText = "X";
		deleteBtn.style.fontSize = "20px";
		deleteBtn.style.fontWeight = "500";
		deleteBtn.style.color = "#222";
		deleteBtn.style.backgroundColor = "rgba( 155, 155, 155, 1 )";
		deleteBtn.style.borderRadius = "2px";
		deleteBtn.onclick = () => {
			let opacity = 1; // 시작 투명도를 설정합니다.

			let timer = setInterval(function() {
				if (opacity <= 0) {
					clearInterval(timer);
				}
				itemContainer.style.opacity = opacity;
				itemContainer.style.filter = 'alpha(opacity=' + opacity * 100 + ")";
				opacity -= opacity * 0.1;
			}, 10); // 50ms마다 투명도를 조정합니다.
			setTimeout(function() {
				deleteCartItem(index);
			}, 300);
		};

		// 삭제 버튼 컨테이너에 삭제 버튼 추가
		deleteBtnContainer.appendChild(deleteBtn);

		// 상위 요소에 이미지, 수량, 그리고 삭제 버튼 컨테이너를 추가
		itemContainer.appendChild(deleteBtnContainer);
		itemContainer.appendChild(imgEl);
		itemContainer.appendChild(quantityContainer);

		// 상위 요소를 카트 컨테이너에 추가
		cartContainer.appendChild(itemContainer);
	});

	// 총가격 업뎃하기
	let totalPriceCa = document.getElementById("total-cart-price");
	totalPriceCa.innerText = '₩' + totalCartPrice + '원';

}

function updateCartItem(index, item) {
	// 로컬스토리지에서 카트아이템스 가져오기
	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	// 옵션에 따라 적절한 가격 설정
	let selectedPrice = item.optionSize === "large" ? item.unitPrice + 500 : item.unitPrice;

	// 새로운 갯수를 기반으로 항목의 총 가격을 업데이트
	item.price = selectedPrice * item.cnt;

	// 새로운 갯수를 기반으로 항목의 총 가격을 업데이트
	//    item.price = item.unitPrice * item.cnt;

	// 수정한 그 객체 카트아이템스 배열에 다시 세팅
	cartItems[index] = item;

	// 내용이 바뀌었으니 로컬스토리지에 그 배열 다시 세팅
	localStorage.setItem("cartItems", JSON.stringify(cartItems));

	// 바뀐내용 장바구니부분 다시 보여줘야되니까 다시 부르기
	displayCartItems();
}

function deleteCartItem(index) {
	// 카트아이템스 가져오기
	let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");

	// 카트아이템스 배열에서 index번호에 있는 1개의 요소를 삭제
	cartItems.splice(index, 1);

	// 삭제했으니까 로컬스토리지 내용 다시 세팅
	localStorage.setItem("cartItems", JSON.stringify(cartItems));

	// 다시 세팅 됐으니까 다시 보여주기
	displayCartItems();
}

const startPosition = 0; // 시작 위치
const endPosition = 600; // 종료 위치
const duration = 300; // 애니메이션의 지속 시간 (밀리초)
const frameRate = 60; // 애니메이션의 프레임 속도 (프레임/초)
const frameInterval = 1000 / frameRate; // 프레임 간의 간격 (밀리초)
const totalFrames = Math.ceil(duration / frameInterval); // 전체 프레임 수
let currentFrame = 0; // 현재 프레임 수
let currentPosition = startPosition; // 현재 위치
const offsetYStart = 0; // 시작 offsetY 값
const offsetYEnd = 200; // 종료 offsetY 값
const opacityStart = 1; // 시작 투명도
const opacityEnd = 0; // 종료 투명도

function cartAnimation() {
	let originImg = document.querySelector("#modalImage");
	let image = originImg.cloneNode(true);
	document.querySelector(".optionImg").appendChild(image);
	image.style.position = "fixed";
	currentFrame = 0;
	animate(image);
	setTimeout(function() {
		modal.close();
	}, 350);

}

function animate(image) {
	const progress = currentFrame / totalFrames; // 애니메이션 진행도 계산
	const newPosition = startPosition + (endPosition - startPosition) * progress; // 현재 위치 계산
	const offsetY = offsetYStart + (offsetYEnd - offsetYStart) * progress; // 점진적으로 변경되는 offsetY 값
	const opacity = opacityStart + (opacityEnd - opacityStart) * progress; // 점진적으로 감소되는 투명도 값
	image.style.transform = `translate(${newPosition}px, ${offsetY}px)`; // 이미지 위치 업데이트
	image.style.opacity = opacity; // 투명도 업데이트
	currentFrame++; // 다음 프레임으로 이동

	if (currentFrame <= totalFrames) {
		// 애니메이션이 완료되지 않았으면 다음 프레임 예약
		setTimeout(() => animate(image), frameInterval);
	}
}

// 모달 여는, 열때 함수
function openModal(imageSrc, name, price, ice, desc, options, size) {

	console.log(imageSrc);
	console.log(name);
	console.log(price);
	console.log(ice);
	console.log(desc);
	console.log(options);
	console.log(size);

	// 모달 열때마다 초기화 세팅 옵션객체도마찬가지 옵션기본값은 no
	selectedOptions = {
		iceOrHot: null,
		optionSize: null,
		shot: 'no',
		syrup: 'no',
		cream: 'no',
	};

	const optionButtons = document.querySelectorAll(".optionBtn button");

	// 옵션들 선택할때마다 active 값으로 버튼색 제어
	optionButtons.forEach(button => {
		button.onclick = () => {
			// 같은 선택 카테고리에 속한 버튼의 active 클래스를 제거
			document.querySelectorAll(`.optionBtn button[name='${button.name}']`).forEach(btn => {
				btn.classList.remove('active');
			});

			// 선택된 옵션을 업데이트
			selectedOptions[button.name] = button.value;

			// yesBtn 혹은 noBtn 클래스를 가진 버튼에 active 클래스를 추가 
			if (button.classList.contains('yesBtn') || button.classList.contains('noBtn')) {
				button.classList.add('active');
			}
		};
	});

	// 모달 열때마다 선택한 그 커피를 세팅
	cart = { name: name, price: price, unitPrice: price, iceOrHot: ice, imageSrc: imageSrc, cnt: 1 };
	// 모달 열때마다 cart에 담을 커피객체 값들 세팅
	totalPriceEl.innerText = cart.price;
	totalCnt.innerText = cart.cnt;
	let modalName = modal.querySelector(".modal-name");
	modalName.innerText = name;
	let modalPrice = modal.querySelector("#total-price");
	modalPrice.innerText = '₩' + price + '원';
	let modalImage = document.getElementById("modalImage");
	modalImage.src = imageSrc;
	let modalDesc = modal.querySelector(".m-desc");
	modalDesc.innerText = desc;
	let mSize = modal.querySelector(".sizeContainer");
	mSize.style.display = size == 0 ? "none" : "block";
	modal.showModal();
	modal.style.opacity = 0;

	let opacity = 0.1; // 시작 투명도를 설정합니다.
	let timer = setInterval(function() {
		if (opacity >= 1) {
			clearInterval(timer);
		}
		modal.style.opacity = opacity;
		modal.style.filter = 'alpha(opacity=' + opacity * 100 + ")";
		opacity += opacity * 0.1;
	}, 10); // 50ms마다 투명도를 조정합니다.


	let mediumPrice = parseInt(totalPriceEl.innerText.replace(/[^\d]/g, '')); // '₩' + '원' 이것들 제거하고 숫자만남기기위해서 처리
	let largePrice = mediumPrice + 500;
	let selectedPrice = cart.unitPrice;
	let largeBtnClicked = false;

	largeBtn.onclick = () => {
		if (!largeBtnClicked) {
			largeBtnClicked = true;
			selectedOptions.optionSize = "large";
			cart.price = largePrice;
			totalPriceEl.innerText = '₩' + largePrice + '원';
			selectedPrice = largePrice;
			mediumBtn.style.backgroundColor = "#515e7e";
			largeBtn.style.backgroundColor = "#FF6347";
			cart.cnt = 1;
			totalCnt.innerText = cart.cnt;
		} else {
			return;
			// 이미 largeBtn이 클릭된 경우 원래의 값으로 되돌리지 않고 아무 동작도 하지 않음
		}
	};

	mediumBtn.onclick = () => {
		largeBtnClicked = false;
		selectedOptions.optionSize = "medium";
		cart.price = mediumPrice;
		totalPriceEl.innerText = '₩' + mediumPrice + '원';
		selectedPrice = mediumPrice;
		largeBtn.style.backgroundColor = "#515e7e";
		mediumBtn.style.backgroundColor = "#2090ff";
		cart.cnt = 1;
		totalCnt.innerText = cart.cnt;
	};

	if (ice == 2) {
		modalIce.style.display = "inline-block";
		modalHot.style.display = "inline-block";
	} else if (ice == 1) {
		modalHot.style.display = "none";
		modalIce.style.display = "inline-block";
	} else if (ice == 0) {
		modalIce.style.display = "none";
		modalHot.style.display = "inline-block";
	} else if (ice == 3) {
		modalIce.style.display = "none";
		modalHot.style.display = "none";
	}

	// 커피마다 가지고 있는 옵션들 뭘 선택할 수 있게 보여줄지 제어
	const optionsArray = options.split("!");
	for (let i = 0; i < optionsArray.length; i++) {
		if (optionsArray[i] != 'NONE') {
			let foundEl = modal.querySelector("button[name='" + optionsArray[i].toLowerCase() + "']").parentNode;
			foundEl.style.display = 'block';
		}
	}

	// 가격세팅
	plusbtn.onclick = () => {
		cart.price += selectedPrice;
		totalPriceEl.innerText = '₩' + cart.price + '원';
		cart.cnt++;
		totalCnt.innerText = cart.cnt;

	};

	minusbtn.onclick = () => {
		if (cart.price > selectedPrice) {
			cart.price -= selectedPrice;
			totalPriceEl.innerText = '₩' + cart.price + '원';
			if (cart.cnt > 1) {
				cart.cnt--;
				totalCnt.innerText = cart.cnt;
			}
		}
	};

	addCart.onclick = () => {
		mediumBtn.style.backgroundColor = "#515e7e";
		largeBtn.style.backgroundColor = "#515e7e";
		// 모든 버튼의 active 클래스 제거
		const optionButtons = document.querySelectorAll(".optionBtn button");
		optionButtons.forEach(button => {
			button.classList.remove('active');
		});

		// 옵션세팅
		for (const option in selectedOptions) {
			// ice가 3이고, options가 NONE이며, size가 0인 경우는 예외로 처리
			if (ice == 3 && options == 'NONE' && size == 0 || ice == 1 && size == 0 && options == 'NONE') {
				break;
			} else if (size == 0 && ice == 0 && selectedOptions.optionSize === null && selectedOptions.iceOrHot === null) {
				selectedOptions.iceOrHot = 'hot';
				// size가 0인 경우에 처리할 로직
				// 예외로 처리할 조건에 해당하는 경우.
				break;
			} else if (size == 1 && ice == 1 && selectedOptions.optionSize === null && selectedOptions.iceOrHot === null) {
				selectedOptions.iceOrHot = 'ice';
				alert('음료의 사이즈를 선택해주세요');
				return;
			} else if (size == 1 && ice == 1 && selectedOptions.optionSize !== null && selectedOptions.iceOrHot === null) {
				selectedOptions.iceOrHot = 'ice';
				
			} else if (selectedOptions.iceOrHot === null && size != 1 && ice != 1) {
				// iceOrHot 옵션을 선택하지 않은 경우에 대한 처리 로직
				alert('음료의 온도(Ice,Hot)을 선택해주세요');
				return;
			} else if (selectedOptions.optionSize === null && size != 0 && ice != 0) {
				if (selectedOptions.iceOrHot === null && size == 1 && ice == 2) {
					alert('음료의 온도(Ice,Hot)을 선택해주세요');
				}
					alert('음료의 사이즈를 선택해주세요');
					return;
			} else {
				// 선택된 옵션이 모두 존재하는 경우에 대한 처리 로직
				// 여기에 원하는 동작을 추후에 추가가능.
			}
		}

		// cart객체랑 selectedOptions객체 합쳐진 객체로 다시 세팅
		cart = {
			...cart,
			...selectedOptions
		};
		// 카트에 기본 car객체와 옵션선택이 합쳐진 그 객체가 다시 세팅
		addCartItem(cart);
		cartAnimation();

		// 추가됐으니 다시 부름
		displayCartItems();

		console.log('Selected Options:');
		for (const option in selectedOptions) {
			console.log(option + ': ' + selectedOptions[option]);
		}

		ccName.value = cart.name;
		ccPrice.value = cart.price;
		ccCnt.value = cart.cnt;
		ccIce.value = cart.iceOrHot;
		ccImageSrc.value = cart.imageSrc;

		console.log(ccName.value);
		console.log(ccPrice.value);
		console.log(ccCnt.value);
		console.log(ccIce.value);
		console.log(ccImageSrc.value);
		//modal.close();
	};
}

closeBtn.addEventListener("click", () => {
	// 모든 버튼의 active 클래스 제거
	const optionButtons = document.querySelectorAll(".optionBtn button");
	optionButtons.forEach(button => {
		button.classList.remove('active');
	});
	mediumBtn.style.backgroundColor = "#515e7e";
	largeBtn.style.backgroundColor = "#515e7e";
	modal.close();
});

function checkCartIsEmpty() {
  let cartItems = JSON.parse(localStorage.getItem("cartItems") || "[]");
  if (cartItems.length === 0) {
    alert("장바구니가 비어 있습니다. 상품을 추가해주세요.");
    return false; // 폼 제출을 막기 위해 false 반환
  }
  
  return true; // 폼 제출을 허용할땐 true 반환
}

function savePage(page) {
    sessionStorage.setItem('selectedPage', page);
}

document.addEventListener("DOMContentLoaded", function() {
    // 모든 nav 버튼 색상 초기화
    const allNavButtons = document.querySelectorAll('.nav__menu__btns');
    allNavButtons.forEach(button => {
        button.style.backgroundColor = 'rgba( 255, 255, 255, 0.9 )'; 
        button.style.color = '#011E61'; 
    });

    // 세션에서 선택된 페이지 읽어오기
    const selectedPage = sessionStorage.getItem('selectedPage');

    if (selectedPage) {
        // 선택된 페이지의 버튼 찾기
        const selectedButton = document.querySelector(`button[data-page='Easy_kiosk/${selectedPage}']`);

        if (selectedButton) {
            // 버튼 색상 변경
            selectedButton.style.backgroundColor = '#011E61'; 
            selectedButton.style.color = '#ffffff'; 
        }
    }
});

// 페이지 로드되고 장바구니 보여주기
window.onload = function() {
	displayCartItems();
};