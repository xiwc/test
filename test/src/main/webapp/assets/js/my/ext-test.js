Ext.onReady(function() {
			// Ext.Msg.alert("提示", "ready...");

			var grid = new Ext.grid.GridPanel({
						store : new Ext.data.Store({
							autoDestroy : true
								// reader : reader,
								// data : xg.dummyData
							}),
						colModel : new Ext.grid.ColumnModel({
									defaults : {
										width : 120,
										sortable : true
									},
									columns : [{
												id : 'company',
												header : 'Company',
												width : 200,
												sortable : true,
												dataIndex : 'company'
											}, {
												header : 'Price',
												renderer : Ext.util.Format.usMoney,
												dataIndex : 'price'
											}, {
												header : 'Change',
												dataIndex : 'change'
											}, {
												header : '% Change',
												dataIndex : 'pctChange'
											}, {
												header : 'Last Updated',
												width : 135,
												dataIndex : 'lastChange',
												xtype : 'datecolumn',
												format : 'M d, Y'
											}]
								}),
						viewConfig : {
							forceFit : true
						},
						sm : new Ext.grid.RowSelectionModel({
									singleSelect : true
								}),
						width : 600,
						height : 300,
						frame : true,
						title : 'Framed with Row Selection and Horizontal Scrolling',
						iconCls : 'icon-grid'
					});
			var win = new Ext.Window({
						title : 'sssss',
						width : 200,
						height : 200,
						layout : 'fit',
						items : [grid],
						maximizable : true
					});

			win.show();

		});