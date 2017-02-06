package com.xym.bossed.db.mybatis.price;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class PriceDAO implements PriceMapper {

	@Override
	public List<PriceRefer> selectPriceReferForSale(String kehuNo,
			String partsNo, String cangkDm) {
		List<PriceRefer> list = null;
		SqlSession session = SQLFactory.getFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("kehuNo", kehuNo);
		map.put("partsNo", partsNo);
		map.put("cangkDm", cangkDm);
		try {
			session.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			list = session
					.selectList(
							"com.xym.bossed.db.mybatis.price.PriceMapper.selectSalePriceRefer",
							map);
			// session.commit(true);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<PriceRefer> selectPriceReferForBuy(String gysNo,
			String partsNo, String cangkDm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriceDAO dao = new PriceDAO();
		List<PriceRefer> list = dao.selectPriceReferForSale("KGRKH",
				"JPLHQP-151-350J-YZBP", "01");

		for (int i = 0; i < list.size(); i++) {
			PriceRefer rf = list.get(i);
			System.out.println(rf.getId() + "--" + rf.getPriceDesc()
					+ rf.getJiag() + rf.getYewuDh() + rf.getYewuRq());
		}

	}
}
