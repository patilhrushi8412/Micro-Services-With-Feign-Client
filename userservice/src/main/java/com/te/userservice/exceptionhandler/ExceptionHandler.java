package com.te.userservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.userservice.customexception.CustomException;
import com.te.userservice.responce.Responce;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
	public ResponseEntity<Responce> customExceptionHandler(CustomException exception) {
		return new ResponseEntity<Responce>(new Responce(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
