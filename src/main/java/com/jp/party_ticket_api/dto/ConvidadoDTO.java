package com.jp.party_ticket_api.dto;

import com.jp.party_ticket_api.domain.Aniversario;

public class ConvidadoDTO {

	
	private Long id;
	private String nome;
	private String email;
	private AniversarioDTO aniversario;
	
	public ConvidadoDTO() {}

	public ConvidadoDTO(Long id, String nome, String email, Aniversario aniversario) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.aniversario = new AniversarioDTO(aniversario);
	}
	
	public ConvidadoDTO(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AniversarioDTO getAniversario() {
		return aniversario;
	}
	public void setAniversario(AniversarioDTO aniversario) {
		this.aniversario = aniversario;
	}	
}
