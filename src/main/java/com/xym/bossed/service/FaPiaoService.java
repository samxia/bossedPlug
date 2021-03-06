package com.xym.bossed.service;

import java.util.Date;
import java.util.List;

import com.xym.bossed.db.mybatis.danhao.DanHaoDAO;
import com.xym.bossed.db.mybatis.fapiao.FaPiao;
import com.xym.bossed.db.mybatis.fapiao.FaPiaoDAO;
import com.xym.bossed.db.mybatis.fapiao.FaPiaoExample;
import com.xym.bossed.db.mybatis.fapiao.leixing.FaPiaoLeiXing;
import com.xym.bossed.db.mybatis.fapiao.leixing.LeiXingDAO;
import com.xym.bossed.interfaces.IDanhaoService;
import com.xym.bossed.interfaces.IFapiaoService;

public class FaPiaoService implements IFapiaoService {

	@Override
	public List<FaPiao> listAllFapiao() {
		FaPiaoDAO dao = new FaPiaoDAO();
		FaPiaoExample exa = new FaPiaoExample();
		exa.or().getAllCriteria();
		return dao.selectByExample(exa);
	}

	@Override
	public List<FaPiao> listFapiaoByDate(Date start, Date end, String str_state) {
		FaPiaoDAO dao = new FaPiaoDAO();
		FaPiaoExample exa = new FaPiaoExample();
		if (str_state.trim().equalsIgnoreCase("")) {
			exa.or().andKaipRqBetween(start, end);
		} else {
			exa.or()
					.andKaipRqBetween(start, end)
					.andKaipValidityEqualTo(
							"true".equalsIgnoreCase(str_state) ? true : false);
		}

		return dao.selectByExample(exa);
	}

	@Override
	public int saveFapiao(FaPiao fapiao, String czy) {
		return this.insertSelective(fapiao, czy);
	}

	public int insertSelective(FaPiao fapiao, String czy) {
		IDanhaoService ds = new DanhaoService();
		//如已有此发票号码，返回3
		if(this.existFapiaoHaoma(fapiao.getKaipFpno()))
		{
			return 3;
		}		
		String danhao = ds.createNewDanhao(5002, czy);// 5002为存储过程中定义的发票单号码
		fapiao.setKaipNo(danhao);
		FaPiaoDAO dao = new FaPiaoDAO();
		return dao.insertSelective(fapiao);
	}

	public boolean existFapiaoHaoma(String fapiao_no) {
		FaPiaoDAO dao = new FaPiaoDAO();
		FaPiaoExample example = new FaPiaoExample();
		example.or().andKaipFpnoEqualTo(fapiao_no);
		int count = dao.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
	public List<FaPiaoLeiXing> getAllLeiXing()
	{
		return new LeiXingDAO().getAllLeiXing();
	}
}
