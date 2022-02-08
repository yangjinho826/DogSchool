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
				
				 //if (regExp.test(id)) {
					// $("#idcheck").html("ID에 한글이 포함되어있습니다.");
				//}
					 
					 if (data == 1 || id.match(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]|[~!@#$%^&*()_+]/)) {
					$("#idcheck").css("color", "#F44336");
					$("#idcheck").html("이미 사용중이거나 한글/특수문자가 포함된 아이디 입니다.");
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

$(function() {
	connectJoinIdInputEvent();
});