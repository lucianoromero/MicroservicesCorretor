package com.exemple.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CorretorStatusDTO {

	@JsonProperty("code")
	private String code;
	@JsonProperty("active")
	private String active;
	@JsonProperty("commissionRate")
	private String commissionRate;

	public CorretorStatusDTO(String code, String active, String commissionRate) {
		this.code = code;
		this.active = active;
		this.commissionRate = commissionRate;
	}

	public CorretorStatusDTO() {

	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("active")
	public String getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(String active) {
		this.active = active;
	}

	@JsonProperty("commissionRate")
	public String getCommissionRate() {
		return commissionRate;
	}

	@JsonProperty("commissionRate")
	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

}
