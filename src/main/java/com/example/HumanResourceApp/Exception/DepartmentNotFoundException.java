package com.example.HumanResourceApp.Exception;

import java.math.BigDecimal;

public class DepartmentNotFoundException extends RuntimeException {
	
	public DepartmentNotFoundException (String msg){ 
		
		super(msg);
	}

	public DepartmentNotFoundException(BigDecimal departmentId) {
		// TODO Auto-generated constructor stub
	}

}
