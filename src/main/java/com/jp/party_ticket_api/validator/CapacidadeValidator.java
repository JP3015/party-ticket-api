package com.jp.party_ticket_api.validator;

import org.springframework.stereotype.Component;

import com.jp.party_ticket_api.exception.ExcedeuCapacidadeException;

@Component
public class CapacidadeValidator {
	
	public void validarCapacidade(int capacidadeRestante) {
		if(capacidadeRestante == 0) {
			throw new ExcedeuCapacidadeException("A quantidade de convidados excedeu a capacidade permitida.");
		}
	}
	
	public void validarCapacidade(int capacidade, int ingressosDisponiveis) {
		if(capacidade < ingressosDisponiveis) {
			throw new ExcedeuCapacidadeException();
		}
	}

}
