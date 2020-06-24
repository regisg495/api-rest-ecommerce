package com.ecommercerest.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

    @Size(max = 50, message = "O campo email ultrapassa o limite de caracteres")
    @NotNull(message = "O campo email é necessário")
    @NotEmpty(message = "O campo email é necessário")
    private String email;

    //@Min(value = 8, message = "A senha deve ter pelo menos 8 caracteres")
    //@Max(value = 30, message = "A senha deve ter no máximo 30 caracteres")
    @NotNull(message = "O campo senha é necessário")
    @NotEmpty(message = "O campo senha é necessário")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }

}
