function my_registrationCheck(){
	$(".member_info_btn_list").click(function(){
		const id = ($('.member_info_btn_list').data('id'));
		const typee = ($('.member_info_btn_list').data('typee'));
		  $.ajax({
			  url : '/HC/my_registrationCheck',
			  type : 'GET',
			  data : {id: id, typee:typee},
		  	  success : function(result){	
		  		  if(result === 1){
		  			  location.href="yuchiwon.get.allpuppy?id="+id+"&typee="+typee;
		  		  }else{
		  			  alert("신청된 강아지가 없거나 등록된 강아지의 기간이 지났습니다.");
		  		  }	  
			  }
		  })
	});
}


$(function(){
	my_registrationCheck();
	
});
