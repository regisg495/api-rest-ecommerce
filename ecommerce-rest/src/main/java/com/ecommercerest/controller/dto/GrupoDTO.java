package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Grupo;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrupoDTO {
    private Short id;
    private String detalhes;
    private String nome;
    private List<SubGrupoDTO> subGrupos = new ArrayList<>();

    public GrupoDTO(Grupo grupo) {
        this.id = grupo.getId();
        this.nome = grupo.getNome();
        this.detalhes = grupo.getDetalhes();
        this.subGrupos = grupo.getSubGrupos().stream().map(SubGrupoDTO::new).collect(Collectors.toList());
    }

    public Short getId() {
        return id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public String getNome() {
        return nome;
    }

    public List<SubGrupoDTO> getSubGrupos() {
        return subGrupos;
    }

    public static List<GrupoDTO> convert(List<Grupo> grupos) {
        return grupos.stream().map(GrupoDTO::new).collect(Collectors.toList());
    }

    public static Page<GrupoDTO> convert(Page<Grupo> grupos) {
        return grupos.map(GrupoDTO::new);
    }

}
