function GallerywriteWindow(){
	document.domain = "localhost";
	window.open("gallery.write.go", "Popup", "width=450,height=280")
	
}

function closeWithSubmit()
{
    let f= document.forms.galleryForm;
    document.domain = "localhost"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
    opener.name = "openerNames"; //유니크한 이름이어야 합니다.
    f.target = opener.name;
    f.submit();
    self.close();
}


function gallerycallme(){
	 let g_title = document.galleryForm.g_title;

	 if(isEmpty(g_title)){
		alert('가격을 입력하세요');
		g_title.value = "";
		g_title.focus();

		 return false;
	 }
	 
	 closeWithSubmit()
}


function updateGallery(n){
	var ok = confirm("사진을 수정하시겠습니까?");
	if (ok) {
		location.href = "gallery.update.go?g_no=" + n	
		}
	}

function deleteGallery(n){
	var ok = confirm("사진을 삭제하시겠습니까?");
	if (ok) {
		location.href = "gallery.delete?g_no=" + n;
	}
}


