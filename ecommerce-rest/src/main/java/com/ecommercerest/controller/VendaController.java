package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.ItemVendaDTO;
import com.ecommercerest.controller.dto.VendaDTO;
import com.ecommercerest.model.Cliente;
import com.ecommercerest.model.Produto;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.service.ClienteService;
import com.ecommercerest.service.ProdutoService;
import com.ecommercerest.service.SubGrupoService;
import com.ecommercerest.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class VendaController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendaService vendaService;


    @GetMapping("/venda/{id}")
    public VendaDTO venda(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return new VendaDTO(this.vendaService.findById(id));
    }

    @GetMapping("/vendas/")
    public Page<VendaDTO> vendas(@PageableDefault(sort = "totalVenda", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        return VendaDTO.convert(this.vendaService.findAll(pageable));
    }

    @GetMapping("/clientes/{id}/compras")
    public Page<VendaDTO> comprasPorCliente(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id,
                                            @PageableDefault(sort = "totalVenda", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        Cliente cliente = this.clienteService.findById(id);
        return new VendaDTO().toValidPage(cliente.getCompras(), pageable);
    }

    @GetMapping("/produtos/{id}/vendas")
    public Page<VendaDTO> vendasPorProduto(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id,
                                           @PageableDefault(sort = "totalVenda", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        Produto produto = this.produtoService.findById(id);
        return new VendaDTO().toValidPage(ItemVendaDTO.convertToVenda(produto.getItensVenda()), pageable);
    }

    @GetMapping("/produtos/vendas/detalhes")
    public Page<VendaDTO> vendasDosProdutosPorDetalhes(@RequestParam Date data,
                                                       @RequestParam(required = false) Optional<Double> total,
                                                       @PageableDefault(sort = "totalVenda", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        if (total.isPresent())
            return VendaDTO.convert(this.vendaService.findDistinctByDataVendaGreaterThanAndTotalVendaGreaterThan(data, total.get(), pageable));

        return VendaDTO.convert(this.vendaService.findDistinctByDataVendaGreaterThan(data, pageable));

    }

}
