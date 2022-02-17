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
	$('input[name="uA_daterange"]').daterangepicker();
}


function passSchool(no){
	var ok = confirm("수락하시겠습니까?");
	if(ok) {
		location.href = "apply.pass.s?dA_no=" + no;
	}
}
function failSchool(no){
	var ok = confirm("거절하시겠습니까?");
	if(ok) {
		location.href = "apply.fail.s?dA_no=" + no;
	}
}
function passTeacher(no){
	var ok = confirm("수락하시겠습니까?");
	if(ok) {
		location.href = "apply.pass.t?tA_no=" + no;
	}
}
function failTeacher(no){
	var ok = confirm("거절하시겠습니까?");
	if(ok) {
		location.href = "apply.fail.t?tA_no=" + no;
	}
}
function passPet(no){
	var ok = confirm("수락하시겠습니까?");
	if(ok) {
		location.href = "apply.pass.p?uA_no=" + no;
	}
}
function failPet(no){
	var ok = confirm("거절하시겠습니까?");
	if(ok) {
		location.href = "apply.fail.p?uA_no=" + no;
	}
}


function deleteSchool(no){
	var ok = confirm("해당 유치원을 삭제하시겠습니까?");
	if(ok) {
		location.href = "manage.delete?dA_no=" + no;
		alert("삭제가 완료되었습니다!");
	}
}


//원장->유치원신청
function applyCheck1(){
	let id = document.myForm.dA_id;
	let name = document.myForm.dA_name;
	let pn = document.myForm.dA_phonenumber;
	let sn = document.myForm.dA_schoolname;
	let a1 = document.myForm.dA_addr1;
	let a2 = document.myForm.dA_addr2;
	let a3 = document.myForm.dA_addr3;
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
//선생님->원장등록신청
function applyCheck2(){
	let id = document.myForm2.tA_id;
	let id2 = document.myForm2.id2;
	let name = document.myForm2.tA_name;
	let pn = document.myForm2.tA_phonenumber;
	let txt = document.myForm2.tA_text;
	
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
	if(isEmpty(txt)){
		alert('자기소개를 입력해 주세요.');
		txt.value = "";
		txt.focus();
		return false;
	}
	if(id2.value == 0){
		alert('신청할 수 없는 아이디입니다.');
		location.href = "/HC/apply.waiting";
		return false;
	}
	if(!isEmpty(id) && !isEmpty(name) && !isEmpty(pn) && !isEmpty(txt) && id2.value == 1){
		alert('신청이 성공적으로 완료되었습니다!');
		return true;
	}
}
function checkTeacher(){
	$("#checkBtn").click(function(){
		var idd = $("#tA_id").val();
		$.ajax({
			url : "/HC/apply.getTeacher",
			data : {"id" : idd },
			success : function(getData){
				if(getData >= 1){
					$("#idcheck").css("color", "#F44336");
					$("#idcheck").html("이미 신청 완료된  아이디입니다. (중복 근무 불가능)");
					$("id2").val("0");
				} else {
					$("#idcheck").css("color", "black");
					$("#idcheck").html("신청 가능한 아이디입니다.");
					$("#id2").val("1");
				}
			}
		});
	});
}
//견주->원장강아지등록신청
function applyCheck3(){
	let id = document.myForm3.uA_id;
	let name = document.myForm3.uA_name;
	let age = document.myForm3.uA_age;
	let img = document.myForm3.imggg;
	
	if (isEmpty(id)) {
        alert('아이디를 입력해 주세요.');
        id.value = "";
        id.focus();
        return false;
	}
	if (isEmpty(name)) {
        alert('강아지 이름을 입력해 주세요.');
        name.value = "";
        name.focus();
        return false;
	}
	if (isEmpty(age)) {
        alert('강아지 나이를 입력해 주세요.');
        age.value = "";
        age.focus();
        return false;
	}
	if(isNotNumber(age)){
		alert("숫자만 입력해 주세요.");
		age.value = "";
        age.focus();
        return false;
	}
	if(isEmpty(img)){
		alert("사진을 첨부해 주세요.");
		img.value = "";
        img.focus();
        return false;
	}
	var img2 = img.value;
	var file = img2.substring(img2.lastIndexOf('.') + 1);
	
	if(file != "jpg" && file != "png" && file != "JPG" && file != "PNG"){
		alert("jpg 또는 png 형식만 첨부해 주세요.");
		img.value = "";
		img.focus();
		return false;
	}

	if(!isEmpty(name) && !isEmpty(age) && !isEmpty(img)){
		alert('신청이 성공적으로 완료되었습니다!');
		return true;
	}
}


//신청 취소
function applyCancelDa(num){
	var ok = confirm("신청을 취소하시겠습니까?");
	if(ok) {
		location.href = "apply.cancel.da?dA_no=" + num;
		alert("성공적으로 취소되었습니다.");
	}
}
function applyCancelTa(num){
	var ok = confirm("신청을 취소하시겠습니까?");
	if(ok) {
		location.href = "apply.cancel.ta?tA_no=" + num;
		alert("성공적으로 취소되었습니다.");
	}
}
function applyCancelUa(num){
	var ok = confirm("신청을 취소하시겠습니까?");
	if(ok) {
		location.href = "apply.cancel.ua?uA_no=" + num;
		alert("성공적으로 취소되었습니다.");
	}
}


//원장: 선생님, 견주 삭제
function deleteTeacher(num){
	var ok = confirm("해당 선생님을 삭제하시겠습니까?");
	if(ok){
		location.href = "apply.delete.t?tA_no=" + num;
		alert("삭제되었습니다.");
	}
}

function deletePet(num){
	var ok = confirm("해당 강아지를 삭제하시겠습니까?");
	if(ok){
		location.href = "apply.delete.p?uA_no=" + num;
		alert("삭제되었습니다.");
	}
}


$(function() {
	connectAddrSearchEvent();
	daterangeSelectEvent();
	checkTeacher();
});