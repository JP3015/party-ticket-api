package com.jp.party_ticket_api.exception;

public class ExcedeuCapacidadeException extends RuntimeException{
	
	public ExcedeuCapacidadeException() {
	    super("A quantidade de ingressos excede a capacidade permitida.");
	}
	
	public ExcedeuCapacidadeException(String string) {
	    super(string);
	}
}
