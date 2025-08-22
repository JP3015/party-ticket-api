package com.jp.party_ticket_api.dto;

import com.jp.party_ticket_api.domain.Usuario;
public class UsuarioDTO {
	private String nomeUsuario;
	private String email;
	private String role;
	
	public UsuarioDTO(Usuario usuario) {
		this.nomeUsuario = usuario.getNomeUsuario();
		this.email = usuario.getEmail();
		this.role = usuario.getRole().getDescricao();
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}

