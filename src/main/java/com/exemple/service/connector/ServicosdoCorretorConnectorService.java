package com.exemple.service.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exemple.dto.CorretorStatusDto;
import com.exemple.dto.CorretorStatusFrom;

@FeignClient(name = "detalhes-dos-dados-do-corretor", url = "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData/")
public interface ServicosdoCorretorConnectorService {
	
	@GetMapping("{code}")
	CorretorStatusDto getServicosdoCorretorService(@PathVariable("code") String code);
	
	@PutMapping("{code}")
	CorretorStatusDto putServicosdoCorretorService(@PathVariable("code") String code, @RequestBody CorretorStatusFrom corretorStatusFROM);
	
}
