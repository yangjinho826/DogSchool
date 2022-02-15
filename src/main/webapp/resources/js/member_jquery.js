function connectJoinIdInputEvent() {
	$("#id_Input").keyup(function() {
		var id = $(this).val();
		var regExp = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

		$.ajax({
			url : "member.get",
			data : {
				"id" : id
			},
			success : function(data) {
				console.log(data);
					 
					 if (data == 1 || id.match(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]|[~!@#$%^&*()_+]/)) {
					$("#idcheck").css("color", "#F44336");
					$("#idcheck").html("이미 사용중이거나 한글/특수문자가 포함된 아이디 입니다.").css("font-weight","bold").css("font-size","20px");
					$("#id2").val("0");

				} else {
					$("#idcheck").css("color", "black");
					$("#idcheck").html("사용할 수 있는 아이디입니다.").css("font-weight","bold").css("font-size","20px");
					$("#id2").val("1");
					
				}
			}
		});
	});
}	

function connectJoinpwInputEvent() {
	
			$("input").keyup(function() {
				var pw = $("#pw").val();
				var pw1 = $("#pw1").val();
					if (pw == pw1) {
						$("#pwcheck").css("color", "black");
						$("#pwcheck").html("비밀번호가 일치합니다.").css("font-weight","bold").css("font-size","20px");
					} else {
						$("#pwcheck").css("color", "#F44336");
						$("#pwcheck").html("비밀번호가 일치하지 않습니다.").css("font-weight","bold").css("font-size","20px");
					}
	});

}

function mousehorver() {
	$(".member_info_btn").click(function(){
		$(".member_singup_kind").slideToggle(500)
	})
}

$(function() {
    connectJoinIdInputEvent();
	connectJoinpwInputEvent();
	mousehorver();

});