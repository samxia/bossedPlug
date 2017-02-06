package com.xym.bossed.servlet.contact;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.service.KehuService;
import com.xym.bossed.util.PinYin;

public class ContactCreate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3625434553895400862L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.check the bianma 2.check the tel no. 3.save
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Kehu kh=this.wireParam(request);
		if (kh == null || kh.getKehuNo() == null || kh.getKehuDh() == null
				|| kh.getKehuMc() == null) {
			return;
		}
		// check the kehuno if has existed
		KehuService ks = new KehuService();
		JSONObject jo = new JSONObject();
		
		if (ks.existKehuNo(kh.getKehuNo())) {
			jo.put("Fail", "此客户编号已经存在");
			jo.put("kehuNo", kh.getKehuNo());
			response.getWriter().println(jo.toString());
			return;
		}
		// check the tel no.
		String kehuDh=kh.getKehuDh();
		String[] arr_dh=kehuDh.split(" ");
		for(int i=0;i<arr_dh.length;i++)
		{
			if(!arr_dh[i].trim().isEmpty())
			{
				List<Kehu> list_kehu=ks.getKehuByTelNo(arr_dh[i]);
				if(list_kehu.size()>0)//exist this no. in the db.
				{
					jo.put("Fail", "此电话号码已经存在:"+arr_dh[i]);
					jo.put("kehuNo", list_kehu.get(0).getKehuNo());
					response.getWriter().println(jo.toString());
					return;
				}
			}
		}
		//start save
		if(kh.getKehuMc()!=null)
		{
			kh.setKehuDp(PinYin.getPinYinHeadChar(kh.getKehuMc()));
		}
		if(kh.getKehuXm()!=null)
		{
			kh.setKehuLp(PinYin.getPinYinHeadChar(kh.getKehuXm()));
		}
		kh.setKehuDj(new Date());
		kh.setKehuXz((short) 3);//3 is not a bossed xingzhi.
		int rst=ks.saveKehu(kh);
		if(rst!=1)
		{
			jo.put("Fail","Insert Error,code"+rst);
			response.getWriter().println(jo.toString());
			return;
		}
		jo.put("success",kh.getKehuNo());
		response.getWriter().println(jo.toString());

	}
	private Kehu wireParam(HttpServletRequest request)
	{
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
				 * String name = “yaronspace”; name =
				 * name.substring(0,1).toUpperCase() + name.substring(1);
				 */
				// System.out.println(param+":"+val);
				try {
					kh.getClass()
							.getMethod(
									"set" + param.substring(0, 1).toUpperCase()
											+ param.substring(1),
									new Class[] { String.class })
							.invoke(kh, request.getParameter(param));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println(kh.getKehuNo());
			}
		}
		return kh;
	}
}
