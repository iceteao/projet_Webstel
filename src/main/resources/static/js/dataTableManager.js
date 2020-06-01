
	$(document).ready(function() {
		 
	    // DataTable
	    var table = $('#mytable').DataTable({
			'sDom': 'rtip' ,
		      orderCellsTop: true,
		      responsive: true,
			           columns: [
			                      {className: "min-phone-l" },
			                      {className: "all" },
			                      {className: "all" }	,
			                      {className: "all" }	,
			                      {"bSearchable": false, "bSortable": false, className: "desktop"},
			                      {"bSearchable": false, "bSortable": false, className: "desktop"},
			                      {"bSearchable": false, "bSortable": false, className: "all" }
			    ],
	      initComplete: function () {

	               $.fn.dataTable.ext.search.push(
	        function (settings, data, dataIndex) {
	            var min = $('#min').datepicker("getDate");
	            var max = $('#max').datepicker("getDate");
                var d = data[2].split("/");
                var startDate = new Date(d[1]+ "/" +  d[0] +"/" + d[2]);
                var d2 = data[3].split("/");
                var endDate = new Date(d2[1]+ "/" +  d2[0] +"/" + d2[2]);
                
                
                if (min == null && max == null) { return true; }
                
                if (max == null && min >= startDate) {
                	if (min <= endDate){
                	return true; }
                }
                
                if (min == null && max >= startDate) {
                	if (max <= endDate){
                	return true; }
                }
                
                
                if (max >= startDate && max <= endDate && min >= startDate && min <= endDate) { return true; }
                return false;
	        }
	        );

	       
	               $("#min").datepicker({ onSelect: function () { table.draw(); }, minDate: 0, dateFormat:"dd/mm/yy"});
	               $("#max").datepicker({ onSelect: function () { table.draw(); }, minDate: 0, dateFormat:"dd/mm/yy" });
	            var table = $('#mytable').DataTable(); 
	      }
	    });

        function filterColumn () {
            $('#mytable').DataTable().column(1).search(
                $('#addr').val()
            ).draw();
            $('#mytable').DataTable().column(0).search(
                $('#country').val()
            ).draw();  
              };

           $('input.column_filter').on( 'keyup click', function () {
                filterColumn( $(this).parents('div').attr('data-column') );
            } );
          	
           var $dates = $('#min, #max').datepicker();
           $('#clear-dates').on('click', function () {
        	    $dates.datepicker('setDate', null);    
        	    table.columns().search().draw();
        	});

	} );
