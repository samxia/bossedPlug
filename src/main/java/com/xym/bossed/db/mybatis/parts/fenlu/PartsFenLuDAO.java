package com.xym.bossed.db.mybatis.parts.fenlu;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;


public class PartsFenLuDAO implements PartsFenLuMapper {

	@Override
	public List<PartsFenLu> selectByPartsNo(String partsNo) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<PartsFenLu> list = null;
		try {
			PartsFenLuMapper mapper = session.getMapper(PartsFenLuMapper.class);
			list = mapper.selectByPartsNo(partsNo);
		} finally {
			session.close();
		}
		return list;
	}
	@Override
	public List<PartsFenLu> selectByExample(PartsFenLuExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<PartsFenLu> list = null;
		try {
			PartsFenLuMapper mapper = session.getMapper(PartsFenLuMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int countByExample(PartsFenLuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PartsFenLuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long recoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PartsFenLu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(PartsFenLu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PartsFenLu selectByPrimaryKey(Long recoNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") PartsFenLu record,
			@Param("example") PartsFenLuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") PartsFenLu record,
			@Param("example") PartsFenLuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PartsFenLu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(PartsFenLu record) {
		// TODO Auto-generated method stub
		return 0;
	}


}
