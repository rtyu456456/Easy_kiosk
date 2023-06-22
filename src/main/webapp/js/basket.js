
	
	
	
function addToCart() {
	
	let name = window.menuInstance.name;
	let price = window.menuInstance.price;
	
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
    
    window.menuInstance = new selectedMenu();
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