package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventoDTO {
	
	@NotBlank(message = "O nome do evento é obrigatório.")
	private String nomeEvento;
	
	@NotNull(message = "A data do evento é obrigatória.")
	private LocalDateTime data;
	
	@NotBlank(message = "O local do evento é obrigatório.")
	private String local;
	
	@Min(value = 1, message = "A capacidade deve ser maior que zero.")
	private int quantidadeIngressos;
	
	
	public EventoDTO(String nomeEvento, LocalDateTime data, String local, int quantidadeIngressos) {
		this.nomeEvento = nomeEvento;
		this.data = data;
		this.local = local;
		this.quantidadeIngressos = quantidadeIngressos;
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
		return quantidadeIngressos;
	}
	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}
	
}
