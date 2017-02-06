package com.xym.bossed.service;

import com.xym.bossed.db.mybatis.yshk.YSHKDAO;
import com.xym.bossed.db.mybatis.yshk.YingShouHuoKuanBean;

public class YSHKService {
	public YingShouHuoKuanBean getYSHKByKehuNo(String kehuNo) {
		return new YSHKDAO().getYSHKByKehuNo(kehuNo);
	}
}
