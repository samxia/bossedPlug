package com.xym.bossed.weixin;

import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLService {
	public static void main(String[] ars) {

		String XMLData = "<xml><ToUserName><![CDATA[wx82e1f6c6daaacec1]]></ToUserName>"
				+ "<FromUserName><![CDATA[xiayueming]]></FromUserName>"
				+ "<CreateTime>1450489002</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[qq]]></Content>"
				+ "<MsgId>4441092107863588883</MsgId>"
				+ "<AgentID>5</AgentID>"
				+ "</xml>";

		System.out.println(new Date().getTime());
		// getXMLBeanFromXML(XMLData);
		//createTextXMLFromMsgBean(null);
	}

	public static XMLMsgBean getXMLBeanFromXML(String XMLData) {

		Document document = null;
		try {
			document = DocumentHelper.parseText(XMLData);
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		Element rootElm = document.getRootElement();
		// System.out.println(rootElm.elementText("FromUserName"));

		XMLMsgBean msgBean = new XMLMsgBean();
		msgBean.setToUserName(rootElm.elementText("ToUserName"));
		msgBean.setFromUserName(rootElm.elementText("FromUserName"));
		msgBean.setCreateTime(rootElm.elementText("CreateTime"));
		msgBean.setMsgType(rootElm.elementText("MsgType"));
		msgBean.setContent(rootElm.elementText("Content"));
		msgBean.setMsgId(rootElm.elementText("MsgId"));
		msgBean.setAgentID(rootElm.elementText("AgentID"));
		msgBean.setFormat(rootElm.elementText("Format"));
		msgBean.setMediaId(rootElm.elementText("MediaId"));
		msgBean.setRecognition(rootElm.elementText("Recognition"));

		return msgBean;
	}

	public static String createTextXMLFromMsgBean(XMLMsgBean msgBean) {
		/**
		 * <xml> <ToUserName><![CDATA[mycreate]]></ToUserName>
		 * <FromUserName><![CDATA[wx5823bf96d3bd56c7]]></FromUserName>
		 * <CreateTime>1348831860</CreateTime>
		 * <MsgType><![CDATA[text]]></MsgType> <Content><![CDATA[this is a
		 * test]]></Content> <MsgId>1234567890123456</MsgId>
		 * <AgentID>128</AgentID> </xml>
		 */
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("xml");// 创建根节点
		root.addElement("ToUserName").addCDATA(msgBean.getToUserName());
		root.addElement("FromUserName").addCDATA(msgBean.getFromUserName());
		root.addElement("CreateTime").addText(msgBean.getCreateTime());

		root.addElement("MsgType").addCDATA(msgBean.getMsgType());
		root.addElement("Content").addCDATA(msgBean.getContent());
		root.addElement("MsgId").addText(msgBean.getMsgId());
		root.addElement("AgentID").addText(msgBean.getAgentID());

		//System.out.println(document.asXML().substring(39));
		return document.asXML().substring(39);
	}
}
