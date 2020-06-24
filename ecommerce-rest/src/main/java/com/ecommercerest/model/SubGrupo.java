package com.ecommercerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subgrupo")
public class SubGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subgrupo")
    private Short id;

    @Column(name = "data_atualizacao_subgrupo")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_atualizacao;

    @Column(name = "nome_subgrupo")
    private String nome;

    @Column(name = "detalhes_subgrupo")
    private String detalhes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @OneToMany(mappedBy = "subgrupo", fetch = FetchType.LAZY)
    private List<Produto> produtos = new ArrayList<>();

    @OneToOne(mappedBy = "subgrupo", fetch = FetchType.LAZY)
    private FichaTecnicaCampo fichaTecnicaCampo;

    public SubGrupo() {

    }

    public SubGrupo(String nome, String detalhes, Grupo grupo) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.grupo = grupo;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public FichaTecnicaCampo getFichaTecnicaCampo() {
        return fichaTecnicaCampo;
    }

    public void setFichaTecnicaCampo(FichaTecnicaCampo fichaTecnicaCampo) {
        this.fichaTecnicaCampo = fichaTecnicaCampo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubGrupo)) return false;
        SubGrupo subGrupo = (SubGrupo) o;
        return id.equals(subGrupo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
