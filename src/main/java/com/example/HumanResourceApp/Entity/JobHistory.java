package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;

import java.sql.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Embeddable
class JobHistoryKey{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id", referencedColumnName = "employee_id")
    private Employees employees;

    @Column(name="start_date")
    private Date start_date;

}


@IdClass(JobHistoryKey.class)
@Entity
@Table(name="job_history")
public class JobHistory {

    @EmbeddedId
    @Column(name="employee_id",precision = 6,scale = 0)
    private Employees employees;

    @EmbeddedId
    private Date start_date;

    @Column(name="end_date",nullable = false)
    private Date end_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id",referencedColumnName = "job_id",nullable = false)
    private Jobs jobs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id", referencedColumnName = "department_id")
    private Departments departments;

    JobHistory(){}
	public JobHistory(Employees employees, Date start_date, Date end_date, Jobs jobs, Departments departments) {
		super();
		this.employees = employees;
		this.start_date = start_date;
		this.end_date = end_date;
		this.jobs = jobs;
		this.departments = departments;
	}
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	
	@Override
	public String toString() {
		return "JobHistory [employees=" + employees + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", jobs=" + jobs + ", departments=" + departments + "]";
	}

}