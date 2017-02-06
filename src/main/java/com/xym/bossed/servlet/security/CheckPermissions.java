package com.xym.bossed.servlet.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.xym.bossed.shiro.Permission;

public class CheckPermissions extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String para=request.getParameter("perms");
		if(para==null||para.trim().isEmpty())
		{
			return;
		}
		JSONObject jo_para = JSONObject.fromObject(para);
		String[] perms=( String[])JSONObject.toBean(jo_para, String[].class);
		
		Subject subject = SecurityUtils.getSubject();
		//String[] perms = { "contacts:create", "contacts:delete", "auth" };
		boolean[] result = subject.isPermitted(perms);
		
		JSONObject jo=new JSONObject();
		jo.put("result", result);
		
		response.getWriter().println(jo.toString());

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
