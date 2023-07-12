package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.HumanResourceApp.Entity.Employee;
import com.example.HumanResourceApp.Entity.Employees;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	public void deleteEmployeeById(BigDecimal employeeId);
	public Employee searchEmployeeById(BigDecimal employeeId);
	public Employee updateEmployee(Employee employee);
	public List<Employee> findByFirstName(String firstName);
	public List<Employee> findByEmail(String email);
	public List<Employee> findByPhoneNumber(String phoneNumber);
	public List<Employee> findAllWithNoCommission();
	public BigDecimal findTotalCommissionByDepartmentId(BigDecimal departmentId);
	public List<Employee> findAllEmployeesByDepartmentId(BigDecimal departmentId);
	public List<Object[]> countEmployeesByDepartment();
	public List<Employee> findAllManagers();
	public boolean updateEmployeeEmail(BigDecimal employeeId,String newEmail);
	public Employee updateJobId(BigDecimal employeeId, Employee jobId);
	public Employee updateManagerId(BigDecimal employeeId, Employee managerId);
	public Employee updateDepartmentId(BigDecimal employeeId,Employee emp);
	public Employee updatePhoneNumber(BigDecimal employeeId, Employee phoneNumber);
	public Optional<Map<String, Object>> findEmployeeWithMaxSalary();
	public List<Employee> findEmployeesByHireDateRange(Date fromHireDate, Date toHireDate);
}
