jQuery(function($) {

	// row01
	$('<a href="javascript:;" class="button">test01</a>').on('click', function() {
				layer.alert('一个很普通的信息框');
			}).appendTo('#row01');
	$('<a href="javascript:;" class="button">test02</a>').on('click', function() {
				layer.alert('信息框演示二', 11, !1);
			}).appendTo('#row01');
	$('<a href="javascript:;" class="button">test03</a>').on('click', function() {
				layer.confirm('信息框演示三', function(index) {
							layer.close(index);
							layer.msg('信息框演示三');
						});
			}).appendTo('#row01');
	$('<a href="javascript:;" class="button">test04</a>').on('click', function() {
				layer.msg('也可以不用显示图标哦', 2, -1);
			}).appendTo('#row01');
	$('<a href="javascript:;" class="button">test05</a>').on('click', function() {
		var i = 0;
		$.layer({
					dialog : {
						type : 0,
						msg : '点击我，换图标'
					},
					success : function(layerE) {
						$('#setface').unbind('click').bind('click', function() {
							var index = layer.getIndex(this);
							i++;
							layerE.find('.xubox_msgico').removeClass('xubox_msgtype' + (i - 1))
									.addClass('xubox_msgtype' + i);
							i > 10 && layer.close(index);
						});
					},
					end : function() {
						i = 0;
					}
				});
	}).appendTo('#row01');
	$('<a href="javascript:;" class="button">test06</a>').on('click', function() {
				layer.msg('踩到屎啦', 2, 13);
			}).appendTo('#row01');

	var panelDemoArr = [];

	panelDemoArr.push({
		title : '模块名称01',
		content : '<p>这些年我跟卓伟联系不多，但是他的每一次出手我都会欣赏到，因为这种劲爆消息躲都躲不过去。我个人对明星们的八卦甚至周围朋友的八卦都没啥兴趣，从我做记者那天起，访的时候会没话说，那样会很局促尴尬，就婉言谢绝了。</p>'
	}, {
		title : '模块名称02',
		content : '<p>还有，我前段时间写小说，里面有个人物，起名字让我想了半天，最后起了一个名字叫“吴秀波”。就在我写这个人物的命运时，我接到一个电话，对方说是吴秀波的经纪人，当时吓我一跳，我还以为把人物给写活了呢，缓过神之后才明白，有个演员名字叫吴秀波。实在是孤陋寡闻。</p>'
	}, {
		title : '模块名称03',
		content : 'xx'
	}, {
		title : '模块名称04',
		content : 'xx'
	})

	var $panelArr = $("#panelTpl").tmpl(panelDemoArr).appendTo("#content > .left");
	$panelArr.hover(function() {
				$(this).addClass("panel-container-hover");
			}, function() {
				$(this).removeClass("panel-container-hover");
			});

	$panelArr.each(function(i) {

				var $panel = $(this);

				var $tool = $('<div class="tool-container"></div>').hide().appendTo(this);
				$('<div class="tool-fullscreen"></div>').click(function() {
							if (screenfull.enabled) {
								screenfull.toggle($panel.get(0));
							} else {
							}
						}).appendTo($tool);
				$('<div class="tool-up"></div>').click(function() {
							if ($(this).hasClass('tool-up')) {
								$panel.find('.panel-content-container').hide();
							} else {
								$panel.find('.panel-content-container').show();
							}

							$(this).toggleClass("tool-up");
							$(this).toggleClass("tool-down");

						}).appendTo($tool);
				$('<div class="clear"></div>').appendTo($tool);

				$tool.children('div').hover(function() {
							$(this).addClass("tool-btn-hover");
						}, function() {
							$(this).removeClass("tool-btn-hover");
						});

				$panel.hover(function() {
							$tool.show();
						}, function() {
							$tool.hide();
						});
			});

});