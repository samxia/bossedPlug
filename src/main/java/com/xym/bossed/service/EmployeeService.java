package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.employee.Employee;
import com.xym.bossed.db.mybatis.employee.EmployeeDAO;
import com.xym.bossed.db.mybatis.employee.EmployeeExample;

public class EmployeeService {
	public List<Employee> getEmployeesByDepartment(String departmentName) {
		EmployeeExample em = new EmployeeExample();
		em.or().andDeptMcEqualTo(departmentName);
		return new EmployeeDAO().selectByExample(em);
	}
	public List<Employee> getAllEmploee()
	{
		return new EmployeeDAO().selectByExample(new EmployeeExample());
	}
	public static void main(String[] args)
	{
		EmployeeService es=new EmployeeService();
		System.out.println(es.getAllEmploee().size());
	}
}
