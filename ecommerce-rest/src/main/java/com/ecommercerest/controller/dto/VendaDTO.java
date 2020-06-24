package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Venda;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class VendaDTO {

    private Long id;
    private Long idCliente;
    private Calendar dataVenda;
    private Double total;
    @JsonProperty("Itens da Venda")
    private List<ItemVendaDTO> itemVendaDTO;

    public VendaDTO() {

    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.idCliente = venda.getCliente().getId();
        this.dataVenda = venda.getDataVenda();
        this.total = venda.getTotalVenda();
        this.itemVendaDTO = ItemVendaDTO.convert(venda);
    }

    public Long getId() {
        return id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public Double getTotal() {
        return total;
    }

    public List<ItemVendaDTO> getItemVendaDTO() {
        return itemVendaDTO;
    }

    private List<VendaDTO> toSubList(List<Venda> vendas, Pageable pageable) {
        Long inicio = pageable.getOffset();
        Long fim = (inicio + pageable.getPageSize()) > vendas.size() ? vendas.size() : (inicio + pageable.getPageSize());

        return vendas.subList(inicio.intValue(), fim.intValue()).stream().map(VendaDTO::new).collect(Collectors.toList());
    }

    public static Page<VendaDTO> convert(Page<Venda> vendas) {
        return vendas.map(VendaDTO::new);
    }

    public Page<VendaDTO> toValidPage(List<Venda> vendas, Pageable pageable) {
        List<VendaDTO> vendaDTOS = this.toSubList(vendas, pageable);
        return new PageImpl<>(vendaDTOS, pageable, vendaDTOS.size());
    }

}
