package com.xym.bossed.db.mybatis.sale;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class SaleDAO implements SaleMapper {

	@Override
	public List<SaleSheetSummary> getAllSaleSheetSummary() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<SaleSheetSummary> list = null;
		try {
			SaleMapper mapper = session.getMapper(SaleMapper.class);
			list = mapper.getAllSaleSheetSummary();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<PartsItem> getTempPartsItemByDanHao(String danHao) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<PartsItem> list = null;
		try {
			SaleMapper mapper = session.getMapper(SaleMapper.class);
			list = mapper.getTempPartsItemByDanHao(danHao);
		} finally {
			session.close();
		}
		return list;
	}


	@Override
	public int updateTempPartsItemFlagSLToZeroIfNullByDanHao(String danHao) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt = 0;
		try {
			SaleMapper mapper = session.getMapper(SaleMapper.class);
			rt = mapper.updateTempPartsItemFlagSLToZeroIfNullByDanHao(danHao);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}
	@Override
	public SaleSheetSummary getSaleSheetSummaryByDanHao(String danHao) {
		SqlSession session = SQLFactory.getFactory().openSession();
		 SaleSheetSummary result=null;
		try {
			SaleMapper mapper = session.getMapper(SaleMapper.class);
			result = mapper.getSaleSheetSummaryByDanHao(danHao);
		} finally {
			session.close();
		}
		return result;
	}
	@Override
	public int deleteSaleSheetByDanHao(String danHao) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt = 0;
		try {
			SaleMapper mapper = session.getMapper(SaleMapper.class);
			rt = mapper.deleteSaleSheetByDanHao(danHao);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}
	public static void main(String[] args) {
		SaleDAO dao = new SaleDAO();
		/*dao.updateTempPartsItemFlagSLToZeroIfNullByDanHao("XS20140328_0006");
		System.out.println(dao.getTempPartsItemByDanHao("XS20140328_0006")
			.size());*/
		
		System.out.println(dao.deleteSaleSheetByDanHao("XS20140530_0021"));
		
		List<SaleSheetSummary> list=dao.getAllSaleSheetSummary();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(i+":"+list.get(i).getDanhao());
		}
	}



	
}
