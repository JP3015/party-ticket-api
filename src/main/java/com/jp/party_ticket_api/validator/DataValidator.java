package com.jp.party_ticket_api.validator;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.jp.party_ticket_api.exception.DataException;

@Component
public class DataValidator {

	public void validarData(LocalDate data) {
		if(data.isBefore(LocalDate.now())) {
			throw new DataException();
		}
	}
}
