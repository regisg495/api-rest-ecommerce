package com.ecommercerest.model;

import javax.persistence.Column;
import java.io.Serializable;

public final class AvaliacaoID implements Serializable {

    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "id_cliente")
    private Long idCliente;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
