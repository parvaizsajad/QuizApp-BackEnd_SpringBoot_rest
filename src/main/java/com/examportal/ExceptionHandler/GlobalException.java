package com.examportal.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exeptionHandle(Exception ex){
		return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
		
	}
}
