package com.xym.bossed.db.mybatis.fapiao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class FaPiaoDAO implements FaPiaoMapper {

	@Override
	public int countByExample(FaPiaoExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv=0;
		try {
			FaPiaoMapper mapper = session.getMapper(FaPiaoMapper.class);
			rv = mapper.countByExample(example);
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int deleteByExample(FaPiaoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long recoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(FaPiao record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(FaPiao record) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv=0;
		try {
			FaPiaoMapper mapper = session.getMapper(FaPiaoMapper.class);
			rv=mapper.insertSelective(record);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public List<FaPiao> selectByExample(FaPiaoExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<FaPiao> list = null;
		try {
			FaPiaoMapper mapper = session.getMapper(FaPiaoMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public FaPiao selectByPrimaryKey(Long recoNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") FaPiao record,
			@Param("example") FaPiaoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") FaPiao record,
			@Param("example") FaPiaoExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(FaPiao record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(FaPiao record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
