package com.jp.party_ticket_api.domain;

import java.time.LocalDateTime;

public class Compra {
	
	private Long id;
	
	private String nomeComprador;
	
	private String email;
	
	private int quantidadeIngressos;
	
	private LocalDateTime dataCompra;
	
	private Evento evento;
	
	
	
	public Compra(Long id, String nomeComprador, String email, int quantidadeIngressos, LocalDateTime dataCompra,
			Evento evento) {
		this.id = id;
		this.nomeComprador = nomeComprador;
		this.email = email;
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
		this.evento = evento;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	

}
