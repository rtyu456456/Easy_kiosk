// localStorage에 값을 저장합니다.
function storeMenuBoxValues() {
  const menuBox = document.querySelector('.menu-box');
  const img = menuBox.querySelector('img').getAttribute('src');
  const name = menuBox.querySelector('.name').textContent;
  const price = menuBox.querySelector('.price').textContent;
  const count = menuBox.querySelector('.count').textContent;
  const iceHot = menuBox.querySelector('.ice-hot').textContent;
  const size = menuBox.querySelector('.size').textContent;

  const values = {
    img,
    name,
    price,
    count,
    iceHot,
    size
  };

  localStorage.setItem('menuBoxValues', JSON.stringify(values));
}

// localStorage에서 값을 가져와 menu-box를 업데이트합니다.
function retrieveMenuBoxValues() {
  const storedValues = localStorage.getItem('menuBoxValues');

  if (storedValues) {
    const values = JSON.parse(storedValues);

    const menuBox = document.querySelector('.menu-box');
    menuBox.querySelector('img').setAttribute('src', values.img);
    menuBox.querySelector('.name').textContent = values.name;
    menuBox.querySelector('.price').textContent = values.price;
    menuBox.querySelector('.count').textContent = values.count;
    menuBox.querySelector('.ice-hot').textContent = values.iceHot;
    menuBox.querySelector('.size').textContent = values.size;
  }
}

// 다른 컨트롤러로 이동하기 전에 storeMenuBoxValues() 함수를 호출합니다.
function goToOtherController() {
  storeMenuBoxValues();
  // 다른 컨트롤러로 이동하는 코드를 여기에 추가하세요.
}

// 페이지가 unload 될 때 storeMenuBoxValues() 함수를 호출합니다.
window.addEventListener('beforeunload', storeMenuBoxValues);

// 페이지가 load 될 때 retrieveMenuBoxValues() 함수를 호출합니다.
window.addEventListener('DOMContentLoaded', retrieveMenuBoxValues);
