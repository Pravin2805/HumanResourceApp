package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Departments;
import com.example.HumanResourceApp.Entity.Employee;
import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Exception.DepartmentNotFoundException;
import com.example.HumanResourceApp.Exception.EmployeeNotFoundException;
import com.example.HumanResourceApp.Repository.DepartmentsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
	DepartmentsRepository departmentsRepo;

	@Override
	public Employees findEmployeeWithMaxSalaryInDepartment(BigDecimal departmentId) {
		if(!departmentsRepo.existsById(departmentId)) {
			throw new DepartmentNotFoundException(departmentId);
		}
		return departmentsRepo.findEmployeeWithMaxSalaryInDepartment(departmentId);
	}

	@Override
	public BigDecimal findMinSalaryByDepartmentId(BigDecimal departmentId) {
		if(!departmentsRepo.existsById(departmentId)) {
			throw new DepartmentNotFoundException(departmentId);
		}
		return departmentsRepo.findMinSalaryByDepartmentId(departmentId);
	}

	@Override
	public Departments findDepartmentById(BigDecimal departmentId) {
		if(!departmentsRepo.existsById(departmentId)) {
			throw new DepartmentNotFoundException(departmentId);
		}
		return departmentsRepo.findById(departmentId).orElse(null);
	}

	@Override
	public String deleteByDepartmentId(BigDecimal departmentId) {
		if(!departmentsRepo.existsById(departmentId)) {
			throw new DepartmentNotFoundException(departmentId);
		}
		departmentsRepo.deleteByDepartmentId(departmentId);
		return "Department Deleted Succefully";
		
	}

	@Override
	public List<Departments> findAllDepartmentsByEmployeeId(BigDecimal empId) {

		return departmentsRepo.findAllDepartmentsByEmployeeId(empId);
	}

	
}
