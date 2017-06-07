$(document).ready( function () {
	 var table = $('#category').DataTable({
			"sAjaxSource": "listCat",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "cid"},
		      { "mData": "name" },
		     
			]
	 })
	  var table = $('#supplier').DataTable({
			"sAjaxSource": "listSat",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "cid"},
		      { "mData": "name" },
		    
				 
			]
	 })
});
