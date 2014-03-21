/*
* Script from NETTUTS.com [by James Padolsey]
* Download by http://www.codefans.net
* @requires jQuery($), jQuery UI & sortable/draggable UI modules
*/

var iSmartAbleWidget = {

    jQuery: $,
    settings: {
        columns: '.column',
        widgetSelector: '.widget',
        handleSelector: '.widget-head',
        contentSelector: '.widget-content',
        widgetDefault: {
            movable: true,
            removable: true,
            collapsible: true,
            editable: true,
            colorClasses: ['color-yellow', 'color-red', 'color-blue', 'color-white', 'color-orange', 'color-green', 'color-gray', 'color-burlywood']
        },
        widgetIndividual: {
            intro: {
                movable: false,
                removable: false,
                collapsible: false,
                editable: false
            }
        }
    },

    init: function() {
        this.attachStylesheet('iSmartAbleWidget.js.css');
        this.addWidgetControls();
        this.makeSortable();
    },

    getWidgetSettings: function(id) {
        var $ = this.jQuery,
            settings = this.settings;
        return (id && settings.widgetIndividual[id]) ? $.extend({}, settings.widgetDefault, settings.widgetIndividual[id]) : settings.widgetDefault;
    },

    addWidgetControls: function() {
        var iSmartAbleWidget = this,
            $ = this.jQuery,
            settings = this.settings;

        $(settings.widgetSelector, $(settings.columns)).each(function() {
            var thisWidgetSettings = iSmartAbleWidget.getWidgetSettings(this.id);
            if (thisWidgetSettings.removable) {
                $('<a href="#" class="remove">关闭</a>').mousedown(function(e) {
                    e.stopPropagation();
                }).click(function() {
                    if (confirm('此部件将被移除, 是否继续?')) {
                        $(this).parents(settings.widgetSelector).animate({
                            opacity: 0
                        }, function() {
                            $(this).wrap('<div/>').parent().slideUp(function() {
                                $(this).remove();
                            });
                        });
                    }
                    return false;
                }).appendTo($(settings.handleSelector, this));
            }

            if (thisWidgetSettings.editable) {
                $('<a href="#" class="edit">编辑</a>').mousedown(function(e) {
                    e.stopPropagation();
                }).click(function() {
                    if ($(this).data('edit-status') == 'show')
                        $(this).data('edit-status', 'hide').css({ backgroundPosition: '', width: '' }).parents(settings.widgetSelector).find('.edit-box').hide(500);
                    else
                        $(this).data('edit-status', 'show').css({ backgroundPosition: '-66px 0', width: '55px' }).parents(settings.widgetSelector).find('.edit-box').show(500).find('input').focus();
                }).appendTo($(settings.handleSelector, this));

                var EditBoxObj = $('<div class="edit-box" style="display:none;"/>');
                EditBoxObj.append('<ul><li class="item"><label>修改标题</label><input value="' + $.trim($('h3', this).text()) + '"/></li>').append((function() {
                    var colorList = '<li class="item"><label>可用颜色:</label><ul class="colors">';
                    $(thisWidgetSettings.colorClasses).each(function() {
                        colorList += '<li class="' + this + '" title="' + this.split('-')[1] + '"/>';
                    });
                    return colorList + '</ul>';
                })()).append('</ul>').insertAfter($(settings.handleSelector, this));
                EditBoxObj.width(EditBoxObj.prev().width());
            }

            if (thisWidgetSettings.collapsible) {
                $('<a href="#" class="collapse">收缩</a>').mousedown(function(e) {
                    e.stopPropagation();
                }).click(function() {
                    if ($(this).data('collapse-status') == 'show')
                        $(this).data('collapse-status', 'hide').css({ backgroundPosition: '-52px 0' }).blur().parents(settings.widgetSelector).find(settings.contentSelector).show(500);
                    else
                        $(this).data('collapse-status', 'show').css({ backgroundPosition: '-38px 0' }).blur().parents(settings.widgetSelector).find(settings.contentSelector).hide(500);
                }).prependTo($(settings.handleSelector, this));
            }
        });

        $('.edit-box').each(function() {
            $('input', this).keyup(function() {
                $(this).parents(settings.widgetSelector).find('h3').text($(this).val().length > 20 ? $(this).val().substr(0, 20) + '...' : $(this).val());
            });
            $('ul.colors li', this).click(function() {

                var colorStylePattern = /\bcolor-[\w]{1,}\b/,
                    thisWidgetColorClass = $(this).parents(settings.widgetSelector).attr('class').match(colorStylePattern)
                if (thisWidgetColorClass) {
                    $(this).parents(settings.widgetSelector).removeClass(thisWidgetColorClass[0]).addClass($(this).attr('class').match(colorStylePattern)[0]);
                }
                return false;

            });
        });

    },

    attachStylesheet: function(href) {
        var $ = this.jQuery;
        return $('<link href="' + href + '" rel="stylesheet" type="text/css" />').appendTo('head');
    },

    makeSortable: function() {
        var iSmartAbleWidget = this,
            $ = this.jQuery,
            settings = this.settings,
            $sortableItems = (function() {
                var notSortable = '';
                $(settings.widgetSelector, $(settings.columns)).each(function(i) {
                    if (!iSmartAbleWidget.getWidgetSettings(this.id).movable) {
                        if (!this.id) {
                            this.id = 'widget-no-id-' + i;
                        }
                        notSortable += ',#' + this.id;
                    }
                });
                if (notSortable.length > 0) { notSortable = notSortable.substring(1); }
                return $('> li:not(' + notSortable + ')', settings.columns);
            })();

        $sortableItems.find(settings.handleSelector).css({
            cursor: 'move'
        }).mousedown(function(e) {
            $sortableItems.css({ width: '' });
            $(this).parent().css({
                width: $(this).parent().width() + 'px'
            });
        }).mouseup(function() {
            if ($(this).parent().hasClass('dragging')) {
                $(settings.columns).sortable('disable');
            } else {
                $(this).parent().css({ width: '' });
            }
        });

        $(settings.columns).sortable({
            items: $sortableItems,
            connectWith: $(settings.columns),
            handle: settings.handleSelector,
            placeholder: 'widget-placeholder',
            forcePlaceholderSize: true,
            revert: 300,
            delay: 100,
            opacity: 0.8,
            containment: 'document',
            start: function(e, ui) {
                $(ui.helper).addClass('dragging');
            },
            stop: function(e, ui) {
                $(ui.item).css({ width: '' }).removeClass('dragging');
                $(settings.columns).sortable('enable');
            }
        });
    }

};

iSmartAbleWidget.init();