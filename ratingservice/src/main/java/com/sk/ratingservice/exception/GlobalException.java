package com.sk.ratingservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(ResoursceNotFoundException.class)
   public ResponseEntity<Map<String, Object>> handlerResourceNotFoundException(ResoursceNotFoundException res){
	   Map<String,Object> respons=new HashMap();
	   respons.put("message",res.getMessage());
	   respons.put("success", true);
	   respons.put("status",HttpStatus.NOT_FOUND);
	   return new ResponseEntity<>(respons,HttpStatus.NOT_FOUND);
   }
}
