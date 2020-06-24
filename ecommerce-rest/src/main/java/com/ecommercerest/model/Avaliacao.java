package com.ecommercerest.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Entity
@Table(name = "produto_avaliacao")
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoID id;

    @Column(name = "estrelas_avaliacao")
    private Byte estrelas;

    @Column(name = "data_avaliacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAvaliacao;

    @Column(name = "comentario_avaliacao")
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_cliente")
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_produto")
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public AvaliacaoID getId() {
        return id;
    }

    public void setId(AvaliacaoID id) {
        this.id = id;
    }

    public Byte getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Byte estrelas) {
        this.estrelas = estrelas;
    }

    public Calendar getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Calendar dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
