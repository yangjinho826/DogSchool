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


//원장->유치원신청
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
//선생님->원장등록신청
function applyCheck2(){
	let id = document.myForm2.Ta_id;
	let name = document.myForm2.Ta_name;
	let pn = document.myForm2.Ta_phonenumber;
	let txt = document.myForm2.Ta_text;
	
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
	if(!isEmpty(id) && !isEmpty(name) && !isEmpty(pn) && !isEmpty(txt)){
		alert('신청이 성공적으로 완료되었습니다!');
		return true;
	}
}
//견주->원장강아지등록신청
function applyCheck3(){
	let id = document.myForm3.Ua_id;
	let name = document.myForm3.Ua_name;
	let age = document.myForm3.Ua_age;
	let img = document.myForm3.Ua_img;
	
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
	
	if(file != "jpg" && file != "png"){
		alert("jpg 또는 png 형식만 첨부해 주세요.");
		img.value = "";
		img.focus();
		return false;
	}
	if(!isEmpty(id) && !isEmpty(name) && !isEmpty(age) && !isEmpty(img) && (file == "jpg" || file == "png")){
		alert('신청이 성공적으로 완료되었습니다!');
		return true;
	}
}


//신청 취소
function applyCancelDa(num){
	var ok = confirm("신청을 취소하시겠습니까?");
	if(ok) {
		location.href = "apply.cancel.da?Da_no=" + num;
		alert("성공적으로 취소되었습니다.");
	}
}
function applyCancelTa(num){
	var ok = confirm("신청을 취소하시겠습니까?");
	if(ok) {
		location.href = "apply.cancel.ta?Ta_no=" + num;
		alert("성공적으로 취소되었습니다.");
	}
}
function applyCancelUa(num){
	var ok = confirm("신청을 취소하시겠습니까?");
	if(ok) {
		location.href = "apply.cancel.ua?Ua_no=" + num;
		alert("성공적으로 취소되었습니다.");
	}
}


//원장: 선생님, 견주 삭제
function deleteTeacher(num){
	var ok = confirm("해당 선생님을 삭제하시겠습니까?");
	if(ok){
		location.href = "apply.delete.t?Ta_no=" + num;
		alert("삭제되었습니다.");
	}
}

function deletePet(num){
	var ok = confirm("해당 강아지를 삭제하시겠습니까?");
	if(ok){
		location.href = "apply.delete.p?Ua_no=" + num;
		alert("삭제되었습니다.");
	}
}


$(function() {
	connectAddrSearchEvent();
	daterangeSelectEvent();
});