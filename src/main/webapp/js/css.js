$(document).ready(function() {
	$(".coffee-button").off("click").on("click",function(){
		if($(".e").hasClass("active")){
			$(".coffee-button").removeClass("active");
		}else{
			$(".coffee-button").addClass("active");
		}
		
	});
});