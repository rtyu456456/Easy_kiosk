const callButton = document.getElementById("call-button");
const staffCall = document.getElementById("staff-call");
const closeButton = document.getElementById("close-button");

callButton.addEventListener("click", () =>{
	
	staffCall.showModal();
})

closeButton.addEventListener("click", () =>{
	
	staffCall.close();
	
})
