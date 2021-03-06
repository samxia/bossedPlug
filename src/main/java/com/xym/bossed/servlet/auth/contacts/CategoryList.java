package com.xym.bossed.servlet.auth.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.auth.contacts.ExcludedContactsCategory;
import com.xym.bossed.service.ExcludedContactsService;

public class CategoryList extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ExcludedContactsService ecs=new ExcludedContactsService();
		List<String> cataList=ecs.getAllContactsCatagory();
		
		List<ExcludedContactsCategory> list=new ArrayList<ExcludedContactsCategory>();
		for(String cate:cataList)
		{
			ExcludedContactsCategory ecc= new ExcludedContactsCategory();
			ecc.setCategoryName(cate);
			list.add(ecc);
		}
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
