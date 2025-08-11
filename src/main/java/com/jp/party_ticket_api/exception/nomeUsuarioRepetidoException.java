package com.jp.party_ticket_api.exception;

public class nomeUsuarioRepetidoException extends RuntimeException {
	public nomeUsuarioRepetidoException() {
	    super("O nome de usuário já existe.");
	}
}
