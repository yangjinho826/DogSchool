function deleteReply(n, t){
	console.log(n);
	console.log(t);
	var ok = confirm("댓글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "diary.reply.delete?r_no="+n+"&mp_no="+ t;
	}
}

function updateDiary(n){
	var ok = confirm("알림장을 수정하시겠습니까?");
	if (ok) {
		location.href = "diary.update.go?mp_no=" + n;
	}
}

function deleteDiary(n){
	var ok = confirm("알림장을 삭제하시겠습니까?");
	if (ok) {
		location.href = "diary.delete?mp_no=" + n;
	}
}

function writeDiaryGo() {
	
	location.href="diary.write.go";
	
}

function diarycall(){
	let mp_title = document.dwForm.mp_title;
	let mp_condition= document.dwForm.mp_condition;
	let mp_meal= document.dwForm.mp_meal;
	let mp_defecate= document.dwForm.mp_defecate;
	let mp_supplies= document.dwForm.mp_supplies;
	let mp_txt= document.dwForm.mp_txt;
	
	
	if (isEmpty(mp_title)) {
        alert('제목을 입력해주세요.');
        mp_title.value = "";
        mp_title.focus();

        return false;
	}
	
	if (isEmpty(mp_condition)) {
        alert('건강상태를 입력해주세요.');
        mp_condition.value = "";
        mp_condition.focus();

        return false;
	}
	
	if (isEmpty(mp_meal)) {
        alert('우유량을 입력해주세요.');
        mp_meal.value = "";
        mp_meal.focus();

        return false;
	}
	
	if(isNotNumber(mp_meal)){
		alert('우유량에 숫자만 입력해주세요.');
		mp_meal.value = "";
		mp_meal.focus();

        return false;
	}
	
	if (isEmpty(mp_defecate)) {
        alert('배변량을 입력해주세요.');
        mp_defecate.value = "";
        mp_defecate.focus();

        return false;
	}
	
	if(isNotNumber(mp_defecate)){
		alert('배변량에 숫자만 입력해주세요.');
		mp_defecate.value = "";
		mp_defecate.focus();

        return false;
	}
	
	if (isEmpty(mp_supplies)) {
        alert('준비물을 입력해주세요.');
        mp_supplies.value = "";
        mp_supplies.focus();

        return false;
	}
	
	if (isEmpty(mp_txt)) {
        alert('알림 내용을 입력해주세요.');
        mp_txt.value = "";
        mp_txt.focus();

        return false;
	}
	 
	
}

function replycall(){
	let r_txt = document.replyForm.r_txt;
   
	if(isEmpty(r_txt)){
		alert('댓글을 입력해주세요.');
		r_txt.value = "";
		r_txt.focus();
	
	    return false;
	}
}