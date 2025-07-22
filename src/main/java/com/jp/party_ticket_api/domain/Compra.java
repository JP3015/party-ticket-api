package com.jp.party_ticket_api.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_COMPRA_INGRESSO")
public class Compra extends PresencaEvento{


	@Column(name = "QUANTIDADE_INGRESSOS", nullable = false)
	private int quantidadeIngressos;
	
	@Column(name = "DT_COMPRA", nullable = false)
	private LocalDateTime dataCompra;
	
	@ManyToOne
    @JoinColumn(name = "ID_EVENTO")
	private Balada balada;
	
	public Compra() {}

	public Compra(int quantidadeIngressos, LocalDateTime dataCompra, Balada balada) {
		super();
		this.quantidadeIngressos = quantidadeIngressos;
		this.dataCompra = dataCompra;
		this.balada = balada;
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

	public Balada getBalada() {
		return balada;
	}

	public void setBalada(Balada balada) {
		this.balada = balada;
	}

}
