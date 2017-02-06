$.extend(
		$.fn.datagrid.defaults.editors,
				{//add ondblclick function
					x_text: {
						init : function(container, options) {
							var input = $(
									'<input type="text" class="datagrid-editable-input" onkeydown='+options.onkeydown+' ondblclick='+options.ondblclick+'>')
									.appendTo(container);
							//alert(options.ondblclick);
							return input;
						},
						destroy : function(target) {
							$(target).remove();
						},
						getValue : function(target) {
							return $(target).val();
						},
						setValue : function(target, value) {
							$(target).val(value);
						},
						resize : function(target, width) {
							$(target)._outerWidth(width);
						}
					}
				});
