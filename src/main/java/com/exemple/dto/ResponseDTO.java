package com.exemple.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseDTO {

	@JsonProperty("Nome")
	private String name;
	@JsonProperty("Documento")
	private String document;
	@JsonProperty("Código")
	private String code;
	@JsonProperty("Data de Criação")
	private String createDate;
	@JsonProperty("Taxa de Comissão")
	private String commissionRule;
	@JsonProperty("Flag Ativo")
	private String status;
	@JsonProperty("Mensagem")
	private String mensagem;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCommissionRule() {
		return commissionRule;
	}

	public void setCommissionRule(String commissionRule) {
		this.commissionRule = commissionRule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
