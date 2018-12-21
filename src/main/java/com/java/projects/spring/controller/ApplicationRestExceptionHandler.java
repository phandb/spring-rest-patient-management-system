package com.java.projects.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationRestExceptionHandler {
	
	//Add an exception handler for PatientNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<ApplicationErrorResponse> handleException(PatientNotFoundException exc){
		
		//create PatientErrorResponse
		
		ApplicationErrorResponse error = new ApplicationErrorResponse(HttpStatus.NOT_FOUND.value(),
																	  exc.getMessage(),
																	  System.currentTimeMillis());
		
		//return ReponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	//Add another exception handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<ApplicationErrorResponse> handleException(Exception exc){
		
		//create PatientErrorResponse
		
				ApplicationErrorResponse error = new ApplicationErrorResponse(HttpStatus.BAD_REQUEST.value(),
																			  exc.getMessage(),
																			  System.currentTimeMillis());
				
				//return ReponseEntity
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
