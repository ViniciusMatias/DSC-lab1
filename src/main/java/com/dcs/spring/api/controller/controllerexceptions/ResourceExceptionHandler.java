package com.dcs.spring.api.controller.controllerexceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dcs.spring.api.services.exception.EntityNotFoundEx;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntityNotFoundEx.class)
	public ResponseEntity<StandardError> entityNotFound( EntityNotFoundEx ex , HttpServletRequest request )
	{
		StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Conteudo não existe !", ex.getMessage(), request.getRequestURI());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
		
}
