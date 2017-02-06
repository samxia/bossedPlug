package com.xym.bossed.db.mybatis.procedure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class ProcedureDAO {
	/** 
	 * @param param
	 * @param info_type
	 * @return
	 */
	public int checkBeforeDelete(String param, int info_type) {
		Object obj = null;
		SqlSession session = SQLFactory.getFactory().openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info_no", param);
		map.put("info_type", info_type);
		try {
			obj = session
					.selectOne(
							"com.xym.bossed.db.mybatis.procedure.ProcedureMapper.check_before_delete",
							map);
		} finally {
			session.close();
		}
		return (Integer) obj;
	}

	public Map<String, Object> getPriceByProcudure(PriceBean pb) {
		SqlSession session = SQLFactory.getFactory().openSession();
		Map<String, Object> map = new HashMap<String, Object>();
/*		map.put("kehuNo", "qmczsw");
		map.put("yeWuDanHao", "");
		map.put("yeWuDate", "");
		map.put("priceCode", 11);
		map.put("cangKuDaiMa","");
		map.put("peijNo", "JYX-WB202-CJ");
		map.put("price", 0);*/
		map.put("kehuNo", pb.getKehuNo());
		map.put("yeWuDanHao", "");
		map.put("yeWuDate", "1982-01-01");
		map.put("priceCode", pb.getPriceCode());
		map.put("cangKuDaiMa",pb.getCangKuDm());
		map.put("peijNo", pb.getPeijNo());
		map.put("price", BigDecimal.ZERO);
		
		try {
			session.selectOne(
					"com.xym.bossed.db.mybatis.procedure.ProcedureMapper.getPriceByProcudure",
					map);
		} finally {
			session.close();
		}
		return map;
	}
	public static void main(String[] args)
	{
		ProcedureDAO dao=new ProcedureDAO();
		PriceBean pb=new PriceBean();
		pb.setKehuNo("qmczsw");
		pb.setPeijNo("JYX-WB202-CJ");
		pb.setPriceCode(11);
		Map<String,Object> map=dao.getPriceByProcudure(pb);
		System.out.println(map.get("price"));
		System.out.println(map.get("yeWuDanHao"));
	}
	
}
