package com.example.HumanResourceApp.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.HumanResourceApp.Entity.Departments;
import com.example.HumanResourceApp.Entity.Employees;

import jakarta.transaction.Transactional;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, BigDecimal> {

	@Query("SELECT e FROM Employees e WHERE e.departments.department_id = :departmentId " +
			"AND e.salary = (SELECT MAX(emp.salary) FROM Employees emp WHERE emp.departments.department_id = :departmentId)")
			Employees findEmployeeWithMaxSalaryInDepartment(BigDecimal departmentId);
	
	@Query("SELECT MIN(e.salary) FROM Employees e WHERE e.departments.department_id = :departmentId")
	BigDecimal findMinSalaryByDepartmentId(BigDecimal departmentId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Departments d WHERE d.department_id = :departmentId")
	void deleteByDepartmentId(BigDecimal departmentId);
	
	@Query("SELECT d FROM Departments d WHERE d.manager.employee_id = :empId") 
	List<Departments> findAllDepartmentsByEmployeeId(BigDecimal empId);
}
