function review_Delete(){
	$("#review_Delete").click(function(){
		let r_no = document.querySelector('#review_Delete').value;
		if(confirm("삭제하시겠습니까?")){
		  $.ajax({
			  url : '/HC/review.Delete',
			  type : 'GET',
			  data : {"r_no" : r_no},
		  	  success : function(result){	
		  		  if(result === 1){
		  			  alert("삭제 되었습니다.");
		  			  location.href = "/HC/review.go";
		  		  }else{
		  			  alert("자신이 작성한 후기만 삭제할수있습니다.");
		  			  location.href = "/HC/review.go";
		  		  }	  
			  }
		  })
		}
	});
}

function review_UpdatePageGo(r){
	let r_no = r;
	location.href="review.UpdatePageGo?r_no="+r_no;
}

function review_call(){
	let r_title = document.myForm.r_title;	
	let r_txt = document.myForm.r_txt;	
	

		if (isEmpty(r_title)) {
			alert('제목을 입력하세요');
			r_title.value = "";
			r_title.focus();
	
			return false;
		}
		
		if (isEmpty(r_txt)) {
			alert('내용을 입력하세요');
			r_txt.value = "";
			r_txt.focus();
	
			return false;
		}
	
}

function review_call2(){
	let r_title = document.myForm.r_title;	
	let r_txt = document.myForm.r_txt;	
	
	
	let ok = confirm("수정 하시겠습니까?")
	if (ok) {
		if (isEmpty(r_title)) {
			alert('제목을 입력하세요');
			r_title.value = "";
			r_title.focus();
	
			return false;
		}
		
		if (isEmpty(r_txt)) {
			alert('내용을 입력하세요');
			r_txt.value = "";
			r_txt.focus();
	
			return false;
		}
		alert('수정 완료되었습니다.');
	}
	
}


$(function(){
	review_Delete();
});