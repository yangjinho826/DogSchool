
function pricewriteWindow(){
	document.domain = "localhost";
	window.open("priceTag_write.go", "Popup", "width=450,height=250")
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

function priceDetailWindow(n){
	let p_no = n;
	
	document.domain = "localhost";
	window.open("priceTag_Detail?p_no="+p_no, "Popup", "width=450,height=250")
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

function callme(){
 let p_price = document.popupForm.p_price;
 let p_date = document.popupForm.p_date;
 
 if(isEmpty(p_price)){
	alert('가격을 입력하세요');
	p_price.value = "";
	p_price.focus();

	 return false;
 }
 
 if(isEmpty(p_date)){
	alert('날짜 입력하세요');
	p_date.value = "";
	p_date.focus();

	 return false;
 }
 closeWithSubmit();
}

function callme1(){
	 let p_price = document.popupForm2.p_price;
	 let p_date = document.popupForm2.p_date;
	 
	 if(isEmpty(p_price)){
		alert('가격을 입력하세요');
		p_price.value = "";
		p_price.focus();

		 return false;
	 }
	 
	 if(isEmpty(p_date)){
		alert('날짜 입력하세요');
		p_date.value = "";
		p_date.focus();

		 return false;
	 }
	 closeupdateSubmit()
	}
