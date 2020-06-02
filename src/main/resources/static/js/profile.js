
$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		
		var href= $(this).attr('href');	
		
		$.get(href, function(profiledetails, status){
			$('#aboutmeEdit').val(profiledetails.aboutme);
			$('#countryedit').val(profiledetails.country);
			$('#mobileEdit').val(profiledetails.mobile);
			$('#websiteEdit').val(profiledetails.website);
		$('#editdetails').submit();		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
});