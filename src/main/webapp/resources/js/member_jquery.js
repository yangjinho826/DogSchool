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

function validphonenumber() {
	let phonefirst;
	let phonesecond;
	let phonethird;
	let phonenumber;
	
	$(".phonesecond").keyup(function() {
		phonefirst = $(".phonefirst").val();
		phonesecond = $(".phonesecond").val();

		if(phonefirst !== "010"){
			if (phonesecond.length !== 3) {
				$("#numbercheck").html("두번째칸에 3자리만 입력해주세요").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
			}else{
				$("#numbercheck").html(" ")
			}
		}else if(phonefirst === "010"){
			if (phonesecond.length === 3) {
				$("#numbercheck").html("010은 두번째칸에 4자리를 입력해주세요").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
			}else{
				$("#numbercheck").html(" ")
			}
		}else{
			
		}
	});
	
	$(".phonethird").keyup(function() {
		phonethird = $(".phonethird").val();
		phonenumber = phonefirst + phonesecond + phonethird;
		
		$.ajax({
			url : "phonenumber.get",
			data : {
				"phonenumber" : phonenumber
			},
			success : function(data) {
				if(data == 1 && phonethird.length === 4) {
					$("#numbercheck").css("color", "black");
					$("#numbercheck").html("사용가능한 전화번호 입니다.").css("font-weight","bold").css("font-size","20px");
					$("#phonenumber").val("1");
				}else if(phonethird.length !== 4){
					$("#numbercheck").css("color", "#F44336");
					$("#numbercheck").html("세번째칸에 4자리를 입력해주세요").css("font-weight","bold").css("font-size","20px");
					$("#phonenumber").val("0");
				}else {
					$("#numbercheck").css("color", "#F44336");
					$("#numbercheck").html("중복된 전화번호입니다.").css("font-weight","bold").css("font-size","20px");
					$("#phonenumber").val("0");
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
	connectJoinpwInputEvent();
	validphonenumber();
	mousehorver();

});