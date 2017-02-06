package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.danwei.DanWei;
import com.xym.bossed.db.mybatis.danwei.DanWeiDAO;
import com.xym.bossed.db.mybatis.danwei.DanWeiExample;

public class DanWeiService {
	public List<DanWei> getAllDanWei() {
		DanWeiDAO dao = new DanWeiDAO();
		return dao.selectByExample(new DanWeiExample());
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			DanWeiService dws = new DanWeiService();
			System.out.println(dws.getAllDanWei().size());
		}
	}
}
