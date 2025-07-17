package com.jp.party_ticket_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BALADA")
public class Balada extends Evento {
	
	@Column(name = "QUANTIDADE_INGRESSOS_DISPONIVEIS", nullable = false)
	private int ingressosDisponiveis;
    
    @Column(name = "VALOR_INVESTIDO")
    private double valorInvestido;

    @Column(name = "RECEITA_ESTIMADA")
    private double receitaEstimada;
    
    public Balada() {}

	public Balada(int ingressosDisponiveis, double valorInvestido, double receitaEstimada) {
		super();
		this.ingressosDisponiveis = ingressosDisponiveis;
		this.valorInvestido = valorInvestido;
		this.receitaEstimada = receitaEstimada;
	}

	public int getIngressosDisponiveis() {
		return ingressosDisponiveis;
	}

	public void setIngressosDisponiveis(int ingressosDisponiveis) {
		this.ingressosDisponiveis = ingressosDisponiveis;
	}

	public double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public double getReceitaEstimada() {
		return receitaEstimada;
	}

	public void setReceitaEstimada(double receitaEstimada) {
		this.receitaEstimada = receitaEstimada;
	}
}