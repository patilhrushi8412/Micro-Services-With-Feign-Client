package com.te.hotelservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.hotelservice.customexception.CustomException;
import com.te.hotelservice.responce.Responce;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
	public ResponseEntity<Responce> customExceptionHandler(CustomException exception) {
		return new ResponseEntity<Responce>(new Responce(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
