package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="department_id",precision = 4,scale = 0)
	private BigDecimal department_id;
	
	@Column(name="department_name",length = 30, nullable = false)
	private String department_name;
	
	@Column(name="manager_id",precision = 6,scale = 0)
	private BigDecimal manager_id;
	
	@Column(name="location_id",precision = 4,scale = 0)
	private BigDecimal location_id;
	
	Department(){}

	public Department(BigDecimal department_id, String department_name, BigDecimal manager_id, BigDecimal location_id) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.location_id = location_id;
	}

	public BigDecimal getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(BigDecimal department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public BigDecimal getManager_id() {
		return manager_id;
	}

	public void setManager_id(BigDecimal manager_id) {
		this.manager_id = manager_id;
	}

	public BigDecimal getLocation_id() {
		return location_id;
	}

	public void setLocation_id(BigDecimal location_id) {
		this.location_id = location_id;
	}
	
	
	
}
