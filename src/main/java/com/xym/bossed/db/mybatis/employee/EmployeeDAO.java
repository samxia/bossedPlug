package com.xym.bossed.db.mybatis.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.jiesuan.JieSuan;
import com.xym.bossed.db.mybatis.jiesuan.JieSuanExample;
import com.xym.bossed.db.mybatis.jiesuan.JieSuanMapper;

public class EmployeeDAO implements EmployeeMapper{

	@Override
	public int countByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String renyDm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(EmployeeWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(EmployeeWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmployeeWithBLOBs> selectByExampleWithBLOBs(
			EmployeeExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectByExample(EmployeeExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Employee> list = null;
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public EmployeeWithBLOBs selectByPrimaryKey(String renyDm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(
			@Param("record") EmployeeWithBLOBs record,
			@Param("example") EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExampleWithBLOBs(
			@Param("record") EmployeeWithBLOBs record,
			@Param("example") EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") Employee record,
			@Param("example") EmployeeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(EmployeeWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(EmployeeWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
