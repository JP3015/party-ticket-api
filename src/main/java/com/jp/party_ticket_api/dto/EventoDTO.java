package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventoDTO {
	
	private String nomeEvento;
	private LocalDateTime data;
	private String local;
	private int ingressosDisponiveis;
	private int capacidade;
	
	public EventoDTO() {}
	
	public EventoDTO(String nomeEvento, LocalDateTime data, String local, int ingressosDisponiveis, int capacidade) {
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.ingressosDisponiveis = ingressosDisponiveis;
		this.capacidade = capacidade;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getQuantidadeIngressos() {
		return ingressosDisponiveis;
	}
	public void setQuantidadeIngressos(int ingressosDisponiveis) {
		this.ingressosDisponiveis = ingressosDisponiveis;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
