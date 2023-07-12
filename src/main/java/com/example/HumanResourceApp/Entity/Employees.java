package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@Column(name="employee_id",precision = 6,scale = 0)
	private BigDecimal employee_id;
	
	@Column(name="first_name",length = 20)
	private String first_name;
	
	@Column(name="last_name",length = 25,nullable = false)
	private String last_name;
	
	@Column(name="email",length = 25,nullable=false,unique = true)
	@UniqueElements(message = " Email Must Be unique")
	private String email;
	
	@Column(name="phone_number",length = 20)
	private String phone_number;
	
	@Column(name="hire_date",nullable = false)
	private Date hire_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="job_id",referencedColumnName = "job_id",nullable = false)
	private Jobs jobs;
	
	@Column(name="salary",precision = 8,scale = 2)
	@Size(max = 12)
	private BigDecimal salary;
	
	@Column(name="commission_pct",precision = 2,scale = 2)
	private BigDecimal commission_pct;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manager_id",referencedColumnName = "employee_id")
	private Employees manager_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id",referencedColumnName = "department_id")
	private Departments departments;
	
	public Employees() {
		// TODO Auto-generated constructor stub
	}

	public Employees(BigDecimal employee_id, String first_name, String last_name, String email, String phone_number,
			Date hire_date, Jobs jobs, BigDecimal salary, BigDecimal commission_pct, Employees manager_id,
			Departments departments) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.jobs = jobs;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.departments = departments;
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

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
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
	

	public Employees getManager_id() {
		return manager_id;
	}

	public void setManager_id(Employees manager_id) {
		this.manager_id = manager_id;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Employees [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", jobs=" + jobs
				+ ", salary=" + salary + ", commission_pct=" + commission_pct + ", manager_id=" + manager_id
				+ ", departments=" + departments + "]";
	}

	

	
}
