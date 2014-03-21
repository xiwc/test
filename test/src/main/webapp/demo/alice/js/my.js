jQuery(function($) {
	// alert('OK...');

	// Alice Core

	var alicejs = alice.init(); // Is built right into alice!

	// This is why we can do ex. alicejs.wobble(); instead of
	// alice.init().wobble();

	// alicejs.wobble({
	// elems : ["DIV1", "IMG1"],
	// rotate : 5,
	// perspectiveOrigin : "center",
	// duration : "200ms",
	// timing : "linear",
	// delay : "0ms",
	// iteration : "infinite",
	// direction : "alternate",
	// playstate : "running"
	// });
	//
	// alicejs.wobble({
	// elems : "MyDiv",
	// rotation : 5,
	// perspectiveOrigin : "center",
	// duration : "200ms",
	// timing : "linear",
	// delay : "0ms",
	// iteration : "infinite",
	// direction : "alternate",
	// playstate : "running"
	// });

	var alicejsSlide = alice.init({
				workflow : true
			});
	var aces = ["DIV1", "IMG1", "MyDiv"];

	alicejsSlide.slide({
				elems : aces,
				move : "left",
				duration : {
					"value" : "1000ms",
					"randomness" : "0%",
					"offset" : "150ms"
				}
			}).delay(2000).slide({
				elems : aces,
				move : "right",
				duration : {
					"value" : "1000ms",
					"randomness" : "0%",
					"offset" : "150ms"
				}
			}).delay(2000).slide({
				elems : aces,
				move : "down",
				duration : {
					"value" : "1000ms",
					"randomness" : "0%",
					"offset" : "150ms"
				}
			}).delay(2000).slide({
				elems : aces,
				move : "up",
				duration : {
					"value" : "1000ms",
					"randomness" : "0%",
					"offset" : "150ms"
				}
			}).start();

		// All chained animations must conclude with .start(), and be separated
		// by delay(#)

	});