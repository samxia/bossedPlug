package com.xym.bossed.servlet.picture;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.xym.bossed.db.mybatis.log.Log;
import com.xym.bossed.db.mybatis.picture.Picture;
import com.xym.bossed.security.SecurityService;
import com.xym.bossed.service.LogService;
import com.xym.bossed.service.PictureService;
import com.xym.bossed.util.DateUtil;

public class PictureCreate extends HttpServlet {
	Logger log = Logger.getLogger(PictureCreate.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		final long MAX_SIZE = 3 * 1024 * 1024;// 设置上传文件最大为 3M

		final String[] allowedExt = new String[] { "jpg", "jpeg", "gif", "png",
				"doc", "docx", "mp3", "wma", "m4a" };// 允许上传的文件格式的列表

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String ownerId = null, ownerName = null, path = null,memo=null;

		ownerId = request.getParameter("owner_id");
		ownerName = request.getParameter("owner_name");
		memo =URLDecoder.decode(request.getParameter("memo"),"UTF-8");
		
		if (ownerId == null || ownerId.isEmpty() || ownerName == null
				|| ownerName.isEmpty()) {
            response.getWriter().println("args:ownerId["+ownerId+"]ownerName["+ownerName+"]memo["+memo+"]");
			return;
		}
		if (!ServletFileUpload.isMultipartContent(request)) {
			response.getWriter()
					.println(
							"Request is not multipart, please 'multipart/form-data' enctype for your form.");
			return;
		}


		// 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(4096 * 1024 * 1024);// 设置上传文件时用于临时存放文件的内存大小,这里是4K*1024*1024.多于的部分将临时存在硬盘
		dfif.setRepository(new File(request.getRealPath("/")
				+ "/picture/temp"));// 设置存放临时文件的目录,web根目录下的picture_temp目录

		ServletFileUpload servletFileUpload = new ServletFileUpload(dfif);
		servletFileUpload.setSizeMax(MAX_SIZE);
		String str_real_path = request.getRealPath("/");
		String str_folder = "/picture/files/"
				+ (ownerName == null ? "" : ownerName) + "/";
		List<FileItem> items;
		try {
			items = servletFileUpload.parseRequest(request);
		} catch (Exception e) {
			// 处理文件尺寸过大异常
			if (e instanceof SizeLimitExceededException) {
				response.getWriter().println(
						"文件尺寸超过规定大小:" + MAX_SIZE + "字节<p />");
				return;
			}
			response.getWriter().println(e.getMessage());
			return;
		}
		for (FileItem fileItem : items) {
			if (!fileItem.isFormField()) {

				for (int i = 0;; i++) {
					path = str_folder + (ownerId == null ? "" : ownerId) + "_"
							+ i + "." + this.getSuffix(fileItem.getName());
					if (!new File(str_real_path + path).exists()) {
						break;
					}
				}

				LogService logService=new LogService();
				
				// check if the folder is existed,if no,create it
				if (!new File(str_real_path + str_folder).exists()) {
					new File(str_real_path + str_folder).mkdirs();
					logService.createLog(new Log("web_picture",new SecurityService().getCurrentUsername(),"createFolder",DateUtil.long2Date(new File(str_real_path + str_folder).lastModified()),str_real_path+str_folder,"success"));
				}
				//save the uploaded file to server
				try {
					fileItem.write(new File(str_real_path + path));
					logService.createLog(new Log("web_picture",new SecurityService().getCurrentUsername(),"createFile",DateUtil.long2Date(new File(str_real_path + path).lastModified()),str_real_path + path,"success"));
				} catch (Exception e) {
					response.getWriter().println("Fail:"+e.getMessage());
					return;
				}
				
				log.debug("save pic:"+str_real_path + path);
				
				/**
				 * save the info to DB
				 */
				if (ownerId == null || ownerName == null || path == null) {
					response.getWriter().println(
							"Fail:args is not full.file is uploaded:"
									+ str_real_path + path);
					return;
				}
				
				
				Picture pic = new Picture();
				pic.setOwnerId(ownerId);
				pic.setOwnerName(ownerName);
				pic.setPath(path);
				pic.setMemo(memo);
				pic.setUpdateUser(new SecurityService().getCurrentUsername());
				PictureService ps = new PictureService();
				ps.createPictureInDB(pic);
				
				response.getWriter().println(
						"success:"
								+ str_real_path + path);
			}
		}

	}

	private String getSuffix(String filename) {
		String suffix = "";
		int pos = filename.lastIndexOf('.');
		if (pos > 0 && pos < filename.length() - 1) {
			suffix = filename.substring(pos + 1);
		}
		// System.out.println("suffix: " + suffix);
		return suffix;
	}
}
