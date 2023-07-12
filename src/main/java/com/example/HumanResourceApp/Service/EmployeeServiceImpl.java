package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.type.descriptor.java.AbstractTemporalJavaType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Employee;
import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Exception.EmployeeNotFoundException;
import com.example.HumanResourceApp.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employeeRepo.existsById(employee.getEmployee_id())) {
			throw new AllReadyExistsException(null);
		}
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(BigDecimal employeeId) {
		if(!employeeRepo.existsById(employeeId)) {
			throw new EmployeeNotFoundException(" ");
		}
		employeeRepo.deleteById(employeeId);
		
	}

	@Override
	public Employee searchEmployeeById(BigDecimal employeeId) {
		if(!employeeRepo.existsById(employeeId)) {
			throw new EmployeeNotFoundException(" ");
		}
		return employeeRepo.findById(employeeId).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		return employeeRepo.findByFirstName(firstName);
	}

	@Override
	public List<Employee> findByEmail(String email) {
		return employeeRepo.findByEmail(email);
	}

	@Override
	public List<Employee> findByPhoneNumber(String phoneNumber) {
		return employeeRepo.findByPhoneNumber(phoneNumber);
	}

	@Override
	public List<Employee> findAllWithNoCommission() {
		return employeeRepo.findAllWithNoCommission();
	}

	@Override
	public BigDecimal findTotalCommissionByDepartmentId(BigDecimal departmentId) {
		if(!employeeRepo.existsById(departmentId)) {
			throw new EmployeeNotFoundException(" ");
		}
		return employeeRepo.findTotalCommissionByDepartmentId(departmentId);
	}

	@Override
	public List<Employee> findAllEmployeesByDepartmentId(BigDecimal departmentId) {
		if(!employeeRepo.existsById(departmentId)) {
			throw new EmployeeNotFoundException(" ");
		}
		return employeeRepo.findAllEmployeesByDepartmentId(departmentId);
	}

	@Override
	public List<Object[]> countEmployeesByDepartment() {
		return employeeRepo.countEmployeesByDepartment();
	}

	@Override
	public List<Employee> findAllManagers() {
		return employeeRepo.findAllManagers();
	}

	@Override
	public boolean updateEmployeeEmail(BigDecimal employeeId, String newEmail) {
		int rowsAffected= employeeRepo.updateEmployeeEmail(employeeId, newEmail);
		return rowsAffected>0;
	}

	@Override
	public Employee updateJobId(BigDecimal employeeId, Employee jobId) {
		if(!employeeRepo.existsById(employeeId)) {
			throw new EmployeeNotFoundException(" ");
		}
		Employee existingEmployee=employeeRepo.getById(employeeId);
		existingEmployee.setJobId(jobId.getJobId());
		BeanUtils.copyProperties(existingEmployee, jobId);
		return employeeRepo.save(jobId);
	}

	@Override
	public Employee updateDepartmentId(BigDecimal employeeId , Employee emp) {
		if(!employeeRepo.existsById(employeeId)) {
			throw new EmployeeNotFoundException(" ");
		}
		Employee existingEmployee=employeeRepo.getById(employeeId);
		existingEmployee.setDepartment_id(emp.getDepartment_id());
		BeanUtils.copyProperties(existingEmployee, emp);
		employeeRepo.save(emp);
		return emp;
		
	}

	@Override
	public Employee updateManagerId(BigDecimal employeeId, Employee managerId) {
		if(!employeeRepo.existsById(employeeId)) {
			throw new EmployeeNotFoundException(" ");
		}
		Employee existingEmployee=employeeRepo.getById(employeeId);
		existingEmployee.setManager_id(managerId.getManager_id());
		BeanUtils.copyProperties(existingEmployee, managerId);
		employeeRepo.save(managerId);
		return managerId;
	}

	@Override
	public Employee updatePhoneNumber(BigDecimal employeeId, Employee phoneNumber) {
		Employee existingEmployee=employeeRepo.getById(employeeId);
		existingEmployee.setPhone_number(phoneNumber.getPhone_number());
		BeanUtils.copyProperties(existingEmployee, phoneNumber);
		employeeRepo.save(phoneNumber);
		return phoneNumber;
	}

	@Override
	public Optional<Map<String, Object>> findEmployeeWithMaxSalary() {
		return employeeRepo.findEmployeeWithMaxSalary();
	}
	
	@Override
	public List<Employee> findEmployeesByHireDateRange(Date fromHireDate, Date toHireDate) {
		return employeeRepo.findEmployeesByHireDateRange(fromHireDate, toHireDate);
		}

}
