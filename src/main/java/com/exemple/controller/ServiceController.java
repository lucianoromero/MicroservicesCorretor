package com.exemple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.dto.output.RespostaDTO;
import com.exemple.service.query.QueryGetCorretorServices;

@RestController
@RequestMapping("/v1")
public class ServiceController {

	@Autowired
	QueryGetCorretorServices corretorServices;

	@GetMapping
	public ResponseEntity<RespostaDTO> detalhar(@RequestParam(value = "document") String document) {
		return corretorServices.consultarDadosDoCorretor(document);
	}
}
