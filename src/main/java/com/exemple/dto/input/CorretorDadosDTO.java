package com.exemple.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CorretorDadosDTO {

	@JsonProperty("name")
	private String name;
	@JsonProperty("document")
	private String document;
	@JsonProperty("code")
	private String code;
	@JsonProperty("createDate")
	private String createDate;

	public CorretorDadosDTO(String name, String document, String code, String createDate) {
		this.name = name;
		this.document = document;
		this.code = code;
		this.createDate = createDate;
	}

	public CorretorDadosDTO() {

	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("document")
	public String getDocument() {
		return document;
	}

	@JsonProperty("document")
	public void setDocument(String document) {
		this.document = document;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("createDate")
	public String getCreateDate() {
		return createDate;
	}

	@JsonProperty("createDate")
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
