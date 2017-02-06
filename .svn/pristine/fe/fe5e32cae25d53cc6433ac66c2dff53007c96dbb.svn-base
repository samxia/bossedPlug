package com.xym.bossed.servlet.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadBlob extends HttpServlet {

	private static final long serialVersionUID = -4012896888158078424L;
	private File fileUploadPath;

	@Override
	public void init(ServletConfig config) {
		fileUploadPath = new File(config.getServletContext().getInitParameter(
				"upload_path"));
		if (!fileUploadPath.exists()) {
			fileUploadPath.mkdir();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String str_file = request.getParameter("file");
		String str_file_name = request.getParameter("filename");
		System.out.println(str_file_name);
		System.out.println(str_file);
	}
}
