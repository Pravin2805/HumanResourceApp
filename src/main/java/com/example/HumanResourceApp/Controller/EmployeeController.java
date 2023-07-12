package com.example.HumanResourceApp.Controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanResourceApp.Entity.Employee;
import com.example.HumanResourceApp.Entity.Employees;
import com.example.HumanResourceApp.Repository.EmployeeRepository;
import com.example.HumanResourceApp.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	EmployeeService eService;
	
	@PostMapping("")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee){
		Employee newEmployee=eService.addEmployee(employee);
		return ResponseEntity.ok("Record Created Successfully");
	}
	
	@PutMapping("")
	public ResponseEntity<String> updateEmployee(@Valid  @RequestBody Employee employee){
		eService.updateEmployee(employee);
		return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById( @Valid @PathVariable BigDecimal employeeId){
		eService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Record deleted Successfully");
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> searchEmployeeById(@PathVariable("employeeId") BigDecimal employeeId){
		Employee employee=eService.searchEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/findfname/{firstName}")
	public ResponseEntity<List<Employee>> findByFirstName(@PathVariable("firstName") String firstName){
		List<Employee> employees=eService.findByFirstName(firstName);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/findemail/{email}") 
	public ResponseEntity<List<Employee>> findByEmail(@PathVariable("email") String email) { 
	List<Employee> employees = eService.findByEmail(email); 
	return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/findphone/{phoneNumber}") 
	public ResponseEntity<List<Employee>> findByPhoneNumber(@PathVariable String phoneNumber) { 
	List<Employee> employees = eService.findByPhoneNumber(phoneNumber);
	return ResponseEntity.ok(employees); 
	}
	
	@GetMapping("/findAllEmployeeWithNoCommission") 
	public ResponseEntity<List<Employee>> findAllWithNoCommission() { 
	List<Employee> employees = eService.findAllWithNoCommission(); 
	return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/findTotalCommissionIssuedToEmployee/{department_id}") 
	public ResponseEntity<BigDecimal> findTotalCommissionByDepartmentId(@PathVariable("department_id") BigDecimal departmentId) { 
	BigDecimal totalCommission = eService.findTotalCommissionByDepartmentId(departmentId); 
	return ResponseEntity.ok(totalCommission); 
	}
	
	@GetMapping("/listAllEmployees/{department_id}") 
	public ResponseEntity<List<Employee>> findAllEmployeesByDepartmentId(@PathVariable("department_id") BigDecimal departmentId) { 
	List<Employee> employees = eService.findAllEmployeesByDepartmentId(departmentId); 
	return ResponseEntity.ok(employees); 
	}
	
	@GetMapping("/employees_departmentwise_count")
	public ResponseEntity<List<Object[]>> countEmployeesByDepartment() { 
	List<Object[]> employeeCounts = eService.countEmployeesByDepartment(); 
	return ResponseEntity.ok(employeeCounts); 
	}
	
	@GetMapping("/listallmanagerdetails") 
	public ResponseEntity<List<Employee>> findAllManagers() { 
	List<Employee> managers = eService.findAllManagers(); 
	return ResponseEntity.ok(managers); 
	}
	
	@PutMapping("/email/{employeeId}")
	public ResponseEntity<String> updateEmployeeEmail( @Valid @PathVariable BigDecimal employeeId, @RequestBody String newEmail){
	boolean updated =eService.updateEmployeeEmail(employeeId, newEmail);
	return ResponseEntity.ok("Record Modified Successfully");
	}
	
	@PutMapping("/jobId/{employee_id}") 
	public ResponseEntity<String> updateJobId( @Valid @PathVariable("employee_id") BigDecimal employeeId, @RequestBody Employee jobId) { 
	eService.updateJobId(employeeId, jobId); 
	return new ResponseEntity<>("Job ID updated successfully", HttpStatus.OK); 
	}
	
	@PutMapping("/manager/{employeeId}")
	public ResponseEntity<String> updateManagerId( @Valid @PathVariable BigDecimal employeeId, @RequestBody Employee managerId) { 
	eService.updateManagerId(employeeId, managerId); 
	return new ResponseEntity<>("Manager ID updated successfully", HttpStatus.OK); 
	}

	@PutMapping("/department/{employeeId}")
	public ResponseEntity<String> updateDepartmentId( @Valid @PathVariable BigDecimal employeeId, @RequestBody Employee department_id) { 
	eService.updateDepartmentId(employeeId, department_id); 
	return new ResponseEntity<>("Department ID updated successfully", HttpStatus.OK); 
	}
	
	@PutMapping("/phoneNumber/{employeeId}")
	public ResponseEntity<String> updatePhoneNumber( @Valid @PathVariable BigDecimal employeeId, @RequestBody Employee phoneNumber) { 
	eService.updateDepartmentId(employeeId, phoneNumber); 
	return new ResponseEntity<>("phone number updated successfully", HttpStatus.OK); 
	}
	
	@GetMapping("/findmaxsalaryofjob")
	public ResponseEntity<Map<String, Object>> findEmployeeWithMaxSalary(){
		Optional<Map<String, Object>> employee =eService.findEmployeeWithMaxSalary();
		return ResponseEntity.ok(employee.get());
	}
	
	@GetMapping("/listofemployeebyhiredate/{from_hiredate}/{to_hiredate}")
	public ResponseEntity<List<Employee>> findEmployeesByHireDateRange(@PathVariable("from_hiredate") Date fromHireDate,
	@PathVariable("to_hiredate") Date toHireDate) {
	List<Employee> employees = eService.findEmployeesByHireDateRange(fromHireDate, toHireDate);
	return ResponseEntity.ok(employees);
	}
}
