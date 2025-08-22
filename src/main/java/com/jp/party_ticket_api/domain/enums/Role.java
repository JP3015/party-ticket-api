package com.jp.party_ticket_api.domain.enums;

public enum Role {
    ROLE_USER("Usuário"),
    ROLE_ADMIN("Administrador");

    private final String descricao;

    Role(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
