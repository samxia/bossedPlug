package com.xym.bossed.servlet.auth;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.realm.RealmDAO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PermissionGroupNameList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8707027123482331304L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

        RealmDAO dao=new RealmDAO();
       List<String> groupNames= dao.selectDistinctGroupNameForPermission();
       
        JSONArray ja=new JSONArray();
        for(int i=0;i<groupNames.size();i++)
        {
        	 JSONObject jo=new JSONObject();
        	 jo.put("groupName", groupNames.get(i));
        	 ja.add(jo);
        }
        
        response.getWriter().println(ja.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}



}
