package com.xym.bossed.servlet.parts.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.service.PartsCategoryService;

public class PartsCategorySearch extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4006138573944673721L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		PartsCategoryService pcs=new PartsCategoryService();
		response.getWriter().println(pcs.makeTreeData(pcs.getAllCategory()));
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
