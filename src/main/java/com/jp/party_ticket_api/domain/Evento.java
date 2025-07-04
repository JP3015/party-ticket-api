package com.jp.party_ticket_api.domain;

import java.time.LocalDateTime;

public class Evento {

	private Integer id;
	private String nomeEvento;
	private LocalDateTime data;
	private String local;
	private int capacidade;
	private int ingressosDisponiveis;
	
	public Evento(Integer id, String nomeEvento, LocalDateTime data, String local, int capacidade,
			int ingressosDisponiveis) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.capacidade = capacidade;
		this.ingressosDisponiveis = ingressosDisponiveis;
	}
	
	
	public void CompraIngresso(int quantidadeIngressos) {
		if(this.ingressosDisponiveis == 0) {
			System.out.println("Ingressos esgotados!");
		}else if(this.ingressosDisponiveis - quantidadeIngressos <= 0){
			System.out.println("Não há ingressos suficientes disponíveis para a quantidade solicitada.");
		}
		else {
			this.ingressosDisponiveis -= 1;
		}
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getIngressosDisponiveis() {
		return ingressosDisponiveis;
	}
	public void setIngressosDisponiveis(int ingressosDisponiveis) {
		this.ingressosDisponiveis = ingressosDisponiveis;
	}
	
	

}
