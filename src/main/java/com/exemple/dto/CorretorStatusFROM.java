package com.exemple.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CorretorStatusFROM {

	@NotNull
	@NotEmpty
	private String active;

	@NotNull
	@NotEmpty
	private String commissionRate;

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}

}
