package com.jp.party_ticket_api.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompraDTO {
	
	@NotNull(message = "O ID do evento é obrigatório.")
	private Long idEvento; 
	
	@NotBlank(message = "O nome do comprador é obrigatório.")
	private String nomeComprador;
	
	@NotBlank(message = "O email é obrigatório.")
	private String email;
	
	@Min(value = 1, message = "A capacidade deve ser maior que zero.")
	private int quantidadeIngresso;
	
	@NotNull(message = "A data da compra é obrigatória.")
	private LocalDateTime dataCompra;
	

	public CompraDTO(Long idEvento,String nomeComprador, String email, int quantidadeIngresso, LocalDateTime dataCompra) {
		this.idEvento = idEvento;
		this.nomeComprador = nomeComprador;
		this.email = email;
		this.quantidadeIngresso = quantidadeIngresso;
		this.dataCompra = dataCompra;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeComprador() {
		return nomeComprador;
	}
	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuantidadeIngresso() {
		return quantidadeIngresso;
	}
	public void setQuantidadeIngresso(int quantidadeIngresso) {
		this.quantidadeIngresso = quantidadeIngresso;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
}
