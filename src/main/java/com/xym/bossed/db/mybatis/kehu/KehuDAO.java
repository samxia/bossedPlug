package com.xym.bossed.db.mybatis.kehu;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.fapiao.FaPiao;
import com.xym.bossed.db.mybatis.fapiao.FaPiaoMapper;
import com.xym.bossed.security.SecurityService;

public class KehuDAO implements KehuMapper {

	@Override
	public int countByExample(KehuExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			rv = mapper.countByExample(example);
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int deleteByExample(KehuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String kehuNo) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			rv = mapper.deleteByPrimaryKey(kehuNo);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int insert(Kehu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Kehu record) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt;
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			rt = mapper.insertSelective(record);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}

	@Override
	public List<Kehu> selectByExample(KehuExample example) {
		
		//category auth check
		example.setCurrentUserName(new SecurityService().getCurrentUsername());
		////////for testing////////
		//example.setCurrentUserName("a");
		//System.out.println("set current user name to :a");
		//////////////////////////
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Kehu> list = null;
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Kehu> selectByExampleOnPagination(KehuExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Kehu> list = null;
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			list = mapper.selectByExampleOnPagination(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Kehu selectByPrimaryKey(String kehuNo) {
		Kehu kehu = null;
		SqlSession session = SQLFactory.getFactory().openSession();
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			kehu = mapper.selectByPrimaryKey(kehuNo);
		} finally {
			session.close();
		}

		return kehu;
	}

	@Override
	public int updateByExampleSelective(@Param("record") Kehu record,
			@Param("example") KehuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") Kehu record,
			@Param("example") KehuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Kehu record) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv;
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			rv = mapper.updateByPrimaryKeySelective(record);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int updateByPrimaryKey(Kehu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void refreshCache() {
		SqlSession session = SQLFactory.getFactory().openSession();
		try {
			KehuMapper mapper = session.getMapper(KehuMapper.class);
			mapper.refreshCache();
		} finally {
			session.close();
		}
		
	}

}
