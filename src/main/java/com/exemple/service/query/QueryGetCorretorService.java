package com.exemple.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemple.dto.CorretorDadosDTO;
import com.exemple.dto.CorretorStatusDTO;
import com.exemple.dto.ResponseDTO;
import com.exemple.service.connector.DetalhesdoCadastrodoCorretorConnectorService;
import com.exemple.service.connector.ServicosdoCorretorConnectorService;
import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@Service
public class QueryGetCorretorService {

	@Autowired
	DetalhesdoCadastrodoCorretorConnectorService detalhesdoCadastrodoCorretorService;

	@Autowired
	ServicosdoCorretorConnectorService corretorService;

	public ResponseEntity<ResponseDTO> consultarDadosDoCorretor(String document) {
		try {
			CorretorDadosDTO corretorDados = detalhesdoCadastrodoCorretorService.getDetalhesdoCadastrodoCorretor(document);
			CorretorStatusDTO corretorStatus = corretorService.getServicosdoCorretorService(corretorDados.getCode());
			ResponseDTO respostaFron = bindRespostaFron(corretorDados, corretorStatus);
			return ResponseEntity.ok().body(respostaFron);
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(document);
		}
	}

	private ResponseDTO bindRespostaFron(CorretorDadosDTO corretorDados, CorretorStatusDTO corretorStatus) {
		ResponseDTO respostaFron = new ResponseDTO();
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
