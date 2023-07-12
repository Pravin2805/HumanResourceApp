package com.example.HumanResourceApp.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HumanResourceApp.Entity.Countries;
import com.example.HumanResourceApp.Entity.Department;
import com.example.HumanResourceApp.Exception.AllReadyExistsException;
import com.example.HumanResourceApp.Exception.DepartmentNotFoundException;
import com.example.HumanResourceApp.Repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository DepartmentRepo;

	@Override
	public Department addNewDepartment(Department department) {
		if(DepartmentRepo.existsById(department.getDepartment_id())) {
			throw new AllReadyExistsException(null);
		}
		return DepartmentRepo.save(department);
	}

	@Override
	public Department updateDepartment(BigDecimal departmentId, Department updatedDepartment) {
		if(!DepartmentRepo.existsById(departmentId)) {
			throw new DepartmentNotFoundException(departmentId);
		}
		
		Department existingDepartment = DepartmentRepo.findById(departmentId).get();
		
		existingDepartment.setDepartment_name(updatedDepartment.getDepartment_name());
		existingDepartment.setManager_id(updatedDepartment.getManager_id());
		existingDepartment.setLocation_id(updatedDepartment.getLocation_id());
		return DepartmentRepo.save(existingDepartment);
	}
}
