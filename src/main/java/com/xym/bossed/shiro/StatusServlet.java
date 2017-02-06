package com.xym.bossed.shiro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class StatusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(StatusServlet.class);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated())
		{
			response.getWriter().println("No login yet.");
			return;
		}
		String userName=(String)currentUser.getPrincipal();
		log.debug("getCurrentUserStatus() principal:"+currentUser.getPrincipal());
		UserService us=new UserService();
		User user=us.getUserByName(userName);
		response.getWriter().println(user.getRoleNameList());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
