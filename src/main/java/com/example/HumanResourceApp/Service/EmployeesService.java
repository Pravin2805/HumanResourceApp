package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;

import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Entity.Regions;

public interface EmployeesService {

	public Employees addEmployee(Employees employee);
	public Employees updateEmployee(BigDecimal employeeId,Employees updateEmployee);
	public void deleteEmployeeById(BigDecimal employeeId);
	public Employees searchEmployeeById(BigDecimal employeeId);
	
}
