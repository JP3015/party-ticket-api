package com.jp.party_ticket_api.domain;

import jakarta.persistence.*;

@MappedSuperclass
public class PresencaEvento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected  Long id;
	
	@Column(name = "NOME", nullable = false, length = 100)
	protected  String nome;
	
	@Column(name = "EMAIL", nullable = false, length = 100)
	protected  String email;
	
	@Column(name = "CPF", nullable = false, length = 11)
	protected  String cpf;
	
	@Column(name = "RG", nullable = false, length = 9)
	protected  String rg;
	
	public PresencaEvento() {}

	public PresencaEvento(Long id, String nome, String email, String cpf, String rg) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nomeComprador) {
		this.nome = nomeComprador;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
