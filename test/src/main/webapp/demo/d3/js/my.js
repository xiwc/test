jQuery(function($) {
			// alert('OK...');

			d3.selectAll("p").data([4, 8, 15, 16, 23, 42]).style("font-size", function(d) {
						return d + "px";
					});
		});