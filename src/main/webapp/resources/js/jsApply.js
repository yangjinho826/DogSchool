function connectAddrSearchEvent() {
	$("#addrSearchBtn").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#m_addr3Input").val(data.zonecode);
				$("#m_addr1Input").val(data.roadAddress);
			}
		}).open();
	});
}

function daterangeSelectEvent(){
	$('input[name="Ua_daterange"]').daterangepicker();
}


function passSchool(no){
	var ok = confirm("수락하시겠습니까?");
	if(ok) {
		location.href = "apply.pass.s?Da_no=" + no;
	}
}
function failSchool(no){
	var ok = confirm("거절하시겠습니까?");
	if(ok) {
		location.href = "apply.fail.s?Da_no=" + no;
	}
}

function passTeacher(no){
	var ok = confirm("수락하시겠습니까?");
	if(ok) {
		location.href = "apply.pass.t?Ta_no=" + no;
	}
}
function failTeacher(no){
	var ok = confirm("거절하시겠습니까?");
	if(ok) {
		location.href = "apply.fail.t?Ta_no=" + no;
	}
}

function passPet(no){
	var ok = confirm("수락하시겠습니까?");
	if(ok) {
		location.href = "apply.pass.p?Ua_no=" + no;
	}
}
function failPet(no){
	var ok = confirm("거절하시겠습니까?");
	if(ok) {
		location.href = "apply.fail.p?Ua_no=" + no;
	}
}

function deleteSchool(no){
	var ok = confirm("해당 유치원을 삭제하시겠습니까?");
	if(ok) {
		location.href = "manage.delete?Da_no=" + no;
		alert("삭제가 완료되었습니다!");
	}
}

$(function() {
	connectAddrSearchEvent();
	daterangeSelectEvent();
});