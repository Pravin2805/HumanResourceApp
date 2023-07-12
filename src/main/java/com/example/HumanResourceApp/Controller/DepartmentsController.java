package com.example.HumanResourceApp.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Entity.Departments;
import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Service.DepartmentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class DepartmentsController {

	@Autowired
	DepartmentsService dService;

	@GetMapping("/findmaxsalary/{department_id}")
	public ResponseEntity<Object> findMaxSalary(  @PathVariable("department_id") BigDecimal departmentId) {
		Employees employee = dService.findEmployeeWithMaxSalaryInDepartment(departmentId);
		if (employee != null) {
			String departmentName = employee.getDepartments().getDepartment_name();
			BigDecimal maxSalary = employee.getSalary();
			Map<String, Object> response = new HashMap<>();
			response.put("department_name", departmentName);
			response.put("max_salary", maxSalary);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employee found in the department.");
		}
	}

	@GetMapping("/findminsalary/{department_id}")
	public ResponseEntity<Map<String, Object>> findMinSalaryByDepartmentId(
		@Valid	@PathVariable("department_id") BigDecimal departmentId) {
		BigDecimal minSalary = dService.findMinSalaryByDepartmentId(departmentId);
		if (minSalary != null) {
			String departmentName = dService.findDepartmentById(departmentId).getDepartment_name();
			Map<String, Object> response = new HashMap<>();
			response.put("department_name", departmentName);
			response.put("min salary", minSalary);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/departments/{departmentId}")
	public ResponseEntity<String> deleteDepartmentById( @Valid @PathVariable("departmentId") BigDecimal departmentId) {
		dService.deleteByDepartmentId(departmentId);
		return new ResponseEntity<>("Department with ID " + departmentId + " deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/departments/{empid}")
	public ResponseEntity<List<Departments>> getAllDepartmentsByEmployeeId(@PathVariable("empid") BigDecimal empId) {
		List<Departments> departments = dService.findAllDepartmentsByEmployeeId(empId);
		return ResponseEntity.status(HttpStatus.OK).body(departments);
	}
}
