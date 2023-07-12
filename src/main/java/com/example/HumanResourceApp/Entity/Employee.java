package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="employee_id",precision = 6,scale = 0)
	private BigDecimal employee_id;
	
	@Column(name="first_name",length = 20)
	private String first_name;
	
	@Column(name="last_name",length = 25, nullable = false)
	private String last_name;
	
	@Column(name="email",length = 25,unique = true,nullable = false)
	@UniqueElements(message = "Email Must Be Unique")
	private String email;
	
	@Column(name="phone_number",length = 20)
	private String phone_number;
	
	@Column(name="hire_date",nullable = false)
	private Date hire_date;
	
	@Column(name="jobId",length = 10,nullable = false)
	private String jobId;
	
	@Column(name="salary",precision = 8,scale = 2)
	private BigDecimal salary;
	
	@Column(name="commission_pct",precision = 2,scale = 2)
	private BigDecimal commission_pct;
	
	@Column(name="manager_id",precision = 6,scale = 0)
	private BigDecimal manager_id;
	
	@Column(name="department_id",precision = 4,scale = 0)
	private BigDecimal department_id;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(BigDecimal employee_id, String first_name, String last_name, String email, String phone_number,
			Date hire_date, String jobId, BigDecimal salary, BigDecimal commission_pct, BigDecimal manager_id,
			BigDecimal department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.jobId = jobId;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.department_id = department_id;
	}



	public BigDecimal getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(BigDecimal employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(BigDecimal commission_pct) {
		this.commission_pct = commission_pct;
	}

	public BigDecimal getManager_id() {
		return manager_id;
	}

	public void setManager_id(BigDecimal manager_id) {
		this.manager_id = manager_id;
	}

	public BigDecimal getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(BigDecimal department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", jobId="
				+ jobId + ", salary=" + salary + ", commission_pct=" + commission_pct + ", manager_id=" + manager_id
				+ ", department_id=" + department_id + "]";
	}
	
	
}

