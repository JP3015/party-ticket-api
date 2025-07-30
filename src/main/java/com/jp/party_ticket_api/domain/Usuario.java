package com.jp.party_ticket_api.domain;

import com.jp.party_ticket_api.domain.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long id;
	
	@Column(name = "NOME_USUARIO", nullable = false, length = 100, unique = true)
	private String nomeUsuario;
	
	@Column(name = "EMAIL", nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(name = "SENHA", nullable = false, length = 100)
	private String senha;
	
	@Column(name = "ROLE", nullable = false, length = 100)
	private Role role;
	
	public Usuario() {}

	public Usuario(String nomeUsuario, String senha, Role role) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
