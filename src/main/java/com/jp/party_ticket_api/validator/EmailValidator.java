package com.jp.party_ticket_api.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.jp.party_ticket_api.exception.EmailInvalidoException;
import com.jp.party_ticket_api.exception.EmailRepetidoException;

@Component
public class EmailValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public void validarEmail(String email) {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new EmailInvalidoException(email);
        }
    }
    
    public void validarEmail(boolean response, String email) {
	    if (response) {
	        throw new EmailRepetidoException(email);
	    }
	}

}
