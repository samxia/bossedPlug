package com.xym.bossed.servlet.contact.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.contact.category.ContactCategory;
import com.xym.bossed.service.ContactCategoryService;

public class CategoryDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String code = request.getParameter("code");
		if(code==null || code.trim().isEmpty()) return;
		
		ContactCategoryService cs=new ContactCategoryService();
		ContactCategory cc=new ContactCategory();
		cc.setCode(code);
		
		if(cs.countByParentCode(code)>0)
		{
			response.getWriter().println("Fail:删除父类别前请先删除子类别。");
			return;
		}
		if(cs.hasUsed(cc))
		{
			response.getWriter().println("Fail:Has used this category。");
			return;
		}
		response.getWriter().println(cs.delete(cc));
	}

}
