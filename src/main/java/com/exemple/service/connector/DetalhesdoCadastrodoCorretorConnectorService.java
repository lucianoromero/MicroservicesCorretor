package com.exemple.service.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.exemple.dto.CorretorDadosDTO;

@FeignClient(name = "servico-de-corretor", url = "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/broker/")
public interface DetalhesdoCadastrodoCorretorConnectorService {

	@GetMapping("{document}")
	CorretorDadosDTO getDetalhesdoCadastrodoCorretor(@PathVariable("document") String document);
}
