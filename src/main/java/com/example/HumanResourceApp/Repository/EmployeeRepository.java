package com.example.HumanResourceApp.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.HumanResourceApp.Entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, BigDecimal> {
	//Employee findByJobId(String jobId);
	@Query("SELECT e FROM Employee e WHERE e.first_name = :firstName") 
	List<Employee> findByFirstName(@Param("firstName") String firstName);
	
	@Query("SELECT e FROM Employee e WHERE e.email = :email") 
	List<Employee> findByEmail(@Param("email") String email);
	
	@Query("SELECT e FROM Employee e WHERE e.phone_number = :phoneNumber")
	List<Employee> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	@Query("SELECT e FROM Employee e WHERE e.commission_pct IS NULL") 
	List<Employee> findAllWithNoCommission();
	
	@Query("SELECT SUM(e.commission_pct) FROM Employee e WHERE e.department_id = :departmentId")
	BigDecimal findTotalCommissionByDepartmentId(@Param("departmentId") BigDecimal departmentId);
	
	@Query("SELECT e FROM Employee e WHERE e.department_id = :departmentId") 
	List<Employee> findAllEmployeesByDepartmentId(@Param("departmentId") BigDecimal departmentId);

	@Query("SELECT e.department_id, COUNT(e) FROM Employee e GROUP BY e.department_id") 
	List<Object[]> countEmployeesByDepartment();
	
	@Query("SELECT e FROM Employee e WHERE e.employee_id IN (SELECT DISTINCT manager_id FROM Employee)")
	List<Employee> findAllManagers();
	
	@Modifying
	@Query("UPDATE Employee e SET e.email= :newEmail WHERE e.employee_id= :employeeId")
	int updateEmployeeEmail(BigDecimal employeeId, String newEmail);
	
	@Query("SELECT new map(e.employee_id as employeeId, e.jobId as jobId, e.salary as salary) FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)")
	Optional<Map<String, Object>> findEmployeeWithMaxSalary();
	
	@Query("SELECT e FROM Employee e WHERE e.hire_date BETWEEN ?1 AND ?2")
	List<Employee> findEmployeesByHireDateRange(Date fromHireDate, Date toHireDate);
	

}
