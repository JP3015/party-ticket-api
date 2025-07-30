package com.jp.party_ticket_api.dto;

import com.jp.party_ticket_api.domain.enums.Role;

public class LoginDTO {

	private String nomeUsuario;
	private String email;
	private String senha;
	private Role role;
	
	public LoginDTO() {}
	
	public LoginDTO(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
	
	public LoginDTO(String nomeUsuario, String email, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public LoginDTO(String nomeUsuario, String email, String senha, Role role) {
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
