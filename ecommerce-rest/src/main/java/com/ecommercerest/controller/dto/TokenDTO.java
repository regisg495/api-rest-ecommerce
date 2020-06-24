package com.ecommercerest.controller.dto;

public class TokenDTO {

    private final String token;
    private final String authencationType;

    public TokenDTO(String token, String authencationType) {
        this.token = token;
        this.authencationType = authencationType;
    }

    public String getToken() {
        return token;
    }

    public String getAuthencationType() {
        return authencationType;
    }
}
