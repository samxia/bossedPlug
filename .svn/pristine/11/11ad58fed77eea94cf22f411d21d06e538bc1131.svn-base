package com.xym.bossed.db.mybatis.cangku;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.sale.SaleMapper;
import com.xym.bossed.db.mybatis.sale.SaleSheetSummary;

public class CangKuDAO implements CangKuMapper {

	@Override
	public List<CangKu> getAllCangKu() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<CangKu> list = null;
		try {
			CangKuMapper mapper = session.getMapper(CangKuMapper.class);
			list = mapper.getAllCangKu();
		} finally {
			session.close();
		}
		return list;
	}

	public static void main(String[] args) {
		CangKuDAO dao = new CangKuDAO();
		System.out.println(dao.getAllCangKu().size());
	}
}
