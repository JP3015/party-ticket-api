package com.jp.party_ticket_api.exception;

public class IngressosIndisponiveisException extends RuntimeException {
    
	public IngressosIndisponiveisException(String nomeEvento) {
	    super("Quantidade de ingressos solicitados indisponível para o evento: " + nomeEvento + ".");
	}
}
