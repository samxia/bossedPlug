package com.xym.bossed.weixin;

import java.util.Date;
import java.util.List;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.service.KehuService;

public class WeixinService {
	public static String getResponseXMLByRcvedMsg(XMLMsgBean rcvedMsgBean) {
		return XMLService.createTextXMLFromMsgBean(createResponseTextMsgBean(
				rcvedMsgBean, getResponseContentByRcvedMsg(rcvedMsgBean)));
	}

	private static String getResponseContentByRcvedMsg(XMLMsgBean rcvedMsgBean) {
		
		//if msg type is text
		if ("text".equals(rcvedMsgBean.getMsgType())) {
			
			StringBuffer sb=new StringBuffer();
			
			String content = rcvedMsgBean.getContent();

			KehuService ks = new KehuService();

			List<Kehu> list=ks.getKehuByKehuMcOrKehuDh(content, new Kehu());
			
			int size=list.size();
			
			for(int i=0;i<size;i++)
			{
				Kehu kh=list.get(i);
				sb.append(i+1).append(".");
			    sb.append(kh.getKehuMc()).append("  ").append(kh.getKehuDh()==null?"":kh.getKehuDh().replace(" "," ~ ")).append(" ").append(kh.getKehuSj()==null?"":kh.getKehuSj());
			    sb.append("\n");
			    if(i==9)//最多显示10个联系人
			    {
			    	i=size;
			    	sb.append("\n");
			    	sb.append("符合此条件的共"+size+"位，请用更精确条件查询。");
			    }
			}
			if(size==0)
			{
				sb.append("未找到符合条件[").append(content).append("]的联系人.");
			}
			
			return sb.toString();
		} else {
			return "目前只接受文本，如有更多需求请联系13578899365";
		}
	}

	private static XMLMsgBean createResponseTextMsgBean(
			XMLMsgBean recivedMsgBean, String Content) {
		XMLMsgBean msg = new XMLMsgBean();
		msg.setToUserName(recivedMsgBean.getFromUserName());
		msg.setFromUserName(recivedMsgBean.getToUserName());
		msg.setCreateTime(String.valueOf(new Date().getTime()));
		msg.setMsgType("text");
		msg.setContent(Content);
		msg.setMsgId(" ");
		msg.setAgentID(recivedMsgBean.getAgentID());
		return msg;
	}
}
