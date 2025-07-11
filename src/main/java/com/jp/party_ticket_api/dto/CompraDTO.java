package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import com.jp.party_ticket_api.domain.Evento;

public class CompraDTO {
	
	private Long idComprador;
	private String nomeComprador;
	private String email;
	private int quantidadeIngressos;
	private LocalDateTime dataCompra;
	private EventoDTO evento;
	
	public CompraDTO() {}
	
	public CompraDTO(Long idComprador, String nomeComprador, String email, int quantidadeIngressos,
			LocalDateTime dataCompra, Evento evento) {
		this.idComprador = idComprador;
		this.nomeComprador = nomeComprador;
		this.email = email;
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
		this.evento = new EventoDTO(evento);
	}

	public CompraDTO(String nomeComprador, String email, int quantidadeIngressos,
			LocalDateTime dataCompra) {
		this.nomeComprador = nomeComprador;
		this.email = email;
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}
	
	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
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
	
}
