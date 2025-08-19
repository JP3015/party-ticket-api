package com.jp.party_ticket_api.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioNaoEncontradoException extends UsernameNotFoundException {
    public UsuarioNaoEncontradoException(String username) {
        super("Usuário não encontrado com nome: " + username);
    }
}

