package com.exemple.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exemple.dto.input.CorretorDadosDTO;
import com.exemple.dto.input.CorretorStatusDTO;
import com.exemple.dto.output.RespostaDTO;
import com.exemple.service.connector.DetalhesdoCadastrodoCorretorGetService;
import com.exemple.service.connector.ServicosdoCorretorGetService;
import com.exemple.service.query.exception.EntidadeNaoEncontradaException;

@Service
public class QueryGetCorretorServices {

	@Autowired
	DetalhesdoCadastrodoCorretorGetService detalhesdoCadastrodoCorretorService;

	@Autowired
	ServicosdoCorretorGetService corretorService;

	public ResponseEntity<RespostaDTO> consultarDadosDoCorretor(String document) {
		try {
			CorretorDadosDTO corretorDados = detalhesdoCadastrodoCorretorService
					.getDetalhesdoCadastrodoCorretor(document);
			CorretorStatusDTO corretorStatus = corretorService.getServicosdoCorretorService(corretorDados.getCode());
			RespostaDTO respostaFron = bindRespostaFron(corretorDados, corretorStatus);
			return ResponseEntity.ok().body(respostaFron);
		} catch (Exception e) {
			throw new EntidadeNaoEncontradaException(document);
		}
	}

	private RespostaDTO bindRespostaFron(CorretorDadosDTO corretorDados, CorretorStatusDTO corretorStatus) {
		RespostaDTO respostaFron = new RespostaDTO();
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
