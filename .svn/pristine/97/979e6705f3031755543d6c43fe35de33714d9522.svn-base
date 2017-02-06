package com.xym.bossed.db.mybatis.parts.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.sale.SaleMapper;
import com.xym.bossed.db.mybatis.sale.SaleSheetSummary;

public class PartsCategoryDAO implements PartsCategoryMapper{

	@Override
	public int countByExample(PartsCategoryExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PartsCategoryExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String peijlbDm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PartsCategory record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(PartsCategory record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PartsCategory> selectByExample(PartsCategoryExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<PartsCategory> list = null;
		try {
			PartsCategoryMapper mapper = session.getMapper(PartsCategoryMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public PartsCategory selectByPrimaryKey(String peijlbDm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") PartsCategory record,
			@Param("example") PartsCategoryExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") PartsCategory record,
			@Param("example") PartsCategoryExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PartsCategory record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(PartsCategory record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
