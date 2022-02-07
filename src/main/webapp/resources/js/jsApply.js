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

function applyCheck1(){
	let id = document.myForm.Da_id;
	let name = document.myForm.Da_name;
	let pn = document.myForm.Da_phonenumber;
	let sn = document.myForm.Da_schoolname;
	let a1 = document.myForm.Da_addr1;
	let a2 = document.myForm.Da_addr2;
	let a3 = document.myForm.Da_addr3;
	
	if (isEmpty(id)) {
        alert('아이디를 입력해 주세요.');
        id.value = "";
        id.focus();
        return false;
	}

	if (isEmpty(name)) {
        alert('이름을 입력해 주세요.');
        name.value = "";
        name.focus();
        return false;
	}
	
	if (isEmpty(pn)) {
        alert('전화번호를 입력해 주세요.');
        pn.value = "";
        pn.focus();
        return false;
	}

	if(isEmpty(sn)){
		alert('유치원 이름을 입력해 주세요.');
		sn.value = "";
		sn.focus();
		return false;
	}
	
	if(isEmpty(a1)){
		alert('주소를 입력해 주세요.');
		a1.value = "";
		a1.focus();
		return false;
	}
	if(isEmpty(a2)){
		alert('주소를 입력해 주세요.');
		a2.value = "";
		a2.focus();
		return false;
	}
	if(isEmpty(a3)){
		alert('주소를 입력해 주세요.');
		a3.value = "";
		a3.focus();
		return false;
	}
	
	if(!isEmpty(id) && !isEmpty(name) && !isEmpty(pn) && !isEmpty(sn) && !isEmpty(a1) && !isEmpty(a2) && !isEmpty(a3)){
		alert('신청이 성공적으로 완료되었습니다!');
		return true;
	}
}


$(function() {
	connectAddrSearchEvent();
	daterangeSelectEvent();
});