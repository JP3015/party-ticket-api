package com.jp.party_ticket_api.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class ApiResponse {
    private LocalDateTime timestamp;
    private int status;
    private String mensagem;
    private String token;
    private Object dados;

    public ApiResponse(int status, String mensagem, Object dados) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.mensagem = mensagem;
        this.dados = dados;
    }
    
    public ApiResponse(int status, String mensagem, String token) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.mensagem = mensagem;
        this.token = token;
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getDados() {
		return dados;
	}

	public void setDados(Object dados) {
		this.dados = dados;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}

