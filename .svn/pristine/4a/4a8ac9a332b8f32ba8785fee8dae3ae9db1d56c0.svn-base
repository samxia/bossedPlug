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


	public class PictureDetail extends HttpServlet {
		Logger log = Logger.getLogger(PictureList.class);

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");

			String ownerId=request.getParameter("owner_id");
			if(ownerId==null)return;
			PictureService ps=new PictureService();
			List<Picture> list=ps.getPicturesByOwnerIdInDB(ownerId);
			
			/**
			 * <table>
			 *    <tr><td>ÐòºÅ</td><td>path</td><td>pic img</td><td>del</td></tr>
			 *    <tr></tr>
			 * </table>
			 */
			StringBuffer sb=new StringBuffer();
			//<div   style="overflow:auto;width:200;height:100">
			sb.append("<div   style='overflow:auto;width:300;height:100'>");
			sb.append("<table>");
			sb.append(" <tr><td>ÐòºÅ</td><td>memo</td><td>path</td><td>img</td><td>del</td></tr>");
			for(int i=0;i<list.size();i++)
			{
				Picture pic=list.get(i);
				String memo=pic.getMemo();
				String path=pic.getPath();
				
				sb.append("<tr><td>").append(i+1).append("</td><td>");
				sb.append(memo).append("</td><td>");
				sb.append(path).append("</td><td>");
				//<img src="/i/eg_mouse.jpg" width="100" height="100">
				sb.append("<img src=\"../").append(path).append("\" width='100' height='100'>").append("</td><td>");
				
				sb.append("É¾³ý").append("</td></tr>");
			}
			sb.append("</table>");
			sb.append("</div>");
			response.getWriter().println(sb.toString());
			/*JSONArray ja=JSONArray.fromObject(list);
			response.getWriter().println(ja.toString());*/
		}

		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
		}

	}
