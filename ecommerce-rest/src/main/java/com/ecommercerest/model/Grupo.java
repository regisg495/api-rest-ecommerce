package com.ecommercerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Short id;

    @Column(name = "data_atualizacao_grupo")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_atualizacao;

    @Column(name = "nome_grupo")
    private String nome;

    @Column(name = "detalhes_grupo")
    private String detalhes;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<SubGrupo> subGrupos = new ArrayList<>();

    public Grupo() {

    }

    public Grupo(String nome, String detalhes) {
        this.nome = nome;
        this.detalhes = detalhes;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Calendar getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Calendar data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

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

    public List<SubGrupo> getSubGrupos() {
        return subGrupos;
    }

    public void setSubGrupos(List<SubGrupo> subGrupos) {
        this.subGrupos = subGrupos;
    }
}
