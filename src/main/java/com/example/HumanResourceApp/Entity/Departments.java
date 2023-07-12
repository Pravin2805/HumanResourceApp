package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="departments")
public class Departments {

	@Id
	@Column(name="department_id",precision = 4,scale = 0)
	private BigDecimal department_id;
	
	@Column(name="department_name",length = 30,nullable = false)
	private String department_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="manager_id",referencedColumnName = "employee_id")
	private Employees manager;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="location_id",referencedColumnName = "location_id")
	private Locations locations;
	
	public Departments() {}
	
	public Departments(BigDecimal department_id, String department_name, Employees manager, Locations locations) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager = manager;
		this.locations = locations;
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

	public Locations getLocations() {
		return locations;
	}

	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Departments [department_id=" + department_id + ", department_name=" + department_name + ", manager="
				+ manager + ", locations=" + locations + "]";
	}

}
