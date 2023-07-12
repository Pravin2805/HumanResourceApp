package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import com.example.HumanResourceApp.Entity.Departments;
import com.example.HumanResourceApp.Entity.Employees;

public interface DepartmentsService {

	public Employees findEmployeeWithMaxSalaryInDepartment(BigDecimal departmentId);
	public BigDecimal findMinSalaryByDepartmentId(BigDecimal departmentId);
	public Departments findDepartmentById(BigDecimal departmentId);
	public String deleteByDepartmentId(BigDecimal departmentId);
	public List<Departments> findAllDepartmentsByEmployeeId(BigDecimal empId);
}
