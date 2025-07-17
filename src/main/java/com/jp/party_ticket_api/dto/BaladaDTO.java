package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import com.jp.party_ticket_api.domain.Balada;


public class BaladaDTO {
	
	private Long id;
	private String nomeEvento;
	private LocalDateTime data;
	private String local;
	private int ingressosDisponiveis;
	private int capacidade;
	
	public BaladaDTO() {}
	
	public BaladaDTO(Balada balada) {
		this.id = balada.getId();
	    this.nomeEvento = balada.getNomeEvento();
	    this.data = balada.getData();
	    this.local = balada.getLocal();
	    this.ingressosDisponiveis = balada.getIngressosDisponiveis();
	    this.capacidade = balada.getCapacidade();
	}
	
	public BaladaDTO(Long id, String nomeEvento, LocalDateTime data, String local, int ingressosDisponiveis,
			int capacidade) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.ingressosDisponiveis = ingressosDisponiveis;
		this.capacidade = capacidade;
	}
	
	public BaladaDTO(String nomeEvento, LocalDateTime data, String local, int ingressosDisponiveis,
			int capacidade) {
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.ingressosDisponiveis = ingressosDisponiveis;
		this.capacidade = capacidade;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public int getIngressosDisponiveis() {
		return ingressosDisponiveis;
	}
	public void setIngressosDisponiveis(int ingressosDisponiveis) {
		this.ingressosDisponiveis = ingressosDisponiveis;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
