document.addEventListener("DOMContentLoaded", function() {
	deleteLocalStorage();
});

function deleteLocalStorage() {
	localStorage.clear();
	console.log("로컬 스토리지 삭제 성공");
}