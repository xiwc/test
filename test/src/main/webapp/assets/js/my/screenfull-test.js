jQuery(function($) {
	// if (screenfull.enabled) {
	// screenfull.request();
	// }

	document.getElementById('button').addEventListener('click', function() {
		if (screenfull.enabled) {
			screenfull.request();
		} else {
			// Ignore or do something else
		}
	});
	
//	var elem = document.getElementById('target');
//	document.getElementById('button').addEventListener('click', function () {
//	    if (screenfull.enabled) {
//	        screenfull.request(elem);
//	    }
//	});
	
	var target = $('#target')[0]; // Get DOM element from jQuery collection
	$('#button').click(function () {
	    if (screenfull.enabled) {
	        screenfull.request(target);
	    }
	});
	
	$('img').click(function () {
	    if (screenfull.enabled) {
	        // We can use `this` since we want the clicked element
	        screenfull.toggle(this);
	    }
	});
	
	if (screenfull.enabled) {
	    document.addEventListener(screenfull.raw.fullscreenchange, function () {
	        console.log('Am I fullscreen? ' + (screenfull.isFullscreen ? 'Yes' : 'No'));
	    });
	}
});
