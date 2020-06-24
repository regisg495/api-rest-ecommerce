package com.ecommercerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "produto_imagem")
public class ProdutoImagem {

    @Column(name = "url_imagem")
    @Id
    private String url;

    @Column(name = "tipo_imagem")
    @Enumerated(EnumType.STRING)
    private TipoImagem tipoImagem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public ProdutoImagem() {

    }

    public ProdutoImagem(String url, TipoImagem tipoImagem) {
        this.url = url;
        this.tipoImagem = tipoImagem;
    }

    public ProdutoImagem(String url, TipoImagem tipoImagem, Produto produto) {
        this.url = url;
        this.tipoImagem = tipoImagem;
        this.produto = produto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TipoImagem getTipoImagem() {
        return tipoImagem;
    }

    public void setTipoImagem(TipoImagem tipoImagem) {
        this.tipoImagem = tipoImagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoImagem)) return false;
        ProdutoImagem that = (ProdutoImagem) o;
        return url.equals(that.url) &&
                tipoImagem == that.tipoImagem &&
                Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, tipoImagem, produto);
    }
}
