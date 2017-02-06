function onSelectFromTree(node) {
	var id=node.id;
	switch(id)
	{
	case "bossed":
		return;
		break;
	case "kehu":
		return;
		break;
	case "gys":
		return;
		break;
	case "unbossed":
		return;
		break;
	default:
		var mc=$('#search_box').searchbox('textbox')[0].value;
	    if(mc.indexOf("可搜索")!=-1)
	    {
	    	//mc=" ";
	    	mc=" ";
	    }
		doSearch(mc,id);
	}
}

function onContextMenuFromTree(e, node) {
	e.preventDefault();
}