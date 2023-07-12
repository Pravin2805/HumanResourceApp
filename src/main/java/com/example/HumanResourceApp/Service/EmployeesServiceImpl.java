package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Repository.EmployeesRepository;
import com.example.HumanResourceApp.Repository.JobsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService{

	@Autowired
	EmployeesRepository employeesRepo;
	
	@Autowired
	JobsRepository jobsRepo;

	@Override
	public Employees addEmployee(Employees employee) {
		if(employeesRepo.existsById(employee.getEmployee_id())) {
			throw new AllReadyExistsException(null);
		}
		return employeesRepo.save(employee);
	}

	@Override
	public Employees updateEmployee(BigDecimal employeeId, Employees updateEmployee) {
		Employees existingEmployee=employeesRepo.findById(employeeId).get();
		existingEmployee.setFirst_name(updateEmployee.getFirst_name());
		existingEmployee.setLast_name(updateEmployee.getLast_name());
		existingEmployee.setEmail(updateEmployee.getEmail());
		existingEmployee.setPhone_number(updateEmployee.getPhone_number());
		existingEmployee.setHire_date(updateEmployee.getHire_date());
		existingEmployee.setJobs(updateEmployee.getJobs());
		existingEmployee.setSalary(updateEmployee.getSalary());
		existingEmployee.setCommission_pct(updateEmployee.getCommission_pct());
		existingEmployee.setManager_id(updateEmployee.getManager_id());
		existingEmployee.setDepartments(updateEmployee.getDepartments());
		
		return employeesRepo.save(existingEmployee);
	}

	@Override
	public void deleteEmployeeById(BigDecimal employeeId) {
		employeesRepo.deleteById(employeeId);
		
	}

	@Override
	public Employees searchEmployeeById(BigDecimal employeeId) {
		return employeesRepo.findById(employeeId).get();
	}
	
	
}
