var demoArr = [];
demoArr.push({
			date : '2014/01/10',
			href : 'assets/page/ext-test.html',
			text : 'assets/page/ext-test.html'
		}, {
			date : '2014/01/10',
			href : 'assets/page/jquery-test.html',
			text : 'assets/page/jquery-test.html'
		}, {
			date : '2014/01/20',
			href : 'demo/video/video.html',
			text : 'demo/video/video.html'
		}, {
			date : '2014/01/23',
			href : 'demo/timelinr/index.html',
			text : 'demo/timelinr/index.html'
		}, {
			date : '2014/01/24',
			href : 'demo/jquery-tmpl/demos/step-by-step.html',
			text : 'demo/jquery-tmpl/demos/step-by-step.html'
		}, {
			date : '2014/01/25',
			href : 'demo/index/index.html',
			text : 'demo/index/index.html'
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
			date : '2014/02/27',
			href : 'demo/alice/index.html',
			text : 'demo/alice/index.html'
		}, {
			date : '2014/03/05',
			href : 'demo/semantic/index.html',
			text : 'demo/semantic/index.html'
		});

jQuery(function($) {
			$("#indexTpl").tmpl(demoArr).appendTo("#indexListDiv");
		});