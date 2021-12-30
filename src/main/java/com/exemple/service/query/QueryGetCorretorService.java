package com.exemple.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemple.dto.CorretorDadosDto;
import com.exemple.dto.CorretorStatusDto;
import com.exemple.dto.ResponseDto;
import com.exemple.service.connector.DetalhesdoCadastrodoCorretorConnectorService;
import com.exemple.service.connector.ServicosdoCorretorConnectorService;
import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@Service
public class QueryGetCorretorService {

	@Autowired
	DetalhesdoCadastrodoCorretorConnectorService detalhesdoCadastrodoCorretorService;

	@Autowired
	ServicosdoCorretorConnectorService corretorService;

	public ResponseEntity<ResponseDto> consultarDadosDoCorretor(String document) {
		try {
			CorretorDadosDto corretorDados = detalhesdoCadastrodoCorretorService.getDetalhesdoCadastrodoCorretor(document);
			CorretorStatusDto corretorStatus = corretorService.getServicosdoCorretorService(corretorDados.getCode());
			ResponseDto respostaFron = bindRespostaFron(corretorDados, corretorStatus);
			return ResponseEntity.ok().body(respostaFron);
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(document);
		}
	}

	private ResponseDto bindRespostaFron(CorretorDadosDto corretorDados, CorretorStatusDto corretorStatus) {
		ResponseDto respostaFron = new ResponseDto();
		if (corretorStatus.getActive().equals("true")) {
			respostaFron.setName(corretorDados.getName());
			respostaFron.setDocument(corretorDados.getDocument());
			respostaFron.setCode(corretorDados.getCode());
			respostaFron.setCreateDate(corretorDados.getCreateDate());
			respostaFron.setCommissionRule(corretorStatus.getCommissionRate());
			respostaFron.setStatus(corretorStatus.getActive());
			return respostaFron;
		} else {
			respostaFron.setName(corretorDados.getName());
			respostaFron.setDocument(corretorDados.getDocument());
			respostaFron.setMensagem("Corretor não está ativo");
			return respostaFron;
		}

	}

}
