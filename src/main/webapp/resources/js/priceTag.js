function pricewriteWindow(){
	document.domain = "localhost";
	window.open("priceTag_write.go", "Popup", "width=500,height=600")
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
	document.domain = "localhost";
	let p_no = n;
	window.open("priceTag_Detail?p_no="+p_no, "Popup", "width=500,height=600")
}
