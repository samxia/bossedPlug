package com.xym.bossed.servlet.contact.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.contact.category.ContactCategory;
import com.xym.bossed.service.ContactCategoryService;

public class CategoryUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String code = request.getParameter("code");
		String name = request.getParameter("name");

		if (code == null || code.isEmpty() || name == null || name.isEmpty()) {
			return;
		}
		ContactCategory cc = new ContactCategory();
		cc.setCode(code);
		cc.setName(name);
		
		ContactCategoryService cs=new ContactCategoryService();
		response.getWriter().println(cs.update(cc));
	}

}
