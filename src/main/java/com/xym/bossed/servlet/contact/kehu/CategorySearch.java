package com.xym.bossed.servlet.contact.kehu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.service.KehuLeibieService;

public class CategorySearch extends HttpServlet {

	private static final long serialVersionUID = -4003257461383505258L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		KehuLeibieService ks=new KehuLeibieService();
		response.getWriter().println(ks.makeTreeData(ks.getAllLeibie()));
	}
}
