package com.jp.party_ticket_api.dto;

public class TokenDTO {
	
	private String token;

	public TokenDTO() {}

	public TokenDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
