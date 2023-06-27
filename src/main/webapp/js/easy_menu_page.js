const callButton = document.getElementById("call-button");
const staffCall = document.getElementById("staff-call");
const closeButton = document.getElementById("close-button");

callButton.addEventListener("click", () =>{
	const c = confirm("직원에게 도움을 요청하시겠습니까?");
	if(c == true){
	staffCall.showModal();
	}
})

closeButton.addEventListener("click", () =>{
	
	staffCall.close();
	
})


const homeBtn = document.getElementById("home");

homeBtn.onclick = () =>{
	localStorage.removeItem("cartItems");
}