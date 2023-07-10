package com.ohgiraffers.securitysession.auth.command.domain.aggregate.vo;

public enum UserRole {
    ADMIN("ADMIN"), USER("USER");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
