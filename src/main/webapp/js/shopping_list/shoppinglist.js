let pbtns = document.querySelectorAll(".plus-btn");
let mbtns = document.querySelectorAll(".minus-btn");

let originPrice = 0;
/*
for (i = 0; i < pbtns.length; i++) {
	pbtns[i].addEventListener("click", (e) => {
		const priceEl = e.target.parentNode.previousElementSibling;
		console.log(priceEl);
		const cntEl = e.target.nextSibling.nextSibling;
		const originInput = e.target.nextSibling.nextSibling.nextSibling.nextSibling;
		console.log(originInput.value)
		let cnt = parseInt(cntEl.innerText);
		cntEl.innerText = ++cnt;
		priceEl.innerText = parseInt(originInput.value) * cnt;
	});
	
	mbtns[i].addEventListener("click", (e) => {
        const priceEl = e.target.parentNode.previousElementSibling;
        console.log(priceEl);
        const cntEl = e.target.previousSibling.previousSibling;
        const originInput = e.target.nextSibling.nextSibling;
        console.log(originInput.value)
        let cnt = parseInt(cntEl.innerText);
        if (cnt > 0) {
            cntEl.innerText = --cnt;
            priceEl.innerText = parseInt(originInput.value) * cnt;
        }
    });
}
*/

for (let i = 0; i < pbtns.length; i++) {
    pbtns[i].addEventListener("click", (e) => {
        const priceEl = e.target.parentNode.previousElementSibling;
        console.log(priceEl);
        const cntEl = e.target.nextElementSibling;
        const originInput = e.target.parentNode.querySelector(".origin-val");
        console.log(originInput.value);
        let cnt = parseInt(cntEl.innerText);
        cntEl.innerText = ++cnt;
        priceEl.innerText = parseInt(originInput.value) * cnt;
    });

    mbtns[i].addEventListener("click", (e) => {
        const priceEl = e.target.parentNode.previousElementSibling;
        console.log(priceEl);
        const cntEl = e.target.nextElementSibling.nextElementSibling;
        const originInput = e.target.parentNode.querySelector(".origin-val");
        console.log(originInput.value);
        let cnt = parseInt(cntEl.innerText);
        if (cnt > 1) {
            cntEl.innerText = --cnt;
            priceEl.innerText = parseInt(originInput.value) * cnt;
        }
    });
}

	/*
function count(p) {
	// 결과를 표시할 element
	const resultElement = document.querySelector(".count")
	// 현재 화면에 표시된 값
	let number = resultElement.innerText;

	// 더하기/빼기
	if (type == "plus") {
		number = parseInt(number) + 1;

	}
	 }else if(type == "minus")  {
	   number = parseInt(number) - 1;
	   console.log(price);
	 }
	// 결과 출력
	resultElement.innerText = number;
}
	 */