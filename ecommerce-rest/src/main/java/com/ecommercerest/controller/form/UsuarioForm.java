package com.ecommercerest.controller.form;

import com.ecommercerest.error.validation.PasswordMatches;
import com.ecommercerest.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@PasswordMatches(message = "As senhas não correspondem")
public class UsuarioForm {

    @Size(max = 200, message = "O campo nome ultrapassa o limite de caracteres")
    @NotNull(message = "O campo nome é necessário")
    @NotEmpty(message = "O Campo nome é necessário")
    private String nome;

    @Size(max = 50, message = "O campo email ultrapassa o limite de caracteres")
    @NotNull(message = "O campo email é necessário")
    @NotEmpty(message = "O campo email é necessário")
    private String email;

    @Size(min = 8, max = 25, message = "O campo senha deve ter entre 8 e 25 caracteres")
    @NotNull(message = "O campo senha é necessário")
    @NotEmpty(message = "O campo senha é necessário")
    private String senha;

    @Size(min = 8, max = 25, message = "O campo senha deve ter entre 8 e 25 caracteres")
    @NotNull(message = "Confirme sua senha")
    @NotEmpty(message = "Confirme sua senha")
    private String confirmacaoSenha;

    @NotNull(message = "O campo cpf é necessário")
    @NotEmpty(message = "O campo cpf é necessário")
    @Size(min = 11, max = 11, message = "O campo CPF é inválido")
    private String cpf;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Size(min = 10, max = 10, message = "O campo telefone residencial é inválido")
    private String telefoneResidencial;

    @Size(min = 11, max = 11, message = "O campo telefone celular é inválido")
    private String telefoneCelular;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Usuario convert() {
        return new Usuario(this.nome, this.email, this.senha, this.cpf, this.dataNascimento, this.telefoneResidencial, this.telefoneCelular);
    }

}
