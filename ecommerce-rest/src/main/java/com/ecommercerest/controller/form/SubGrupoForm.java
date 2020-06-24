package com.ecommercerest.controller.form;

import com.ecommercerest.model.Grupo;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.service.GrupoService;
import com.ecommercerest.service.SubGrupoService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubGrupoForm {

    @Size(max = 200, message = "O campo nome ultrapassa o limite de caracteres")
    @NotNull(message = "O campo nome é necessário")
    @NotEmpty(message = "O Campo nome é necessário")
    private String nome;

    @Size(max = 65535, message = "O campo detalhes ultrapassa o limite de caracteres")
    private String detalhes;

    @NotNull(message = "O campo grupo é necessário")
    private Short id_grupo;

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

    public Short getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Short id_grupo) {
        this.id_grupo = id_grupo;
    }

    public SubGrupo convert(GrupoService grupoService) {
        Grupo grupo = grupoService.findById(this.id_grupo);
        return new SubGrupo(this.nome, this.detalhes, grupo);
    }

    public SubGrupo atualizar(Short id, SubGrupoService subGrupoService, GrupoService grupoService) {
        SubGrupo subGrupo = subGrupoService.findById(id);
        Grupo grupo = grupoService.findById(this.id_grupo);
        subGrupo.setNome(this.nome);
        subGrupo.setDetalhes(this.detalhes);
        subGrupo.setGrupo(grupo);
        return subGrupo;
    }

}
