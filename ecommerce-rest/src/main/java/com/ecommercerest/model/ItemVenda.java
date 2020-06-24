package com.ecommercerest.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @EmbeddedId
    private ItemVendaID id;

    @ManyToOne
    @MapsId("id_venda")
    @JoinColumn(name = "id_venda")
    private Venda venda;

    @ManyToOne
    @MapsId("id_produto")
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade_produto")
    private Integer quantidade;

    public ItemVendaID getId() {
        return id;
    }

    public void setId(ItemVendaID id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
