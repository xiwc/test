//$.holdReady(true);
jQuery(function($) {
//	$("button").click(function() {
//		$("div").each(function(index, domEle) {
//			// domEle == this
//			$(domEle).css("backgroundColor", "yellow");
//			if ($(this).is("#stop")) {
//				$("span").text("Stopped at div index #" + index);
//				return false;
//			}
//		});
//	});
	
	$('#msg').text($('div').size());
	$('#msg').text($('div').length);
});

// $.getScript("../js/my/index.js", function() {
// alert("ready1...");
// $.holdReady(false);
// });
