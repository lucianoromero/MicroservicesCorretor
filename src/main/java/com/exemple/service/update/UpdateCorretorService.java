package com.exemple.service.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemple.dto.CorretorDadosDTO;
import com.exemple.dto.CorretorStatusDTO;
import com.exemple.dto.CorretorStatusFROM;
import com.exemple.service.connector.DetalhesdoCadastrodoCorretorConnectorService;
import com.exemple.service.connector.ServicosdoCorretorConnectorService;
import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@Service
public class UpdateCorretorService {

	@Autowired
	DetalhesdoCadastrodoCorretorConnectorService detalhesdoCadastrodoCorretorService;

	@Autowired
	ServicosdoCorretorConnectorService corretorService;

	public ResponseEntity<CorretorStatusDTO> atualizarDadosDoCorretor(String document, CorretorStatusFROM corretorStatusFROM ) {
		try {
			CorretorDadosDTO corretorDados = detalhesdoCadastrodoCorretorService.getDetalhesdoCadastrodoCorretor(document);
			CorretorStatusDTO corretorStatusResponse = corretorService.putServicosdoCorretorService(corretorDados.getCode(), corretorStatusFROM);		
			return ResponseEntity.ok().body(corretorStatusResponse);
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(document);
		}
	}

}
