package com.xym.bossed.interfaces;

import java.util.Date;
import java.util.List;

import com.xym.bossed.db.mybatis.fapiao.FaPiao;

public interface IFapiaoService {
	public List listAllFapiao();
	public List listFapiaoByDate(Date start,Date end,String str_state);
	public int saveFapiao(FaPiao fapiao,String czy);
	public boolean existFapiaoHaoma(String fapiao_no);
	public int insertSelective(FaPiao fapiao, String czy);
}
