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
