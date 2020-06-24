package com.ecommercerest.controller.form;

import com.ecommercerest.model.Grupo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GrupoForm {

    @Size(max = 200, message = "O campo nome ultrapassa o limite de caracteres")
    @NotNull(message = "O campo nome é necessário")
    @NotEmpty(message = "O Campo nome é necessário")
    private String nome;

    @Size(max = 65535, message = "O campo detalhes ultrapassa o limite de caracteres")
    private String detalhes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Grupo convert() {
        return new Grupo(this.nome, this.detalhes);
    }
}
