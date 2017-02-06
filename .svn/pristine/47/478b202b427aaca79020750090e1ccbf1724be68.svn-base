<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page import="org.apache.shiro.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>header</title>
<style type="text/css">
#div_header {
	text-align: center;
}
</style>
</head>
<body>
	<div id="div_header">
		<h9> <shiro:guest>
Welcome!  Please <a href="<%=request.getContextPath()%>/login/login.jsp">Login</a>  today!
</shiro:guest> <shiro:user>
Hello, <shiro:principal />, how are you today?  
<a href="<%=request.getContextPath()%>/auth/">menu</a> &nbsp;<a
				href="<%=request.getContextPath()%>/logout">logout</a>
		</shiro:user> </h9>
		<h5>
		
		<% 
		org.apache.shiro.subject.Subject subject=org.apache.shiro.SecurityUtils.getSubject();
		//(com.xym.bossed.shiro.User)subject;
		%>
		</h5>
	</div>
</body>
</html>