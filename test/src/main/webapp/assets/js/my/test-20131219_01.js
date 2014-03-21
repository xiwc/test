// JavaScript Document
jQuery(function($) {
			$('.role-user-odd').each(function() {
						var tooltip = new Ext.ToolTip({
									xtype : 'tooltip',
									target : $(this).attr('id'),
									html : $(this).attr('id'),
									title : '标题'
								});
					});

		});