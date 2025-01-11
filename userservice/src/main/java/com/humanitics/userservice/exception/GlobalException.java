package com.humanitics.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.humanitics.userservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resexcep){
	String message=resexcep.getMessage();
	ApiResponse response=	ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
}
}
