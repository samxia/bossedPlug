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
			    if(i==9)//�����ʾ10����ϵ��
			    {
			    	i=size;
			    	sb.append("\n");
			    	sb.append("���ϴ������Ĺ�"+size+"λ�����ø���ȷ������ѯ��");
			    }
			}
			if(size==0)
			{
				sb.append("δ�ҵ���������[").append(content).append("]����ϵ��.");
			}
			
			return sb.toString();
		} else {
			return "Ŀǰֻ�����ı������и�����������ϵ13578899365";
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
