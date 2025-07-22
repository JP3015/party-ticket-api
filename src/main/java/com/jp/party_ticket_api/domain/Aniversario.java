package com.jp.party_ticket_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ANIVERSARIO")
public class Aniversario extends Evento{
	
	@Column(name = "NOME_ANIVERSARIANTE", nullable = false, length = 100)
	private String nomeAniversariante;
	
	@Column(name = "IDADE_ANIVERSARIANTE", nullable = false)
	private int idadeAniversariante;
	
	public Aniversario() {}

	public Aniversario(String nomeAniversariante, int idadeAniversariante) {
		super();
		this.nomeAniversariante = nomeAniversariante;
		this.idadeAniversariante = idadeAniversariante;
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
}
