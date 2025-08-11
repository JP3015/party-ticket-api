package com.jp.party_ticket_api.exception;

public class emailRepetidoException extends RuntimeException{
	
	public emailRepetidoException(){
	    super("Já foi utilizado este email.");
	}
}
