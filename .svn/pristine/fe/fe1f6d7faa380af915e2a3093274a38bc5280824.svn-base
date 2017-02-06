package com.xym.bossed.servlet.cache;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.service.CacheService;

public class RefreshCache extends HttpServlet {

	
	private static final long serialVersionUID = -5040151141178237550L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		String[] types=new String[]{"contact","cangku"};
		String type=request.getParameter("type");
		StringBuffer sb_output=new StringBuffer();
		CacheService cs=new CacheService();
		
		if(type!=null&&type.equals("contact"))
		{
			cs.refreshCacheForContacts();
			sb_output.append("<h1>Refreshed Contact Cache</h1>");
		}
		
		sb_output.append("<br>Please select refreshCache type:");
		for(int i=0;i<types.length;i++)
		{
			
			sb_output.append("<p><li><a href='/cache/refresh?type='"+types[i]+">"+types[i]+"</a>");
		}
		response.getWriter().println(sb_output.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
	}

}
