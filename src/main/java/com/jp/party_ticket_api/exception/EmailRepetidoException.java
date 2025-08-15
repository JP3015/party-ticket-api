package com.jp.party_ticket_api.exception;

public class EmailRepetidoException extends RuntimeException{
	
	public EmailRepetidoException(String email){
	    super("O email" + email + " já está sendo utilizado.");
	}
}
