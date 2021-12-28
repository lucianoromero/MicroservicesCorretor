package com.exemple.exceptionhandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setTitulo("Corretor nao encontrado: " + ex.getMessage());

		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}

}
