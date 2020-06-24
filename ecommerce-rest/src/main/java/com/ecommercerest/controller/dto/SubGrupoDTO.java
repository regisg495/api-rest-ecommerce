package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Produto;
import com.ecommercerest.model.SubGrupo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class SubGrupoDTO {

    private Short id;
    private String nome;
    private String detalhes;
    private String nome_grupo;

    public SubGrupoDTO(SubGrupo subGrupo) {
        this.id = subGrupo.getId();
        this.nome = subGrupo.getNome();
        this.detalhes = subGrupo.getDetalhes();
        this.nome_grupo = subGrupo.getGrupo().getNome();
    }

    public Short getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public static List<SubGrupoDTO> convert(List<SubGrupo> subGrupos) {
        return subGrupos.stream().map(SubGrupoDTO::new).collect(Collectors.toList());
    }

    public static Page<SubGrupoDTO> convert(Page<SubGrupo> subGrupos) {
        return subGrupos.map(SubGrupoDTO::new);
    }

}
