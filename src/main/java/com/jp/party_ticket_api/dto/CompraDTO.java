package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompraDTO {
	
	private String nomeComprador;
	private String email;
	private int quantidadeIngressos;
	private LocalDateTime dataCompra;
	private String nomeEvento;
	
	public CompraDTO() {}
	
	public CompraDTO(String nomeComprador, String email, int quantidadeIngressos, LocalDateTime dataCompra,
			String nomeEvento) {
		this.nomeComprador = nomeComprador;
		this.email = email;
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
		this.nomeEvento = nomeEvento;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}
	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
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

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
}
