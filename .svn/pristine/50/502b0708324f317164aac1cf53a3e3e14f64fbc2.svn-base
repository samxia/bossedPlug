package com.xym.bossed.servlet.contact.gys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.service.GongYSLeibieService;

public class CategorySearch extends HttpServlet{

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		GongYSLeibieService ks=new GongYSLeibieService();
		response.getWriter().println(ks.makeTreeData(ks.getAllLeibie()));
	}
}
