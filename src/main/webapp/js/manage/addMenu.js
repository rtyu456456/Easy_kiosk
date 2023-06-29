 const addModal = document.getElementById("addModal");
 const openAdd = document.getElementById("openAdd");
 const closeAdd = document.getElementById("closeAdd")
 
openAdd.addEventListener("click", function(){
	addModal.showModal();	
})




closeAdd.addEventListener("click", function(){
	
	addModal.close();
});
