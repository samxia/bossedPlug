package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.dept.Department;
import com.xym.bossed.db.mybatis.dept.DepartmentDAO;

public class DepartmentService {
	public List<Department> getAllDepartment() {
		return new DepartmentDAO().getAllDepartment();
	}
}
