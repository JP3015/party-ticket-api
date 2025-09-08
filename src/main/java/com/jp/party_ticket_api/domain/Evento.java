package com.jp.party_ticket_api.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Evento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVENTO")
	protected Long id;
	
	@Column(name = "NOME_EVENTO", nullable = false, length = 100)
	protected String nomeEvento;
	
	@Column(name = "DATA", nullable = false)
	protected LocalDate data;
	
	@Column(name = "LOCAL", nullable = false, length = 100)
	protected String local;
	
	@Column(name = "CAPACIDADE", nullable = false)
	protected int capacidade;
	
	public Evento() {}

	public Evento(Long id, String nomeEvento, LocalDate data, String local, int capacidade) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
	
}
