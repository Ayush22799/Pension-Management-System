package com.cts.authorization.exception;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// Handles all the global exceptions
 
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	 // Handles input validation errors
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorResponse response = new ErrorResponse();
		response.setMessage("Invalid Credentials");
		response.setTimestamp(LocalDateTime.now());

		// Get all validation errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());

		// Add errors to the response map
		response.setFieldErrors(errors);

		return new ResponseEntity<>(response, headers, status);
	}


	
	 // Handles invalid credentials exception
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handlesUserNotFoundException(
			InvalidCredentialsException invalidCredentialsException) {
		String errorMessage = invalidCredentialsException.getMessage();
		ErrorResponse response = new ErrorResponse(errorMessage, LocalDateTime.now(), Collections.singletonList(errorMessage));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	
	 // Handles invalid token exceptions
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ErrorResponse> handlesTokenInvalidException(InvalidTokenException invalidTokenException) {
		String errorMessage = invalidTokenException.getMessage();
		ErrorResponse response = new ErrorResponse(errorMessage, LocalDateTime.now(), Collections.singletonList(errorMessage));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
