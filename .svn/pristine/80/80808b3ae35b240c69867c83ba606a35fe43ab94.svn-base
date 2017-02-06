package com.xym.bossed.servlet.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.shiro.Role;
import com.xym.bossed.shiro.User;
import com.xym.bossed.shiro.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class RolesOfUserSave
 */
public class RolesOfUserSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesOfUserSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String str_user=request.getParameter("user");
		String str_roles=request.getParameter("roles");
		
		//JSON String to Bean
		JSONObject jo_user=JSONObject.fromObject(str_user);
		User user=(User)JSONObject.toBean(jo_user,User.class);
	//	System.out.println(user.getUserName());
		
		//JSON Array to Bean List
		JSONArray ja_roles=JSONArray.fromObject(str_roles);
		List<Role> roles_new=JSONArray.toList(ja_roles,Role.class);
		/*for(int i=0;i<list_role.size();i++)
		{
			Role role=(Role)list_role.get(i);
			System.out.println(role.getRoleName());
		}*/
		
		
		UserService us=new UserService();
		//get the ori roles
		List<Role> roles_old=us.getRolesByUser(user);
		
	/*	System.out.println(JSONArray.fromObject(roles_old).toString());
		System.out.println(JSONArray.fromObject(roles_new).toString());*/
		
		List<Role> roles_tobe_delete;
		List<Role> roles_tobe_insert;
		
		
		//get tobe delete roles
		//roles_old.removeAll(roles_new);
		roles_tobe_delete=removeSameObject(roles_old,roles_new);
	   
		//get tobe insert roles
		roles_tobe_insert=removeSameObject(roles_new,roles_old);
		
		JSONObject jo=new JSONObject();
		//if there is no change,return
		if(roles_tobe_delete.size()==0 && roles_tobe_insert.size()==0)
		{
			jo.put("errorMsg","No changes.");
			response.getWriter().println(jo.toString());
			return;
		}
		
		
		
		for(Role role:roles_tobe_delete)
		{
			us.deleteRolesOfUser(user, role);
		}
		for(Role role:roles_tobe_insert)
		{
			us.insertRolesOfUser(user, role);
		}
		/*System.out.println("tobe delete:"+JSONArray.fromObject(roles_tobe_delete).toString());
		System.out.println("tobe insert:"+JSONArray.fromObject(roles_tobe_insert).toString());*/
		jo.put("result","success");
		response.getWriter().println(jo.toString());
	}
    private List<Role> removeSameObject(List<Role> list1,List<Role> list2)
    {
    	List<Role> rt=new ArrayList<Role>();
    	
    	for(Role r:list1)
    	{
    		rt.add(r);
    	}
    	
    	for(int i=0;i<rt.size();i++)
    	{
    		Role role1=rt.get(i);
    		for(int j=0;j<list2.size();j++)
    		{
    			Role role2=list2.get(j);
    			if(role1.getId()==role2.getId())
    			{
    				rt.remove(i);
    			}
    		}
    	}
    	return rt;
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
