package com.exemple.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.dto.CorretorStatusDTO;
import com.exemple.dto.CorretorStatusFROM;
import com.exemple.dto.ResponseDTO;
import com.exemple.service.query.QueryGetCorretorService;
import com.exemple.service.update.UpdateCorretorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Microservice API Corretor")
@RestController
@RequestMapping("/v1")
public class ServiceController {

	@Autowired
	QueryGetCorretorService corretorServices;
	
	@Autowired
	UpdateCorretorService updateCorretorService;

	@Operation(description = "Consulta Corretor")
	@GetMapping
	public ResponseEntity<ResponseDTO> consulta(@RequestParam(value = "document") String document) {
		return corretorServices.consultarDadosDoCorretor(document);
	}
	
	@Operation(description = "Atualiza Corretor")
	@PutMapping("/{document}")
	public ResponseEntity<CorretorStatusDTO> atualizar(@PathVariable String document, @Valid @RequestBody CorretorStatusFROM corretorStatusFROM) {		
		return updateCorretorService.atualizarDadosDoCorretor(document, corretorStatusFROM);
	}
}
