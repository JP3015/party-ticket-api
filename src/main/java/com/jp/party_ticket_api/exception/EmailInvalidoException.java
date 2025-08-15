package com.jp.party_ticket_api.exception;

public class EmailInvalidoException extends RuntimeException {
	public EmailInvalidoException(String email){
	    super("O email" + email + " é inválido.");
	}
}
