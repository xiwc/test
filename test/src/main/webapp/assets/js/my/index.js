var demoArr = [];
demoArr.push({
			date : '2014/04/25',
			href : 'demo/gmap3/demo/address.html',
			text : 'demo/gmap3/demo/address.html'
		}, {
			date : '2014/04/25',
			href : 'demo/jpages/index.html',
			text : 'demo/jpages/index.html'
		}, {
			date : '2014/04/25',
			href : 'demo/tinybox2/index.html',
			text : 'demo/tinybox2/index.html'
		}, {
			date : '2014/04/24',
			href : 'demo/datepicker/index.html',
			text : 'demo/datepicker/index.html'
		}, {
			date : '2014/04/21',
			href : 'demo/turn/demos/bible/index.html',
			text : 'demo/turn/demos/bible/index.html'
		}, {
			date : '2014/04/21',
			href : 'demo/turn/demos/magazine/index.html',
			text : 'demo/turn/demos/magazine/index.html'
		}, {
			date : '2014/04/21',
			href : 'demo/turn/demos/magazine_single/index.html',
			text : 'demo/turn/demos/magazine_single/index.html'
		}, {
			date : '2014/04/17',
			href : 'demo/print/index.html',
			text : 'demo/print/index.html'
		}, {
			date : '2014/04/17',
			href : 'demo/print/index2.html',
			text : 'demo/print/index2.html'
		}, {
			date : '2014/03/05',
			href : 'demo/semantic/index.html',
			text : 'demo/semantic/index.html'
		}, {
			date : '2014/02/27',
			href : 'demo/alice/index.html',
			text : 'demo/alice/index.html'
		}, {
			date : '2014/01/26',
			href : 'demo/layer/index.html',
			text : 'demo/layer/index.html'
		}, {
			date : '2014/01/26',
			href : 'demo/ueditor/index.html',
			text : 'demo/ueditor/index.html'
		}, {
			date : '2014/02/26',
			href : 'demo/d3/index.html',
			text : 'demo/d3/index.html'
		}, {
			date : '2014/01/25',
			href : 'demo/index/index.html',
			text : 'demo/index/index.html'
		}, {
			date : '2014/01/24',
			href : 'demo/jquery-tmpl/demos/step-by-step.html',
			text : 'demo/jquery-tmpl/demos/step-by-step.html'
		}, {
			date : '2014/01/23',
			href : 'demo/timelinr/index.html',
			text : 'demo/timelinr/index.html'
		}, {
			date : '2014/01/20',
			href : 'demo/video/video.html',
			text : 'demo/video/video.html'
		}, {
			date : '2014/01/10',
			href : 'assets/page/ext-test.html',
			text : 'assets/page/ext-test.html'
		}, {
			date : '2014/01/10',
			href : 'assets/page/jquery-test.html',
			text : 'assets/page/jquery-test.html'
		});

jQuery(function($) {
			$("#indexTpl").tmpl(demoArr).appendTo("#indexListDiv");
		});