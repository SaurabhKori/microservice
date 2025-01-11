package com.sk.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sk.hotelservice.response.ApiResponse;

@RestControllerAdvice
public class GlobelException {
	@ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException excep){
		String message=excep.getMessage();
		ApiResponse response =ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
 }
}
