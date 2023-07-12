package com.example.HumanResourceApp.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Entity.Locations;
import com.example.HumanResourceApp.Entity.Regions;
import com.example.HumanResourceApp.Service.EmployeesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {

	@Autowired
	EmployeesService eService;
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employees employee){
		Employees newEmployee=eService.addEmployee(employee);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("/employee/{employeeId}")
	public ResponseEntity<String> updateEmployee( @Valid @PathVariable BigDecimal employeeId, @RequestBody Employees updatedEmployee){
		Employees modifiedEmployee=eService.updateEmployee(employeeId, updatedEmployee);
		//return new ResponseEntity<>(modifiedRegion,HttpStatus.OK);
		return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById( @Valid @PathVariable BigDecimal employeeId){
		eService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Record deleted Successfully");
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employees> searchEmployeeById(@PathVariable BigDecimal employeeId){
		Employees employee=eService.searchEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
	}
	
}
