
function postscript_Delete(){
	$("#postscript_Delete").click(function(){
		let p_no = document.querySelector('#postscript_Delete').value;
		if(confirm("삭제하시겠습니까?")){
		  $.ajax({
			  url : '/HC/postscript.Delete',
			  type : 'GET',
			  data : {"p_no" : p_no},
		  	  success : function(result){	
		  		  if(result === 1){
		  			  alert("삭제 되었습니다.");
		  			  location.href = "/HC/postscript.go";
		  		  }else{
		  			  alert("자신이 작성한 후기만 삭제할수있습니다.");
		  			  location.href = "/HC/postscript.go";
		  		  }	  
			  }
		  })
		}
	});
}

function postscript_UpdatePageGo(p){
	let p_no = p;
	location.href="postscript.UpdatePageGo?p_no="+p_no;
}

function postscript_call(){
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

function postscript_call2(){
	let p_title = document.myForm.p_title;	
	let p_txt = document.myForm.p_txt;	
	
	
	let ok = confirm("수정 하시겠습니까?")
	if (ok) {
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
		alert('수정 완료되었습니다.');
	}
	
}


$(function(){
	postscript_Delete();
});
