package com.xym.bossed.servlet.parts.fenlu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.parts.fenlu.PartsFenLu;
import com.xym.bossed.interfaces.IPartsFenLuService;
import com.xym.bossed.service.PartsFenLuService;
import com.xym.bossed.util.SpringUtil;

public class PartsFenLuList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100233326539497245L;

	/**
	 * 
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		String partsNo=request.getParameter("partsNo");
		if(partsNo==null||partsNo.trim().isEmpty())
		{
			return;
		}
		
		//IPartsFenLuService fs=new PartsFenLuService();
		
		IPartsFenLuService fs=(IPartsFenLuService) SpringUtil.getBean("partsFenLuService");
		
		List<PartsFenLu> list=fs.getFenLuByPartsNo(partsNo);
		JSONObject jo = new JSONObject();
		jo.put("total", list.size());
		jo.put("rows", list);
		
		response.getWriter().println(jo.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
