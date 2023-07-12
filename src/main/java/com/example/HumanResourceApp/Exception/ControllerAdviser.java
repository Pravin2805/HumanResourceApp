package com.example.HumanResourceApp.Exception;

import java.net.http.HttpHeaders;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class ControllerAdviser  extends ResponseEntityExceptionHandler {
    //EXCEPTION HANDLER FOR CUSTOM EXCEPTION
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<ErrorResponse> handleEmptyInput(EmptyInputException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Field Are Empty  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Employee Not Found  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCountryNotFound(CountryNotFoundException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Country Not Found  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentNotFound(DepartmentNotFoundException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Department Not Found  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(JobNotFoundException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Job Not Found  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLocationNotFound(LocationNotFoundException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Location Not Found  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRegionNotFound(RegionNotFoundException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Region Not Found  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AllReadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAllReadyExists(AllReadyExistsException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," ID already Exists  , Validation Failed...");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }

    //EXCEPTION HANDLER FOR INBUILT EXCEPTION
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleHttpNoSuchElementException(NoSuchElementException e){
        Date ts = new Date(System.currentTimeMillis()); 
        DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd"); 
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString(),"ID not found, please enter valid ID");
        return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleHttpNullPointerException(NullPointerException e){
    Date ts = new Date(System.currentTimeMillis());
    DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
    ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString()," Field Are Null , Validation Failed...");
    return new ResponseEntity<ErrorResponse>(ErrRes, HttpStatus.NOT_ACCEPTABLE);
    }
    
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
    		org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    	 Date ts = new Date(System.currentTimeMillis()); 
    	DateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        ErrorResponse ErrRes = new ErrorResponse(sdf.format(ts).toString(),"Method not found ");
        return new ResponseEntity<Object>(ErrRes, HttpStatus.CONFLICT);
    }
    
}
