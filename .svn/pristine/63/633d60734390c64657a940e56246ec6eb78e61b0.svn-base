package com.xym.bossed.db.mybatis.log;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class LogDAO implements LogMapper{

	@Override
	public int countByExample(LogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(LogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Log record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Log record) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt;
		try {
			LogMapper mapper = session.getMapper(LogMapper.class);
			rt = mapper.insertSelective(record);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}

	@Override
	public List<Log> selectByExample(LogExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Log> list=null;
		try {
			LogMapper mapper = session.getMapper(LogMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(@Param("record") Log record,
			@Param("example") LogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") Log record,
			@Param("example") LogExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

}
