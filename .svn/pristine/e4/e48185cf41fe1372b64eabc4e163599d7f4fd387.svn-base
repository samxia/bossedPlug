package com.xym.bossed.weixin;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.weixin.aes.AesException;
import com.xym.bossed.weixin.aes.WXBizMsgCrypt;



public class WeixinVerify extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 725585978455405648L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("GBK");
		//response.setContentType("text/html;charset=GBK");
		
		String sToken = "YDDPjK6mg";
		String sCorpID = "wx82e1f6c6daaacec1";
		String sEncodingAESKey = "qxTljYjDkg7JshS7tbyNm3aTDi8em7ODtgjlzr7sCBu";
		WXBizMsgCrypt wxcpt=null;
	
	
		
		String msgSignature = URLDecoder.decode( request.getParameter("msg_signature"),"UTF-8");
		String timeStamp = URLDecoder.decode( request.getParameter("timestamp"),"UTF-8");
		String nonce =  URLDecoder.decode(request.getParameter("nonce"),"UTF-8");
		String echoStr = URLDecoder.decode( request.getParameter("echostr"),"UTF-8");
		
		try {
			wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			String rtEchoStr=wxcpt.VerifyURL(msgSignature, timeStamp, nonce, echoStr);
			System.out.println(rtEchoStr);
			response.getWriter().print(rtEchoStr);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().println("hi,weixina");
	}

}