package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;

import com.example.HumanResourceApp.Entity.Countries;
import com.example.HumanResourceApp.Entity.Department;

public interface DepartmentService {

	public Department addNewDepartment(Department department);
	public Department updateDepartment(BigDecimal departmentId, Department updatedDepartment);
}
