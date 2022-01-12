function connectAddrSearchEvent() {
	$("#addrSearchBtn").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#m_addr3Input").val(data.zonecode);
				$("#m_addr1Input").val(data.roadAddress);
			}
		}).open();
	});
}

function daterangeSelectEvent(){
	$('input[name="Ua_daterange"]').daterangepicker();
}

$(function() {
	connectAddrSearchEvent();
	daterangeSelectEvent();
});