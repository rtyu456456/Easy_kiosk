const callButton = document.getElementById("km-call-button");
const staffCall = document.getElementById("km-staff-call");
const closeButton = document.getElementById("km-close-button");

callButton.addEventListener("click", () =>{
	const c = confirm("직원에게 도움을 요청하시겠습니까?");
	if(c == true){
	staffCall.showModal();
	console.log("직원 호출")
	}
})


closeButton.addEventListener("click", () =>{
	staffCall.close();
})
