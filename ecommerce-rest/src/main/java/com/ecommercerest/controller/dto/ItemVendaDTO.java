package com.ecommercerest.controller.dto;

import com.ecommercerest.model.ItemVenda;
import com.ecommercerest.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public class ItemVendaDTO {

    private String nomeProduto;
    private Integer quantidade;
    private Double precoUnitario;

    public ItemVendaDTO(ItemVenda itemVenda) {
        this.nomeProduto = itemVenda.getProduto().getNome();
        this.quantidade = itemVenda.getQuantidade();
        this.precoUnitario = itemVenda.getProduto().getPreco();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public static List<Venda> convertToVenda(List<ItemVenda> itens) {
        return itens.stream().map(ItemVenda::getVenda).collect(Collectors.toList());
    }

    public static List<ItemVendaDTO> convert(Venda venda) {
        return venda.getItensVenda().stream().map(ItemVendaDTO::new).collect(Collectors.toList());
    }
}
