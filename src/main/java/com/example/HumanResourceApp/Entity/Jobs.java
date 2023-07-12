package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs")
public class Jobs {
	
	@Id
	@Column(name="job_id",length = 10,nullable = false)
	private String  job_id;
	
	@Column(name= "job_title",length = 35,nullable = false)
	private String job_title;
	
	@Column(name= "min_salary",precision = 6,scale = 0)
	private BigDecimal min_salary;
	
	@Column(name= "max_salary",precision = 6,scale = 0)
	private BigDecimal max_salary;
	
	public Jobs() {}

	public Jobs(String job_id, String job_title, BigDecimal min_salary, BigDecimal max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public BigDecimal getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(BigDecimal min_salary) {
		this.min_salary = min_salary;
	}

	public BigDecimal getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(BigDecimal max_salary) {
		this.max_salary = max_salary;
	}
	
	@Override
	public String toString() {
		return "Jobs [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}
	
}
