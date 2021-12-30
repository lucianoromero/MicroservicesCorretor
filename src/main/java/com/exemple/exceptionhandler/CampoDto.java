package com.exemple.exceptionhandler;

public class CampoDto {

	private String nome;
	private String mensagem;

	public CampoDto(String nome, String mensagem) {
		this.nome = nome;
		this.mensagem = mensagem;
	}

	public CampoDto() {

	}

	public String getNome() {
		return nome;
	}

	public String getMensagem() {
		return mensagem;
	}

}
