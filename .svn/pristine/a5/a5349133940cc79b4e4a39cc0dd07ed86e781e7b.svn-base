package com.xym.bossed.servlet.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.service.KehuService;

public class ContactDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String kehuNo=request.getParameter("kehuNo");
		if(kehuNo==null || kehuNo.isEmpty())
		{
			return;
		}
		KehuService ks=new KehuService();
		Kehu kehu=ks.getKehuByKehuNo(kehuNo);
		JSONObject jo=JSONObject.fromObject(kehu);
		response.getWriter().println(jo.toString());
	}
}
