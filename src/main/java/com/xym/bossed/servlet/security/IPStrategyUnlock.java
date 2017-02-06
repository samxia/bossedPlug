package com.xym.bossed.servlet.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.shiro.ipSecurity.IPStrategy;

public class IPStrategyUnlock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GB2312");
		response.setCharacterEncoding("GB2312");
		response.setContentType("text/html");
		
		StringBuffer help=new StringBuffer();
		
		help.append("<h2>Usage</h2>");
		help.append("1.?unlockip=127.0.0.1     Unlock ip.<br/>");
		help.append("2.?type=show     Show the record in ip strategy map.<br/>");
		help.append("3.?type=clear    Clear the ip strategy map.<br/>");
		help.append("<hr>");
		
		response.getWriter().println(help.toString());
		
		String ip = request.getParameter("unlockip");
		if (ip != null && !ip.trim().isEmpty()) {
			new IPStrategy().unlockIP(ip);
			response.getWriter().println("Unlocked ip:" + ip);
		}
		
		String type=request.getParameter("type");
		if(type!=null&&type.equalsIgnoreCase("show"))
		{
			response.getWriter().println(new IPStrategy().printIPStrategyTable());
		}
		if(type!=null&&type.equalsIgnoreCase("clear"))
		{
			new IPStrategy().unlockAll();
			response.getWriter().println("Unlocked ALL IPs");
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
