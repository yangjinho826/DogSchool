function notice_Delete(n){
	let n_no = n;
	let ok = confirm("정말로 삭제하시겠습니까?");
	
	if(ok){
		location.href="notice.Delete?n_no="+n_no;
	}
}


function notice_UpdatePageGo(n){
	let n_no = n;
	location.href="notice.UpdatePageGo?n_no="+n_no;
}


function notice_call(){
	let n_title = document.myForm.n_title;	
	let n_txt = document.myForm.n_txt;	
	
	if (isEmpty(n_title)) {
		alert('제목을 입력하세요');
		n_title.value = "";
		n_title.focus();

		return false;
	}
	
	if (isEmpty(n_txt)) {
		alert('내용을 입력하세요');
		n_txt.value = "";
		n_txt.focus();

		return false;
	}
	
}