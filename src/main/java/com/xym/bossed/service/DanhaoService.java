package com.xym.bossed.service;

import com.xym.bossed.db.mybatis.danhao.DanHaoDAO;
import com.xym.bossed.interfaces.IDanhaoService;

public class DanhaoService implements IDanhaoService{

	@Override
	public String createNewDanhao(int list_code, String czy) {
		return new DanHaoDAO().createNewDanhao(list_code, czy);
	}

	@Override
	public int zuofeiDanhao(String danhao, int list_code) {
		return new DanHaoDAO().zuofeiDanhao(danhao, list_code);
	}


}
