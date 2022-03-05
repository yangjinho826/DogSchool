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
	let phonefirst = '010';
	let phonesecond;
	let phonethird;
	let phonenumber;
	
	$(".phonefirst").click(function(){
		phonefirst = $(".phonefirst").val();
		phonnumberAjax(phonefirst, phonesecond, phonethird );
	}) ;
	
	$(".phonesecond").keyup(function(){
		phonesecond = $(".phonesecond").val();
		phonnumberAjax(phonefirst, phonesecond, phonethird );
	}) ;
	
	$(".phonethird").keyup(function(){
		phonethird = $(".phonethird").val();		
		phonnumberAjax(phonefirst, phonesecond, phonethird );
	}) ;
	
}

function phonnumberAjax(phonefirst, phonesecond, phonethird){
	let phonefirst1 = phonefirst;
	let phonesecond1 = phonesecond;
	let phonethird1 = phonethird;
	let phonenumber = phonefirst + phonesecond + phonethird;
	
	if(isNaN(phonesecond1) === true){
		$("#numbercheck").html("숫자만 입력할수 있습니다.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
		$("#phonenumbercheck").val("0");
	}else if(isNaN(phonethird1) === true){
		$("#numbercheck").html("숫자만 입력할수 있습니다.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
		$("#phonenumbercheck").val("0");
	}
	
	if(phonefirst1 == null || phonesecond1 == null|| phonethird1 == null ){
		return;
	}
	
	if(phonefirst1 !== "010"){
		if (phonenumber.length !== 10) {
			$("#numbercheck").html("10자리만 입력해주세요.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
			$("#phonenumbercheck").val("0");
		}else{
			$("#numbercheck").html(" ")
		}
	}
	else if(phonefirst1 === "010"){
		if (phonenumber.length !== 11) {
			$("#numbercheck").html("11자리 입력해주세요.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
			$("#phonenumbercheck").val("0");
		}else{
			$("#numbercheck").html(" ");
		}
	}
	


	$.ajax({
		url : "phonenumber.get",
		data : {"phonenumber" : phonenumber},
		success : function(data) {

			if(data == 1 && phonefirst1 !== "010" && phonenumber.length == 10 && isNaN(phonesecond1) !== true && isNaN(phonethird1) !== true){
				$("#numbercheck").html("사용가능한 전화번호 입니다.").css("font-weight","bold").css("font-size","20px");
				$("#phonenumbercheck").val("1");
			}else if(data == 1 && phonefirst1 === "010" && phonenumber.length == 11 && isNaN(phonesecond1) !== true && isNaN(phonethird1) !== true){
				$("#numbercheck").html("사용가능한 전화번호 입니다.").css("font-weight","bold").css("font-size","20px");
				$("#phonenumbercheck").val("1");
			}else if(data == 0 && phonefirst1 !== "010" && phonenumber.length == 10){
				$("#numbercheck").html("중복된 전화번호 입니다.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
				$("#phonenumbercheck").val("0");
			}else if(data == 0 && phonefirst1 === "010" && phonenumber.length == 11){
				$("#numbercheck").html("중복된 전화번호 입니다.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
				$("#phonenumbercheck").val("0");
			}else if(isNaN(phonesecond1) == true || isNaN(phonethird1) == true){
				$("#numbercheck").html("숫자만 입력할수 있습니다.").css("color", "#F44336").css("font-weight","bold").css("font-size","20px");
				$("#phonenumbercheck").val("0");
			}
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
	validphonenumber();
	mousehorver();

});