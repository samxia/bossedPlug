<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/print/LodopFuncs.js"></script>
<title>Insert title here</title>
</head>
<body>
<a href="javascript:alert(getLodop().VERSION)">查看本机是否安装控件</a>
<p>
<a href="javascript:design()">打印设计</a><p>
<a href="javascript:setup()">打印维护</a><p>
<a href="javascript:preview()">打印预览</a>
<a href="javascript:print()">打印</a>
<script type="text/javascript">
	var LODOP=getLodop();
	function design()
	{
		LODOP.PRINT_DESIGN();
	}
	function setup()
	{
		LODOP.PRINT_SETUP();
	}
	function preview()
	{
		addTitle();
		//addFooter();
		LODOP.SET_PRINT_PAGESIZE(3,2100,45,"")
		LODOP.PREVIEW();
	}
	function print()
	{
		addTitle();
		LODOP.SET_PRINT_PAGESIZE(3,2100,45,"")
		LODOP.PRINT();
	}
	function addTitle()
	{
		LODOP.PRINT_INIT("web_sale_item"); 
		LODOP.ADD_PRINT_TEXT(16,208,424,51,"长春重汽解放商用车备品有限公司");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
		LODOP.SET_PRINT_STYLEA(0,"Horient",3);
		LODOP.SET_PRINT_STYLEA(0,"LineSpacing",4);
		LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);
	}
	function addFooter()
	{
		LODOP.ADD_PRINT_HTM(479,141,181,43,"(超文本1的HTML代码内容)");
		LODOP.SET_PRINT_STYLEA(0,"Horient",2);
		LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	}
	
</script>
</body>
&#24403;&#21069;&#39029;#38754#35201#35775#38382#22914#19979;
&#26412;
#22320#25991#20214#65292#20801#35768#21527#65311
</html>