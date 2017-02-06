package com.xym.bossed.servlet.auth.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.auth.contacts.ExcludedContactsCategory;
import com.xym.bossed.service.ExcludedContactsService;
import com.xym.bossed.shiro.Permission;
import com.xym.bossed.shiro.Role;

public class ExcludedCategorySave extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String str_role = request.getParameter("role");
		String str_excludedCategory = request.getParameter("excludedCategory");

		//System.out.println(str_role);
		//System.out.println(str_excludedCategory);

		// JSON String to bean
		JSONObject jo_role = JSONObject.fromObject(str_role);
		Role role = (Role) JSONObject.toBean(jo_role, Role.class);

		// JSON Array to bean
		JSONArray ja_excludedCategries = JSONArray
				.fromObject(str_excludedCategory);
		List<ExcludedContactsCategory> list_excludedCategory = JSONArray
				.toList(ja_excludedCategries, ExcludedContactsCategory.class);

		//save to db
		ExcludedContactsService ecs = new ExcludedContactsService();
		List<ExcludedContactsCategory> list_excludedCategory_old=ecs.getExcludedContactsCategoryByRoleId(role.getId());
		
		List<ExcludedContactsCategory> exCates_tobe_delete=removeSameObject(list_excludedCategory_old,list_excludedCategory);
		List<ExcludedContactsCategory> exCates_tobe_insert=removeSameObject(list_excludedCategory,list_excludedCategory_old);
		
		JSONObject jo = new JSONObject();
		// if there is no change,return
		if (exCates_tobe_delete.size() == 0 && exCates_tobe_insert.size() == 0) {
			jo.put("errorMsg", "No changes.");
			response.getWriter().println(jo.toString());
			return;
		}
		
		
		for (ExcludedContactsCategory excludedCategory : exCates_tobe_delete) {
			ecs.deleteExcludedContactsCategory(excludedCategory);
		}
		for (ExcludedContactsCategory excludedCategory : exCates_tobe_insert) {
			ecs.insertExcludedContactsCategory(excludedCategory);
		}
		
		jo.put("result","success");
		response.getWriter().println(jo.toString());
	}
	private List<ExcludedContactsCategory> removeSameObject(List<ExcludedContactsCategory> list1,
			List<ExcludedContactsCategory> list2) {
		List<ExcludedContactsCategory> rt = new ArrayList<ExcludedContactsCategory>();

		for (ExcludedContactsCategory p : list1) {
			rt.add(p);
		}

		for (int i = 0; i < rt.size(); i++) {
			ExcludedContactsCategory perm1 = rt.get(i);
			for (int j = 0; j < list2.size(); j++) {
				ExcludedContactsCategory perm2 = list2.get(j);
				if (perm1.getId() == perm2.getId()) {
					rt.remove(i);
				}
			}
		}
		return rt;
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
