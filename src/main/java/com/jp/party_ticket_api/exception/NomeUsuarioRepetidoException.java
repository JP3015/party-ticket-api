package com.jp.party_ticket_api.exception;

public class NomeUsuarioRepetidoException extends RuntimeException {
	public NomeUsuarioRepetidoException(String nome) {
	    super("O nome de usuário " + nome + " já existe.");
	}
}
