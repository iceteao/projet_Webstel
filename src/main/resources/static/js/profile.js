

$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		
		var href= $(this).attr('href');	
		
		$.get(href, function(profiledetails, status){
			$('#idEdit').val(profiledetails.id);
			$('#aboutmeEdit').val(profiledetails.aboutme);
			$('#countryEdit').val(profiledetails.country);
			$('#mobileEdit').val(profiledetails.mobile);
			$('#websiteEdit').val(profiledetails.website);
		});	
		$('#editModal').modal();	
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
});