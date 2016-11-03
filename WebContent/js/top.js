function hide(){
	$('.top_right a')[1].style.display='none';
	$('.top_right a')[2].style.display='none';
	$('.user_container').mouseenter(function(){
		$('.top_right a')[1].style.display='';
		$('.top_right a')[2].style.display='';
	});
	$('.user_container').mouseleave(function(){
		$('.top_right a')[1].style.display='none';
		$('.top_right a')[2].style.display='none';
	});
}