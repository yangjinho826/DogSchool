function deleteReply(n){
	var ok = confirm("댓글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "diary.reply.delete?r_no=" + n;
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