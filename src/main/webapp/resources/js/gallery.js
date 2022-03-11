function GallerywriteWindow(){
	document.domain = "localhost";
	let width=450;
	let height=280;
	let left = Math.ceil(( window.screen.width - width )/2);
	let top = Math.ceil(( window.screen.height - height )/2); 
	window.open("gallery.write.go", "Popup", "width="+width+",height="+height+",left="+left+",top="+top)
	
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
	let g_img = document.galleryForm.g_img;

	 if(isEmpty(g_title)){
		alert('제목을 입력하세요');
		g_title.value = "";
		g_title.focus();

		 return false;
	 }
	 
	 if (isEmpty(g_img)) {
	        alert("사진을 첨부해 주세요.");
	        g_img.value = "";
	        g_img.focus();
	        return false;
	    }
	    var img2 = g_img.value;
	    var file = img2.substring(img2.lastIndexOf('.') + 1);

	    if (file != "jpg" && file != "png" && file != "JPG" && file != "PNG") {
	        alert("jpg 또는 png 형식만 첨부해 주세요.");
	        g_img.value = "";
	        g_img.focus();
	        return false;
	    }
	 
	 closeWithSubmit()
}

function updateGallery(n){
	let width=450;
	let height=280;
	let left = Math.ceil(( window.screen.width - width )/2);
	let top = Math.ceil(( window.screen.height - height )/2); 
	window.open("gallery.update.go", "Popup", "width="+width+",height="+height+",left="+left+",top="+top)
	
}

function closeupdateWithSubmit()
{
    let f= document.forms.galleryForm1;
    document.domain = "localhost"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
    opener.name = "openerNames"; //유니크한 이름이어야 합니다.
    f.target = opener.name;
    f.submit();
    self.close();
}


function gallerycallupdateme(){
	let g_title = document.galleryForm1.g_title;
	let g_img = document.galleryForm1.g_img;

	 if(isEmpty(g_title)){
		alert('제목을 입력하세요');
		g_title.value = "";
		g_title.focus();

		 return false;
	 }
	 
	 if (isEmpty(g_img)) {
	        alert("사진을 첨부해 주세요.");
	        g_img.value = "";
	        g_img.focus();
	        return false;
	    }
	    var img2 = g_img.value;
	    var file = img2.substring(img2.lastIndexOf('.') + 1);

	    if (file != "jpg" && file != "png" && file != "JPG" && file != "PNG") {
	        alert("jpg 또는 png 형식만 첨부해 주세요.");
	        g_img.value = "";
	        g_img.focus();
	        return false;
	    }
	 
	 
	 closeupdateWithSubmit()
}



function deleteGallery(n){
	var ok = confirm("사진을 삭제하시겠습니까?");
	if (ok) {
		location.href = "gallery.delete?g_no=" + n;
	}
}


