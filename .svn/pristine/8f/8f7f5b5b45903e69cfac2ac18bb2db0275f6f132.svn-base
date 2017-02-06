package com.xym.bossed.servlet.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.xym.bossed.interfaces.ISecurityService;
import com.xym.bossed.security.SecurityService;

import net.sf.json.JSONObject;

public class LoginStatus extends HttpServlet {

	private static final long serialVersionUID = 116084141640859303L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject jo = new JSONObject();
		/*
		 * ISecurityService ss = new SecurityService(); String username =
		 * ss.getCurrentUsername(); jo.put("userName", username);
		 */

		Subject currentUser = SecurityUtils.getSubject();

		if (currentUser == null || currentUser.getPrincipal() == null) {
			jo.put("userName", "anonymousUser");
			response.getWriter().println(jo.toString());
			return;
		}

		String uName = currentUser.getPrincipal().toString();
		jo.put("userName", uName);
		response.getWriter().println(jo.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
