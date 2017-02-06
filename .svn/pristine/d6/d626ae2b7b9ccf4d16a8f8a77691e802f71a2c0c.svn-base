package com.xym.bossed.servlet.picture;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.xym.bossed.db.mybatis.picture.Picture;
import com.xym.bossed.service.PictureService;

public class PictureQuery extends HttpServlet {
	Logger log = Logger.getLogger(PictureList.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String ownerId=request.getParameter("owner_id");
		if(ownerId==null)return;
		PictureService ps=new PictureService();
		List<Picture> list=ps.queryDistinctPicturesByOwnerIdInDB(ownerId);
		
		JSONArray ja=JSONArray.fromObject(list);
		response.getWriter().println(ja.toString());
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}