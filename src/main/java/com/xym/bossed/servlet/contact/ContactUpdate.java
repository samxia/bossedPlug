package com.xym.bossed.servlet.contact;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.service.KehuService;
import com.xym.bossed.util.PinYin;

public class ContactUpdate extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8846873140936378961L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Kehu kh = this.wireParam(request);
		if (kh.getKehuNo() == null || kh.getKehuNo().isEmpty()) {
			return;
		}

		KehuService ks = new KehuService();
		JSONObject jo = new JSONObject();

		//start update
		if(kh.getKehuMc()!=null)
		{
			kh.setKehuDp(PinYin.getPinYinHeadChar(kh.getKehuMc()));
		}
		if(kh.getKehuXm()!=null)
		{
			kh.setKehuLp(PinYin.getPinYinHeadChar(kh.getKehuXm()));
		}
		int rst = ks.updateKehuByKehuNo(kh);
		
		if(rst!=1)
		{
			jo.put("Fail","Update Error,code"+rst);
			response.getWriter().println(jo.toString());
			return;
		}
		jo.put("success",kh.getKehuNo());
		response.getWriter().println(jo.toString());
		
	}

	private Kehu wireParam(HttpServletRequest request) {
		/**
		 * handle the request parameter.
		 */
		Enumeration enu = request.getParameterNames();
		/**
		 * wired para into kehu object
		 */
		Kehu kh = new Kehu();
		while (enu.hasMoreElements()) {
			String param = String.valueOf(enu.nextElement());
			String val = request.getParameter(param);

			if (val != null && !val.trim().isEmpty()) {
				/**
				 * String name = ¡°yaronspace¡±; name =
				 * name.substring(0,1).toUpperCase() + name.substring(1);
				 */
				// System.out.println(param+":"+val);
				if (param.equalsIgnoreCase("kehuXz")) {
					kh.setKehuXz(Short.valueOf(val));
				} else {
					try {

						kh.getClass()
								.getMethod(
										"set"
												+ param.substring(0, 1)
														.toUpperCase()
												+ param.substring(1),
										new Class[] { String.class })
								.invoke(kh, request.getParameter(param));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// System.out.println(kh.getKehuNo());
			}
		}
		return kh;
	}
}
