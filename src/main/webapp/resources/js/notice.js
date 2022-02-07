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

function notice_call2(){
	let n_title = document.myForm.n_title;	
	let n_txt = document.myForm.n_txt;	
	
	let ok = confirm("수정 하시겠습니까?")
	if (ok) {
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
		alert('수정 완료되었습니다.');
	}
	
	
	
}


//선생님이 삭제할때
function notice_TDelete(){
	$("#notice_TDelete").click(function(){
		let n_no = document.querySelector('#notice_TDelete').value;
		if(confirm("삭제하시겠습니까?")){
		  $.ajax({
			  url : '/HC/notice.TDelete',
			  type : 'GET',
			  data : {"n_no" : n_no},
		  	  success : function(result){	
		  		  if(result === 1){
		  			  alert("삭제 되었습니다.");
		  			  location.href = "/HC/notice.go";
		  		  }else{
		  			  alert("자신이 작성한 공지사항만 삭제할수있습니다.");
		  			  location.href = "/HC/notice.go";
		  		  }	  
			  }
		  })
		}
	});
}

//원장이 삭제할때
function notice_DDelete(){
	$("#notice_DDelete").click(function(){
		let n_no = document.querySelector('#notice_DDelete').value;
		if(confirm("삭제하시겠습니까?")){
		  $.ajax({
			  url : '/HC/notice.DDelete',
			  type : 'GET',
			  data : {"n_no" : n_no},
		  	  success : function(result){	
		  		  if(result === 1){
		  			  alert("삭제 되었습니다.");
		  			  location.href = "/HC/notice.go";
		  		  }else{
		  			  alert("삭제 실패하였습니다.");
		  			  location.href = "/HC/notice.go";
		  		  }	  
			  }
		  })
		}
	});
}


$(function(){
	notice_TDelete();
	notice_DDelete();

});