package com.umashankar.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(UserException e,WebRequest req){
		ErrorDetails error = new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

}
