$('document').ready(function() {

    $('.table #editButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(watchlistItem, status){
            $('#countryedit').val(watchlistItem.country);
            $('#addressedit').val(watchlistItem.address);
            $('#dateFromedit').val(watchlistItem.dateFrom);
            $('#dateToedit').val(watchlistItem.dateTo);
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