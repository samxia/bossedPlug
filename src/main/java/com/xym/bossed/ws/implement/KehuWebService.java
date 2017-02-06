package com.xym.bossed.ws.implement;

import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.service.KehuService;
import com.xym.bossed.ws.interfaces.IKehuWebService;

@WebService(endpointInterface = "com.xym.bossed.ws.interfaces.IKehuWebService", serviceName = "KehuService")
public class KehuWebService implements IKehuWebService {

	@Override
	public String getKehuNameByKehuTelNo(String telNo) {
		KehuService ks=new KehuService();
		List<Kehu> list=ks.getKehuByTelNo(telNo);
		StringBuffer sb=new StringBuffer();
		Iterator<Kehu> it=list.iterator();
		while(it.hasNext())
		{
			Kehu kh=it.next();
			sb.append(kh.getKehuMc()).append("\n");
		}
		return sb.toString();
	}

}
