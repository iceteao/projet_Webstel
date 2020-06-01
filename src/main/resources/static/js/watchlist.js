
$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		
		var href= $(this).attr('href');	
		
		$.get(href, function(watchlistItem, status){
			$('#idEdit').val(watchlistItem.id);
			$('#countryedit').val(watchlistItem.country);
			$('#addressedit').val(watchlistItem.address);
			$('#dateFromedit').val($.format.date(watchlistItem.dateFrom,"dd/MM/yyyy"));
			$('#dateToedit').val($.format.date(watchlistItem.dateTo,"dd/MM/yyyy"));
			$('#hdescedit').val(watchlistItem.hdesc);
			$('#serviceedit').val(watchlistItem.service);
			$('#limitedit').val(watchlistItem.limit);
			$('#commentedit').val(watchlistItem.comment);	
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