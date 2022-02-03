// 스케줄 작성
function schedulewriteWindow(){
	document.domain = "localhost";
	window.open("sechdule_write.go", "Popup", "width=420,height=380")
}

function closeWithSubmit()
{
    let f= document.forms.popupForm;
    document.domain = "localhost"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
    opener.name = "openerNames"; //유니크한 이름이어야 합니다.
    f.target = opener.name;
    f.submit();
    self.close();
}


function call_schedule(){
	 let s_day = document.popupForm.s_day;
	 let s_text = document.popupForm.s_text;
	 
	 if(isEmpty(s_day)){
		alert('날짜를 선택해주세요.');
		s_day.value = "";
		s_day.focus();

		 return false;
	 }
	 
	 if(isEmpty(s_text)){
		alert('텍스트를 입력해주세요.');
		s_text.value = "";
		s_text.focus();

		 return false;
	 }
	 closeWithSubmit();
}

// 디테일 페이지 
function scheduleDetailWindow(n){
	let s_no = n;
	
	document.domain = "localhost";
	window.open("schedule_Detail?s_no="+s_no, "Popup", "width=420,height=380")
}






function closeWithDSubmit()
{
	let ok = confirm("정말로 삭제하시겠습니까?");
	
	if(ok){
	    let f= document.forms.popupForm1;
	    document.domain = "localhost"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
	    opener.name = "openerNames"; //유니크한 이름이어야 합니다.
	    f.target = opener.name;
	    f.submit();
	    self.close();
	}else{
		self.close();
	}
}

function closeupdateSubmit()
{
	let ok = confirm("정말로 수정하시겠습니까?");
	
	if(ok){
	    let f= document.forms.popupForm2;
	    document.domain = "localhost"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
	    opener.name = "openerNames"; //유니크한 이름이어야 합니다.
	    f.target = opener.name;
	    f.submit();
	    self.close();
	}else{
		self.close();
	}
}



function call_schedule1(){
	 let s_day = document.popupForm2.s_day;
	 let s_text = document.popupForm2.s_text;
	 
	 if(isEmpty(s_day)){
		alert('날짜를 선택해주세요.');
		s_day.value = "";
		s_day.focus();

		 return false;
	 }
	 
	 if(isEmpty(s_text)){
		 alert('텍스트를 입력해주세요.');
		s_text.value = "";
		s_text.focus();

		 return false;
	 }
	 closeupdateSubmit();
	}



$(function() {
	  $( "#datepicker1" ).datepicker({
	    dateFormat: 'yy-mm-dd',
	    minDate: 0
	  });
	});