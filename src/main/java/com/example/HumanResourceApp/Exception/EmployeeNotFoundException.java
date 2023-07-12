package com.example.HumanResourceApp.Exception;

public class EmployeeNotFoundException  extends RuntimeException{
	
	public EmployeeNotFoundException(String msg) {
        super(msg);
    }

}
