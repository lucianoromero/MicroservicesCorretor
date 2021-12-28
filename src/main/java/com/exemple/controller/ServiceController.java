package com.exemple.controller;

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
import com.exemple.dto.ResponseDTO;
import com.exemple.service.query.QueryGetCorretorService;
import com.exemple.service.update.UpdateCorretorService;

@RestController
@RequestMapping("/v1")
public class ServiceController {

	@Autowired
	QueryGetCorretorService corretorServices;
	
	@Autowired
	UpdateCorretorService updateCorretorService;

	@GetMapping
	public ResponseEntity<ResponseDTO> consulta(@RequestParam(value = "document") String document) {
		return corretorServices.consultarDadosDoCorretor(document);
	}
	
	@PutMapping("/{document}")
	public ResponseEntity<CorretorStatusDTO> atualizar(@PathVariable String document,@RequestBody CorretorStatusDTO corretorStatusDTO) {		
		return updateCorretorService.consultarDadosDoCorretor(document, corretorStatusDTO);
	}
}
