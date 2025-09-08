package com.jp.party_ticket_api.validator;

import org.springframework.stereotype.Component;

import com.jp.party_ticket_api.exception.IngressosIndisponiveisException;

@Component
public class IngressosValidator {
	
	public void validarIngressosDisponiveis(int ingressosDisponiveis, int quantidadeIngressos, String nomeEvento) {
		if(quantidadeIngressos > 0 && ingressosDisponiveis < quantidadeIngressos) {
			throw new IngressosIndisponiveisException(nomeEvento);
		}
	}

}
