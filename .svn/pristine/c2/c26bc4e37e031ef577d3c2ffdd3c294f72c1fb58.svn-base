package com.xym.bossed.db.mybatis.dept;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;


public class DepartmentDAO implements DepartmentMapper{

	@Override
	public List<Department> getAllDepartment() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Department> list = null;
		try {
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			list = mapper.getAllDepartment();
		} finally {
			session.close();
		}
		return list;
	}
	public static void main(String[] args) {
		DepartmentDAO dao=new DepartmentDAO();
		System.out.println(dao.getAllDepartment().size());
		
	}
}
