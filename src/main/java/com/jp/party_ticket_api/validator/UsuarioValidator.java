package com.jp.party_ticket_api.validator;

import org.springframework.stereotype.Component;

import com.jp.party_ticket_api.exception.NomeUsuarioRepetidoException;

@Component
public class UsuarioValidator {
	
	public void validarNomeUsuario(boolean response ,String nomeUsuario) {
	    if (response) {
	        throw new NomeUsuarioRepetidoException(nomeUsuario);
	    }
	}
	
}
