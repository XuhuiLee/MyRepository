// JavaScript Document
jQuery(document).ready(
	function() {
		$('#username').focus();
		//input repeat password
		$('#repeat_password').focusout(
			function() {
				check();
			}
		);
		//input agreement checkbox
		$('.agree_check').click(
			function() {
				$('.errorMessage li span').text('');
				if(check()) {
					var agree = $('.agree_check').val();
					if(agree == 'true') {
						$('.button').attr("disabled", true);
						$('.agree_check').val('false');
					}
					else {
						$('.button').attr("disabled", false);
						$('.agree_check').val('true');
					}
				}
				else {
					$('.agree_check').click();
				}
			}
		);
	}
);

function check(){
	var password=$('.edit_text#password').val();
	var repeat_password=$('.edit_text#repeat_password').val();
	if(password=='') {
		$('.errorMessage#repeat_password').text('*请输入密码');
		return false;
	}
	if(repeat_password=='') {
		$('.errorMessage#repeat_password').text('*请再次输入密码');
		return false;
	}
	else if(repeat_password!=''&&password!=repeat_password) {
		$('.errorMessage#repeat_password').text('*两次输入的密码不一致');
		return false;
	}
	else
		$('.errorMessage#repeat_password').text('');
	return true;
}