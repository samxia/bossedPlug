package com.xym.bossed.servlet.jiesuan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.jiesuan.JieSuanDAO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class JieSuanList
 */
public class JieSuanList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JieSuanList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		response.getWriter().println(JSONArray.fromObject(new JieSuanDAO().getAllJieSuan()).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
