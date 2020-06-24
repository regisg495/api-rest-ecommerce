package com.ecommercerest.model;

import javax.persistence.Column;
import java.io.Serializable;

public class ItemVendaID implements Serializable {

    @Column(name = "id_venda")
    private Long idVenda;

    @Column(name = "id_produto")
    private Long idProduto;

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}
