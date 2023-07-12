package com.example.HumanResourceApp.Controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Entity.Countries;
import com.example.HumanResourceApp.Entity.Department;
import com.example.HumanResourceApp.Service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

	DepartmentService dService;
	@PostMapping
	public ResponseEntity<String> addNewDepartment( @Valid  @RequestBody Department department){
		Department newDepartment=dService.addNewDepartment(department);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("/{departmentId}")
	public ResponseEntity<String> updateDepartment( @Valid @PathVariable BigDecimal departmentId, @RequestBody Department updatedDepartment){
		Department modifiedDepartment=dService.updateDepartment(departmentId, updatedDepartment);
		return ResponseEntity.ok("Record Modified Successfully");
	}
}
