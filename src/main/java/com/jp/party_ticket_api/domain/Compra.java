package com.jp.party_ticket_api.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_COMPRA")
public class Compra {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPRA")
	private Long id;
	
	@Column(name = "NOME_COMPRADOR", nullable = false, length = 100)
	private String nomeComprador;
	
	@Column(name = "EMAIL", nullable = false, length = 100)
	private String email;
	
	@Column(name = "QUANTIDADE_INGRESSOS", nullable = false)
	private int quantidadeIngressos;
	
	@Column(name = "DT_COMPRA", nullable = false)
	private LocalDateTime dataCompra;
	
	@ManyToOne
    @JoinColumn(name = "ID_EVENTO")
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
