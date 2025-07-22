package com.jp.party_ticket_api.dto;

public class LoginDTO {

	private String nomeUsuario;
	private String email;
	private String senha;
	
	public LoginDTO() {}

	public LoginDTO(String nomeUsuario, String email, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
