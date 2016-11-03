jQuery(document).ready(
	function() {
		//left
		$('.button_item').click(
				function() {
					$('.button_item').css('background', 'rgb(252,252,252)');
					$('.button_item').css('color', '#000');
					$(this).css('background', '#AAA');
					$(this).css('color', '#FFF');
				}
			)
		if($('.hides').text() == '0') $('.info_name').css('color', '#39F');
		else if($('.hides').text() == '1') $('.info_name').css('color', '#F39');
		//info
		$('#infoform .container .button_group input').click(
				function() {
					$('#infoform .container .button_group input').css('background', '#AAA');
					var c;
					if($(this).index() == 0) {
						c = '#39F';
						$('#infoform .container .button_group .hide').val('0');
					}
					else if($(this).index() == 1) {
						c = '#F39';
						$('#infoform .container .button_group .hide').val('1');
					}
					else {
						c = '#96C';
						$('#infoform .container .button_group .hide').val('');
					}
					$(this).css('background', c);
				}
			)
		if($('#infoform .hide').val() == 0) $('#infoform .container .button_group input#m').click();
		else if($('#infoform .hide').val() == 1) $('#infoform .container .button_group input#f').click();
		else $('#infoform .container .button_group input#u').click();
	}
);

function click_info() {
	$('.inner_frame').css("display", "none");
	$('.inner_frame#info').css("display", "block");
}
function click_icon() {
	$('.inner_frame').css("display", "none");
	$('.inner_frame#icon').css("display", "block");
}
function click_safe() {
	$('.inner_frame').css("display", "none");
	$('.inner_frame#safe').css("display", "block");
}

function hideSexBtn() {
	$('.container .button_group input#m').hide();
	$('.container .button_group input#f').hide();
	$('.container .button_group input#u').hide();
	if($('.container .button_group .hide').val() == 0) {
		$('.container .button_group input#m').show();
		$('.container .button_group input#m').css('background', '#39F');
	}
	else if($('.container .button_group .hide').val() == 1) {
		$('.container .button_group input#f').show();
		$('.container .button_group input#f').css('background', '#F39');
	}
	else {
		$('.container .button_group input#u').show();
		$('.container .button_group input#u').css('background', '#96C');
	}
	$('.container .button_group input').unbind("click");
}

function infoOnSubmit() {
	if($('#infoform .container#name .input').val().length > 30) {
		$('#infoform .errorMessage#name').text('*昵称过长');
		$('#infoform .container#save button').css('background', '#F00');
		return false;
	}
	else {
		$('#infoform .errorMessage#name').text('');
		$('#infoform .container#save button').css('background', '#0F0');
	}
	if($('#infoform .container#sign .input').val().length > 100) {
		$('#infoform .errorMessage#sign').text('*签名过长');
		$('#infoform .container#save button').css('background', '#F00');
		return false;
	}
	else {
		$('#infoform .errorMessage#sign').text('');
		$('#infoform .container#save button').css('background', '#0F0');
	}
	$('#infoform .container#save button').text('修改成功');
	return true;
}

function iconOnSubmit() {
	file_name = $(':file').val();
	file_name = file_name.split('.');
	suffix = file_name[file_name.length - 1];
	if(suffix == 'jpg'|| suffix == 'jpeg'|| suffix == 'gif'|| suffix == 'png'|| suffix == 'bmp') {
		$('#iconform .errorMessage#icon').text('');
		$('#iconform input#save').css('background', '#0AE');
		return true;
	}
	$('#iconform .errorMessage#icon').text('*文件类型有误');
	$('#iconform input#save').css('background', 'red');
	return false;
}

function safeOnSubmit() {
	var email = $('#safeform .container#email .input').val();
	var password = $('#safeform .container#new .input').val();
	if(email == '') {
		return true;
	}
	if(email.length > 50) {
		$('#safeform .errorMessage#email').text('*E-mail地址过长');
		return false;
	}
	var reg1 = /^[a-zA-Z_0-9]+@/;
	var reg2 = /@[a-zA-Z_0-9]+./;
	var reg3 = /.\w+$/;
	var r1 = email.match(reg1);
	var r2 = email.match(reg2);
	var r3 = email.match(reg3);
	if(r1 == null || r2 == null || r3 == null) {
		$('#safeform .errorMessage#email').text('*邮箱格式有误');
		return false;
	}
	r1[0] = r1[0].substring(0, r1[0].length - 1);
	r2[0] = r2[0].substring(1, r2[0].length - 1);
	r3[0] = r3[0].substring(1);
	if(r1[0] == null || r2[0] == null || r3[0] == null) {
		$('#safeform .errorMessage#email').text('*邮箱格式有误');
		return false;
	}
	var oldp = $('#safeform .container#old .input').val(),
		newp = $('#safeform .container#new .input').val(),
		confirmp = $('#safeform .container#confirm .input').val();
	if(oldp.length == 0 && newp.length == 0 && confirmp.length == 0) {
		$('#safeform .container#save input').css('background', '#0F0');
		$('#safeform .container#save input').val('修改成功');
		return true;
	}
	else {
		var b = pswdOnSubmit();
		return b;
	}
}

function pswdOnSubmit() {
	$('#safeform .errorMessage').text('');
	var oldp = $('#safeform .container#old .input').val(),
		newp = $('#safeform .container#new .input').val(),
		confirmp = $('#safeform .container#confirm .input').val();
	var ok = true;
	if(oldp.length < 6 || oldp.length > 32) {
		$('#safeform .errorMessage#old').text('*原密码长度有误');
		ok = false;
	}
	if(newp.length == 0) {
		$('#safeform .errorMessage#new').text('*请填写新密码');
		ok = false;
	}
	else if(newp.length < 6 || newp.length > 32) {
		$('#safeform .errorMessage#new').text('*新密码长度在6~32字范围内');
		ok = false;
	}
	if(newp != confirmp) {
		$('#safeform .errorMessage#confirm').text('*两次输入密码不一致');
		ok = false;
	}
	if(oldp == newp){
		$('#safeform .errorMessage#confirm').text('*原密码与新密码相同');
		ok = false;
	}
	if(!ok) {
		$('#safeform .container#save button').css('background','#F00');
		return false;
	}
	var offset = $('.offset').text();
	var md5pswd = MD5(oldp);
	var md5src = md5pswd + offset;
	var md5dst = MD5(md5src);
	$('#safeform .container#old .input').val(md5dst);
	$('#safeform .container#new .input').val(MD5(newp));
	$('#safeform .container#confirm .input').val(MD5(confirmp));
	$('#safeform .container#save button').css('background', '#0F0');
	return true;
}