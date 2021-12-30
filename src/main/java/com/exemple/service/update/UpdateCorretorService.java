package com.exemple.service.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemple.dto.CorretorDadosDto;
import com.exemple.dto.CorretorStatusDto;
import com.exemple.dto.CorretorStatusFrom;
import com.exemple.service.connector.DetalhesdoCadastrodoCorretorConnectorService;
import com.exemple.service.connector.ServicosdoCorretorConnectorService;
import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@Service
public class UpdateCorretorService {

	@Autowired
	DetalhesdoCadastrodoCorretorConnectorService detalhesdoCadastrodoCorretorService;

	@Autowired
	ServicosdoCorretorConnectorService corretorService;

	public ResponseEntity<CorretorStatusDto> atualizarDadosDoCorretor(String document, CorretorStatusFrom corretorStatusFROM ) {
		try {
			CorretorDadosDto corretorDados = detalhesdoCadastrodoCorretorService.getDetalhesdoCadastrodoCorretor(document);
			CorretorStatusDto corretorStatusResponse = corretorService.putServicosdoCorretorService(corretorDados.getCode(), corretorStatusFROM);		
			return ResponseEntity.ok().body(corretorStatusResponse);
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(document);
		}
	}

}
