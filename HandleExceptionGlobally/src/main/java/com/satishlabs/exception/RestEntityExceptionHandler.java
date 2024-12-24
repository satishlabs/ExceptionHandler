package com.satishlabs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler({CustomerIDNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCidNotFound(){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setTimstamp(LocalDateTime.now());
		errMsg.setError("Customer Id Not available");
		errMsg.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorMessage>(errMsg, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({InvalidPhoneNumberException.class})
	public ResponseEntity<ErrorMessage> handlePhoneNotFound(){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setTimstamp(LocalDateTime.now());
		errMsg.setError("Phone Number is Not Available");
		errMsg.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorMessage>(errMsg, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({CityNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCityNotFound(){
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setTimstamp(LocalDateTime.now());
		errMsg.setError("City Not Found in DB");
		errMsg.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorMessage>(errMsg, HttpStatus.NOT_FOUND);
	}
}
