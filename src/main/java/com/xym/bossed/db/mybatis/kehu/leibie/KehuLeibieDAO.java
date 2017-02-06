package com.xym.bossed.db.mybatis.kehu.leibie;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class KehuLeibieDAO implements KehuLeibieMapper {

	@Override
	public int countByExample(KehuLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(KehuLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String kehulbDm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(KehuLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(KehuLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<KehuLeibie> selectByExample(KehuLeibieExample example) {
		List<KehuLeibie> list = null;
		SqlSession session = SQLFactory.getFactory().openSession();
		try {
			KehuLeibieMapper mapper = session.getMapper(KehuLeibieMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public KehuLeibie selectByPrimaryKey(String kehulbDm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") KehuLeibie record,
			@Param("example") KehuLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") KehuLeibie record,
			@Param("example") KehuLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(KehuLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(KehuLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
