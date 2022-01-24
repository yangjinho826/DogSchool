function postscript_Delete(p){
	let p_no = p;
	let ok = confirm("정말로 삭제하시겠습니까?");
	
	if(ok){
		location.href="postscript.Delete?p_no="+p_no;
	}
}

function postscript_UpdatePageGo(p){
	let p_no = p;
	location.href="postscript.UpdatePageGo?p_no="+p_no;
}

function call(){
	let p_title = document.myForm.p_title;	
	let p_txt = document.myForm.p_txt;	
	
	if (isEmpty(p_title)) {
		alert('제목을 입력하세요');
		p_title.value = "";
		p_title.focus();

		return false;
	}
	
	if (isEmpty(p_txt)) {
		alert('내용을 입력하세요');
		p_txt.value = "";
		p_txt.focus();

		return false;
	}
	
}
