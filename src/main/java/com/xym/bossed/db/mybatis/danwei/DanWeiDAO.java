package com.xym.bossed.db.mybatis.danwei;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.dept.Department;
import com.xym.bossed.db.mybatis.dept.DepartmentMapper;

public class DanWeiDAO implements DanWeiMapper {

	@Override
	public int countByExample(DanWeiExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(DanWeiExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String lcMc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(DanWei record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(DanWei record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DanWei> selectByExample(DanWeiExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<DanWei> list = null;
		try {
			DanWeiMapper mapper = session.getMapper(DanWeiMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public DanWei selectByPrimaryKey(String lcMc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") DanWei record,
			@Param("example") DanWeiExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") DanWei record,
			@Param("example") DanWeiExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(DanWei record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(DanWei record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
