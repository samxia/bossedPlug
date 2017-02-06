package com.xym.bossed.weixin;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.log.Log;
import com.xym.bossed.service.LogService;
import com.xym.bossed.util.DateUtil;
import com.xym.bossed.weixin.aes.AesException;
import com.xym.bossed.weixin.aes.WXBizMsgCrypt;

public class Weixin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 725585978455405648L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Get method for verifing the url , in case unexpected access, so check
		// first.
		if (request.getParameter("msg_signature") == null
				|| request.getParameter("timestamp") == null
				|| request.getParameter("nonce") == null
				|| request.getParameter("echostr") == null) {
			response.getWriter().println("ok");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		// response.setCharacterEncoding("GBK");
		// response.setContentType("text/html;charset=GBK");

		String sToken = "YDDPjK6mg";
		String sCorpID = "wx82e1f6c6daaacec1";
		String sEncodingAESKey = "qxTljYjDkg7JshS7tbyNm3aTDi8em7ODtgjlzr7sCBu";
		WXBizMsgCrypt wxcpt = null;

		String msgSignature = URLDecoder.decode(
				request.getParameter("msg_signature"), "UTF-8");
		String timeStamp = URLDecoder.decode(request.getParameter("timestamp"),
				"UTF-8");
		String nonce = URLDecoder
				.decode(request.getParameter("nonce"), "UTF-8");
		String echoStr = URLDecoder.decode(request.getParameter("echostr"),
				"UTF-8");

		try {
			wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			String rtEchoStr = wxcpt.VerifyURL(msgSignature, timeStamp, nonce,
					echoStr);
			System.out.println(rtEchoStr);
			response.getWriter().print(rtEchoStr);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String TOKEN = "YDDPjK6mg";
		String CORPID = "wx82e1f6c6daaacec1";
		String ENCODINGAESKEY = "qxTljYjDkg7JshS7tbyNm3aTDi8em7ODtgjlzr7sCBu";
		WXBizMsgCrypt wxcpt = null;

		/*
		 * Enumeration<String> list=request.getParameterNames();
		 * 
		 * while(list.hasMoreElements()) {
		 * System.out.println(list.nextElement());
		 * 
		 * }
		 */
		String sMsgSignature = request.getParameter("msg_signature");
		String sTimestamp = request.getParameter("timestamp");
		String sNonce = request.getParameter("nonce");

		/*
		 * read xml
		 */
		ServletInputStream sis = request.getInputStream();
		int length = request.getContentLength();
		// 用于缓存每次读取的数据
		byte[] buffer = new byte[length];
		// 用于存放结果的数组
		byte[] xmldataByte = new byte[length];

		int count = 0;
		int rbyte = 0;

		// 循环读取
		while (count < length) {
			// 每次实际读取长度存于rbyte中
			rbyte = sis.read(buffer);
			for (int i = 0; i < rbyte; i++) {
				xmldataByte[count + i] = buffer[i];
			}
			count += rbyte;
		}

		String xmlData = new String(xmldataByte);
		String strDecryptXml = "";
		try {
			wxcpt = new WXBizMsgCrypt(TOKEN, ENCODINGAESKEY, CORPID);

			strDecryptXml = wxcpt.DecryptMsg(sMsgSignature, sTimestamp, sNonce,
					xmlData);
		} catch (AesException e) {
			e.printStackTrace();
		}

		// System.out.println(strDecryptXml);
		XMLMsgBean xml = XMLService.getXMLBeanFromXML(strDecryptXml);

	//	System.out.println(xml.getContent());

		String sRespText = "";
		try {
			sRespText = wxcpt.EncryptMsg(
					WeixinService.getResponseXMLByRcvedMsg(xml), sTimestamp,
					sNonce);
		} catch (AesException e) {
			e.printStackTrace();
		}
		response.getWriter().print(sRespText);

		//log to db
		LogService ls=new LogService();
		ls.createLog(new Log("weixin_query_contacts",xml.getFromUserName(),"queryContacts",DateUtil.long2Date(new Date().getTime()), xml.getContent(), ""));
		
		/*
		 * if("text".equals(xml.getMsgType())) {
		 * 
		 * String sRespData="<xml>"+
		 * "<ToUserName><![CDATA[xiayueming]]></ToUserName>"+
		 * "<FromUserName><![CDATA[wx82e1f6c6daaacec1]]></FromUserName>"+
		 * "<CreateTime>1450489159</CreateTime>"+
		 * "<MsgType><![CDATA[text]]></MsgType>"+
		 * "<Content><![CDATA[this is a test]]></Content>"+ "<MsgId></MsgId>"+
		 * "<AgentID>5</AgentID>"+ "</xml>";
		 * 
		 * 
		 * try { String sRespText=wxcpt.EncryptMsg(sRespData, sTimestamp,
		 * sNonce); response.getWriter().print(sRespText);
		 * 
		 * } catch (AesException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * }
		 */

		// response.getWriter().print("");

	}

}