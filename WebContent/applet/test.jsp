<HTML>
<HEAD>
<TITLE>A Simple Program </TITLE></HEAD>
<BODY>
<CENTER>
<APPLET CODE="applet.AppApplet.class" ARCHIVE = "AppApplet.jar" WIDTH="500" HEIGHT="150" id="appApplet" name="appApplet"> </APPLET>
<a href="#" onclick="openApp()">calc</a>
<script type="text/javascript">
function openApp(){
	var appApplet = document.appApplet.openApp();

}
</script>
</CENTER>
</BODY>
</HTML>