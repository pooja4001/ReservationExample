package com.cg.reservation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	private long currentTimeMillis = System.currentTimeMillis();
	private String errorMsg = "oops something is fishy! Id not Found in System";
	private String errorMsg1 = "!!!Please provide all the scheduledetails to add it in the database!!!";
	
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex){
		
		ErrorMessage exceptionResponse =
				new ErrorMessage(ex.getMessage(), 
						errorMsg,currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ReservationInvalidException.class)
	public final ResponseEntity<ErrorMessage> reservationInvalid(ReservationInvalidException ex){

		ErrorMessage exceptionResponse =
				new ErrorMessage(ex.getMessage(), 
						errorMsg,currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ReservationAlreadyPresentException.class)
	public final ResponseEntity<ErrorMessage> reservationNotfound(ReservationAlreadyPresentException ex){

		ErrorMessage exceptionResponse =
				new ErrorMessage(ex.getMessage(), 
						errorMsg,currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
		
	}

	

