function my_registrationCheck(){
	$(".member_info_btn_list").click(function(){
		const id = ($('.member_info_btn_list').data('id'));
		const typee = ($('.member_info_btn_list').data('typee'));
		
		if(typee === 1){
			  $.ajax({
				  url : '/HC/my_registrationCheck',
				  type : 'GET',
				  data : {id: id, typee:typee},
			  	  success : function(result){	
			  		  if(result === 1){
			  			  location.href="yuchiwon.get.allpuppy?id="+id+"&typee="+typee;
			  		  }else if(result === 0){
			  			  alert("신청된 강아지가 없습니다.");
			  		  }	  
				  }
			  })
		}else if(typee === 2){
			 $.ajax({
				  url : '/HC/my_registrationCheck',
				  type : 'GET',
				  data : {id: id, typee:typee},
			  	  success : function(result){	
			  		  if(result === 1){
			  			location.href="yuchiwon.get.allpuppy?id="+id+"&typee="+typee;
			  		  }else if(result === 2){
			  		   alert("소속되어 있는 유치원이 없습니다."); 
			  		  }else if(result === 0){
			  			alert("관리하는 강아지가 없어 소속된 유치원 홈페이지로 이동합니다.");
			  			location.href="schoolmain.go?result="+result;
			  		  }	  
				  }
			  })
		}
		
	});
}

function my_School(){
	$(".my_School_btn_list").click(function(){
		const id = ($('.my_School_btn_list').data('id'));
		const typee = ($('.my_School_btn_list').data('typee'));
		
		if(typee === 1){
			  $.ajax({
				  url : '/HC/my_School.go',
				  type : 'GET',
				  data : {id: id, typee:typee},
			  	  success : function(result){	
			  		  if(result === 0){
			  			alert("소속되어 있는 유치원이 없습니다."); 
			  		  }else{
			  			location.href="schoolmain.go?ps.dA_no="+result;
			  		  }	  
				  }
			  })
		}else if(typee === 2){
			 $.ajax({
				  url : '/HC/my_School.go',
				  type : 'GET',
				  data : {id: id, typee:typee},
			  	  success : function(result){	
			  		  if(result === 1){
			  			location.href="schoolmain.go?result="+result;
			  		  }else if(result === 2){
			  		   alert("소속되어 있는 유치원이 없습니다."); 
			  		  }else if(result === 0){
			  			location.href="schoolmain.go?result="+result;
			  		  }	  
				  }
			  })
		}else if(typee === 3){
			 $.ajax({
				  url : '/HC/my_School.go',
				  type : 'GET',
				  data : {id: id, typee:typee},
			  	  success : function(result){	
			  		 if(result === 0){
				  			alert("소속되어 있는 유치원이 없습니다."); 
			  		 }else{
				  			location.href="schoolmain.go?ps.dA_no="+result;
				  	 }	  
				  }
			  })
		}
		
	});
}



$(function(){
	my_registrationCheck();
	my_School();
});
