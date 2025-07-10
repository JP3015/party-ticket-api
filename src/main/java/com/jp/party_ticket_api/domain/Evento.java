package com.jp.party_ticket_api.domain;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_EVENTO")
public class Evento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVENTO")
	private Long id;
	
	@Column(name = "NOME_EVENTO", nullable = false, length = 100)
	private String nomeEvento;
	
	@Column(name = "DATA", nullable = false)
	private LocalDateTime data;
	
	@Column(name = "LOCAL", nullable = false, length = 100)
	private String local;
	
	@Column(name = "CAPACIDADE", nullable = false)
	private int capacidade;
	
	@Column(name = "QUANTIDADE_INGRESSOS_DISPONIVEIS", nullable = false)
	private int ingressosDisponiveis;
	
	public Evento() {}
	
	public Evento(Long id, String nomeEvento, LocalDateTime data, String local, int capacidade,
			int ingressosDisponiveis) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.capacidade = capacidade;
		this.ingressosDisponiveis = ingressosDisponiveis;
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
