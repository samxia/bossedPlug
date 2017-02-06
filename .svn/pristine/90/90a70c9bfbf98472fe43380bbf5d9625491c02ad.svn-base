package com.xym.bossed.servlet.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.service.KehuService;

public class ContactDelete extends HttpServlet {

	private static final long serialVersionUID = -5100013041550431704L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		JSONObject jo = new JSONObject();

		String kehuNo = request.getParameter("kehuNo");
		if (kehuNo == null || kehuNo.isEmpty())
			return;
		KehuService ks = new KehuService();
		int rv = ks.deleteKehuByKehuNo(kehuNo);
		if (rv == 1) {
			jo.put("result", "success");
		} else {
			jo.put("result", "此联系人已使用无法删除");
			jo.put("return_code", (Integer) rv);

		}
		response.getWriter().println(jo.toString());
	}

	private JSONObject put(String string, int rv) {
		// TODO Auto-generated method stub
		return null;
	}
}
