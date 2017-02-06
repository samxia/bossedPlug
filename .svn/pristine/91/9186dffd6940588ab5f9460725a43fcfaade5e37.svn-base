<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/print/jquery.jqprint.js"></script>
<title>jqprint demo</title>
</head>
<body>
	<div class="my_show">这个打印时是显示的</div>
	<div class="my_hidden">这个打印时是隐藏的。</div>
	<input type="button" id="print" name="print"></input>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#print").click(function() {
				$(".my_show").jqprint();
			})
		});
	</script>
</body>
</html>