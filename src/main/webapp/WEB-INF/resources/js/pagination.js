$(document).ready(function() {
	var itemsPerPage = 6;
	var itemCount = $('.job').length;
	var totalPages = Math.ceil(itemCount / itemsPerPage);

	var options = {
		totalPages: totalPages,
		visiblePages: 6,
		onPageClick: function(event, page) {
			var startIndex = (page - 1) * itemsPerPage;
			var endIndex = startIndex + itemsPerPage;
			$('.job').hide();
			$('.job').each(function(index) {
				if (index >= startIndex && index < endIndex) {
					$(this).show();
				}
			})
		}
	}
	$('.pagination').twbsPagination(options);

})