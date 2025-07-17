package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import com.jp.party_ticket_api.domain.Balada;

public class CompraDTO {
	
	private Long id;
	private String nome;
	private String email;
	private int quantidadeIngressos;
	private LocalDateTime dataCompra;
	private BaladaDTO balada;
	
	public CompraDTO() {}
	
	public CompraDTO(Long id, String nome, String email, int quantidadeIngressos,
			LocalDateTime dataCompra, Balada balada) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
		this.balada = new BaladaDTO(balada);
	}

	public CompraDTO(String nome, String email, int quantidadeIngressos,
			LocalDateTime dataCompra) {
		this.nome = nome;
		this.email = email;
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaladaDTO getBalada() {
		return balada;
	}

	public void setBalada(BaladaDTO balada) {
		this.balada = balada;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}
	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}
	
}
