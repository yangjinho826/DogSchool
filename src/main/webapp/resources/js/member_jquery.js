function connectJoinIdInputEvent() {
	$("#id_Input").keyup(function() {
		var id = $(this).val();
		$.ajax({
			url : "member.get",
			data : {
				"id" : id
			},
			success : function(data) {
				console.log(data);

				if (data == 1) {
					$("#idcheck").css("color", "#F44336");
					$("#idcheck").html("이미 사용중인  아이디입니다.");
					$("#id2").val("0");

				} else {
					$("#idcheck").css("color", "black");
					$("#idcheck").html("사용할 수 있는 아이디입니다.");
					$("#id2").val("1");
					
				}
			}
		});
	});
}

function mousehorver() {
	$(".member_info_btn").click(function(){
		$(".member_singup_kind").slideToggle(500)
	})
}

$(function() {
	connectJoinIdInputEvent();
	mousehorver();
});