$(document).ready(function(e) {
	$('.button_thumb').click(function() {
		articleId = $('.comment_input input#articleId').val();
		userId = getCookie("u_id");
		$.ajax({
            type: "POST",
            url: "ajax/thumbAction",
            data:
            {
                'articleId' : articleId,
                'userId' : userId
            },
            success:
            	function(data) {
	            	if(data == 'ERROR') {
						$('.button_thumb').css('background', '#F00');
						$('.button_thumb #right').text('请刷新重试');
					}
					else if(data == 'INPUT') {
						alert('您已经点过赞了哦!');
					}
					else {
						$('.button_thumb').css('background', '#8AF');
						$('.button_thumb #right').text(data + '人觉得很赞');
					}
            	},
            error:
                function(data) {
					$('.button_thumb').css('background', '#F00');
					$('.button_thumb #right').text('服务器出错');
                }
        });
	});
	
	$('.comment_submit').click(function() {
		data = $('.comment_textarea').val();
		if(data.length == 0) {
			$('.comment_warn').text('*请输入评论');
			return;
		}
		else if(data.length > 400) {
			$('.comment_warn').text('*评论字数过长');
			return;
		}
		articleId = $('.comment_input input#articleId').val();
		userId = getCookie("u_id");
		replyId = null;
		$.ajax({
            type: "POST",
            url: "ajax/commentAction",
            data:
            {
                'articleId' : articleId,
                'userId' : userId,
                'replyId' : replyId,
                'data' : data
            },
            success:
            	function(data) {
	            	if(data == 'ERROR') {
						$('.comment_warn').text('评论失败，请刷新重试');
					}
					else {
						location.reload();
					}
            	},
            error:
                function(data) {
					$('.comment_warn').text('服务器出错');
                }
        });
	});
});
