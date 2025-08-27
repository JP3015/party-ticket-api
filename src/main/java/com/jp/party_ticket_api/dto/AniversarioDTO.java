package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import com.jp.party_ticket_api.domain.Aniversario;

public class AniversarioDTO {

	private Long id;
	private String nomeEvento;
	private LocalDateTime data;
	private String local;
	private String nomeAniversariante;
	private int idadeAniversariante;
	private int capacidade;
	private int capacidadeRestante;
	
	
	public AniversarioDTO() {}


	public AniversarioDTO(Aniversario aniversario, int capacidadeRestante) {
		this.id = aniversario.getId();
	    this.nomeEvento = aniversario.getNomeEvento();
	    this.data = aniversario.getData();
	    this.local = aniversario.getLocal();
	    this.nomeAniversariante = aniversario.getNomeAniversariante();
		this.idadeAniversariante = aniversario.getIdadeAniversariante();
		this.capacidade = aniversario.getCapacidade();
		this.capacidadeRestante = capacidadeRestante;
	}

	public AniversarioDTO(Long id, String nomeEvento, LocalDateTime data, String local, String nomeAniversariante,
			int idadeAniversariante, int capacidade, int capacidadeRestante) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.nomeAniversariante = nomeAniversariante;
		this.idadeAniversariante = idadeAniversariante;
		this.capacidade = capacidade;
		this.capacidadeRestante = capacidadeRestante;
	}
	
	public AniversarioDTO(String nomeEvento, LocalDateTime data, String local, String nomeAniversariante,
			int idadeAniversariante, int capacidade, int capacidadeRestante) {
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.nomeAniversariante = nomeAniversariante;
		this.idadeAniversariante = idadeAniversariante;
		this.capacidade = capacidade;
		this.capacidadeRestante = capacidadeRestante;
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
	public String getNomeAniversariante() {
		return nomeAniversariante;
	}
	public void setNomeAniversariante(String nomeAniversariante) {
		this.nomeAniversariante = nomeAniversariante;
	}
	public int getIdadeAniversariante() {
		return idadeAniversariante;
	}
	public void setIdadeAniversariante(int idadeAniversariante) {
		this.idadeAniversariante = idadeAniversariante;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getCapacidadeRestante() {
		return capacidadeRestante;
	}

	public void setCapacidadeRestante(int capacidadeRestante) {
		this.capacidadeRestante = capacidadeRestante;
	}
	
	
}
