/**
 * 
 */

const updateModal = document.getElementById("updateModal");
const closeUpdate = document.getElementById("closeUpdate")
let inputName = updateModal.querySelector('input[name="m_name"]');
let inputPrice = updateModal.querySelector('input[name="m_price"]');
let select_ice = updateModal.querySelector('select[name="m_ice"]');
let select_size = updateModal.querySelector('select[name="m_size"]');
let select_type = updateModal.querySelector('select[name="m_type"]');
let select_type_easy = updateModal.querySelector('select[name="m_type_easy"]');
let select_weather = updateModal.querySelector('select[name="m_weather"]');
let select_soldout = updateModal.querySelector('select[name="m_soldout"]');
let optionChk = updateModal.querySelectorAll('input[name="m_option"]');
let inputOrder = updateModal.querySelector('input[name="m_order"]')

function openUpdate(
	m_no, m_name, m_price, m_img, m_ice, m_size, m_type, m_type_easy, m_option, m_desc, m_weather, m_soldout, m_order
) {
	// 모달 열기
	updateModal.showModal();
	
	// 이름 찝어주기
	inputName.value = m_name;
	
	// 가격 찝어주기
	inputPrice.value = m_price;
	
	// select_ice 찝기

	for (let i = 0; i < select_ice.options.length; i++) {
		if (select_ice.options[i].value == m_ice) {
			select_ice.options[i].selected = true;
		}
	}
	
	// select_size 찝기

	for (let i = 0; i < select_size.options.length; i++) {
		if (select_size.options[i].value == m_size) {
			select_size.options[i].selected = true;
		}
	}

	// select_type 찝기
	for (let i = 0; i < select_type.options.length; i++) {
		if (select_type.options[i].value == m_type) {
			select_type.options[i].selected = true;
		}
	}

	// select_type_easy 찝기
	for (let i = 0; i < select_type_easy.options.length; i++) {
		if (select_type_easy.options[i].value == m_type_easy) {
			select_type_easy.options[i].selected = true;
		}
	}

	// select_weather 찝기
	for (let i = 0; i < select_weather.options.length; i++) {
		if (select_weather.options[i].value == m_weather) {
			select_weather.options[i].selected = true;
		}
	}


	// select_soldout 찝기
	for (let i = 0; i < select_soldout.options.length; i++) {
		if (select_soldout.options[i].value == m_soldout) {
			select_soldout.options[i].selected = true;
		}
	}
	
	
	// 체크박스 찝어주기
	let chkOptions = m_option.split("!");
	for(var i = 0; i < optionChk.length; i++){
		if (chkOptions.indexOf(optionChk[i].value) != -1){
			optionChk[i].checked = true;
			}
	}
	
	// 총주문 수 찝어주기
	inputOrder.value = m_order;
	

// 변수 지정에 귀찮게 querySelector로 일일히 집어주는 것 말고도 el문을 활용할 수 있지만
// 그 경우 js 파일을 별도로 분리할 수 없음.
// 또한 파일이 로드되기 전에 js가 돌아버리면 querySelector로 찾을 DOM객체가 없기 때문에
// script 혹은 js 파일은 가급적 로드가 된 후에 불러내도록하자

}



closeUpdate.addEventListener("click", function() {
	
	// select_ice 찝기

	select_ice.options[1].selected = true;
	
	// select_size 찝기

	select_size.options[1].selected = true;

	// select_type 찝기
	select_type.options[0].selected = true;

	// select_type_easy 찝기
	select_type_easy.options[0].selected = true;

	// select_weather 찝기
	select_weather.options[0].selected = true;


	// select_soldout 찝기
	select_soldout.options[0].selected = true;
	
	
	// 체크박스 찝어주기
	for(var i = 0; i < optionChk.length; i++){
			optionChk[i].checked = false;
		}
	
	
	
	updateModal.close();
})



