package com.jp.party_ticket_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONVIDADO")
public class Convidado extends PresencaEvento{
	
	@ManyToOne
    @JoinColumn(name = "ID_EVENTO")
	private Aniversario aniversario;
	
	public Convidado() {}

	public Convidado(Aniversario aniversario) {
		super();
		this.aniversario = aniversario;
	}

	public Aniversario getAniversario() {
		return aniversario;
	}

	public void setAniversario(Aniversario aniversario) {
		this.aniversario = aniversario;
	}
}
