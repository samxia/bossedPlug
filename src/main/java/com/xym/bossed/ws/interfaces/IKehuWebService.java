package com.xym.bossed.ws.interfaces;

import javax.jws.WebService;

@WebService
public interface IKehuWebService {
	public String getKehuNameByKehuTelNo(String telNo);
}
