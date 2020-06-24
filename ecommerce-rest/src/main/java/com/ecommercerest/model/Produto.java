package com.ecommercerest.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
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
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "detalhes_produto")
    private String detalhes;

    @Column(name = "data_atualizacao_produto")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_atualizacao;

    @Column(name = "preco_produto")
    private Double preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subgrupo")
    private SubGrupo subgrupo;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ProdutoImagem> imagens = new ArrayList<>();

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @OneToOne(mappedBy = "produto", fetch = FetchType.LAZY)
    private FichaTecnicaProduto fichaTecnicaProduto;

    @Transient
    private List<MultipartFile> preImagens = new ArrayList<>();

    @Transient
    private Double mediaAvaliacoes;

    @OneToMany(mappedBy = "produto")
    private List<ItemVenda> itensVenda = new ArrayList<>();

    public Produto() {

    }

    public Produto(String nome, String detalhes, SubGrupo subgrupo, List<MultipartFile> preImagens) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.subgrupo = subgrupo;
        this.preImagens = preImagens;
    }

    public Produto(String nome, String detalhes, SubGrupo subGrupo, Double preco, List<MultipartFile> preImagens) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.subgrupo = subGrupo;
        this.preco = preco;
        this.preImagens = preImagens;
    }

    public Double getMediaAvaliacoes() {
        return this.avaliacoes.stream().mapToDouble(a -> a.getEstrelas()).average().orElse(0.0);
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Calendar getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Calendar data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public SubGrupo getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(SubGrupo subgrupo) {
        this.subgrupo = subgrupo;
    }

    public List<ProdutoImagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<ProdutoImagem> imagens) {
        this.imagens = imagens;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<MultipartFile> getPreImagens() {
        return preImagens;
    }

    public void setPreImagens(List<MultipartFile> preImagens) {
        this.preImagens = preImagens;
    }

    public FichaTecnicaProduto getFichaTecnicaProduto() {
        return fichaTecnicaProduto;
    }

    public void setFichaTecnicaProduto(FichaTecnicaProduto fichaTecnicaProduto) {
        this.fichaTecnicaProduto = fichaTecnicaProduto;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
