package com.exemple.service.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemple.dto.CorretorDadosDTO;
import com.exemple.dto.CorretorStatusDTO;
import com.exemple.service.connector.DetalhesdoCadastrodoCorretorConnectorService;
import com.exemple.service.connector.ServicosdoCorretorConnectorService;
import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@Service
public class UpdateCorretorService {

	@Autowired
	DetalhesdoCadastrodoCorretorConnectorService detalhesdoCadastrodoCorretorService;

	@Autowired
	ServicosdoCorretorConnectorService corretorService;

	public ResponseEntity<CorretorStatusDTO> consultarDadosDoCorretor(String document, CorretorStatusDTO corretorStatus ) {
		try {
			CorretorDadosDTO corretorDados = detalhesdoCadastrodoCorretorService.getDetalhesdoCadastrodoCorretor(document);
			CorretorStatusDTO corretorStatusResponse = corretorService.putServicosdoCorretorService(corretorDados.getCode(), corretorStatus);		
			return ResponseEntity.ok().body(corretorStatusResponse);
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(document);
		}
	}

}
