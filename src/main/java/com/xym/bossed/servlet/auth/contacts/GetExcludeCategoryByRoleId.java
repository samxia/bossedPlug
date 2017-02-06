package com.xym.bossed.servlet.auth.contacts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.auth.contacts.ExcludedContactsCategory;
import com.xym.bossed.service.ExcludedContactsService;

public class GetExcludeCategoryByRoleId extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		response.setCharacterEncoding("GB2312");
		
		String roleId=request.getParameter("role_id");
		if(roleId==null || roleId.trim().isEmpty())
		{
			response.getWriter().println("Fail:check param.");
			return;
		}
		ExcludedContactsService ecs=new ExcludedContactsService();
		List<ExcludedContactsCategory> list=ecs.getExcludedContactsCategoryByRoleId(Integer.valueOf(roleId));
		
		JSONObject jo=new JSONObject();
		jo.put("total", list.size());
		jo.put("rows",list);
		
		response.getWriter().println(jo.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	}

