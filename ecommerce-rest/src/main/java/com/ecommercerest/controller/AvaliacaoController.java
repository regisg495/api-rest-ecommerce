package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.AvaliacaoClienteDTO;
import com.ecommercerest.controller.dto.AvaliacaoProdutoDTO;
import com.ecommercerest.controller.dto.ProdutoDTO;
import com.ecommercerest.service.AvaliacaoService;
import com.ecommercerest.service.ClienteService;
import com.ecommercerest.service.ProdutoService;
import com.ecommercerest.service.SubGrupoService;
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

@RestController
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private SubGrupoService subGrupoService;

    @GetMapping(value = "/clientes/{id}/avaliacoes")
    public Page<AvaliacaoClienteDTO> avaliacoesPorCliente(@PageableDefault(sort = "estrelas", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable,
                                                          @PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return AvaliacaoClienteDTO.convert(this.avaliacaoService.findAllByCliente(this.clienteService.findById(id), pageable));
    }

    @GetMapping(value = "/produtos/{id}/avaliacoes")
    public Page<AvaliacaoProdutoDTO> avaliacoesPorProduto(@PageableDefault(sort = "estrelas", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable,
                                                          @PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return AvaliacaoProdutoDTO.convert(this.avaliacaoService.findAllByProduto(this.produtoService.findById(id), pageable));
    }

    @GetMapping(value = "/produtos/avaliacoes")
    public Page<ProdutoDTO> avaliacoesDosProdutos(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return new ProdutoDTO().toValidPage(this.produtoService.findAll(), pageable);
    }

    @GetMapping(value = "/subgrupos/{id}/produtos/avaliacoes")
    public Page<ProdutoDTO> avaliacoesDosProdutosPorSubgrupo(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                             @PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Short id) {
        return new ProdutoDTO().toValidPage(this.produtoService.findAllBySubgrupo(this.subGrupoService.findById(id)), pageable);
    }

    @GetMapping(value = "/clientes/avaliacoes/q")
    public Page<AvaliacaoClienteDTO> avaliacaoClienteQuery(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                           @RequestParam(name = "c_id") @Min(value = 1, message = "O campo não pode ser negativo") Long idCliente,
                                                           @RequestParam(name = "data_inicio", required = false, defaultValue = "01/01/2010") Date dataAvaliacaoInicio,
                                                           @RequestParam(name = "data_fim", required = false, defaultValue = "#{new java.util.Date()}") Date dataAvaliacaoFim) {

        return AvaliacaoClienteDTO.convert(this.avaliacaoService.findAllByClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(
                this.clienteService.findById(idCliente), dataAvaliacaoInicio, dataAvaliacaoFim, pageable));
    }

    @GetMapping(value = "/produtos/avaliacoes/q")
    public Page<AvaliacaoProdutoDTO> avaliacaoProdutoQuery(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                           @RequestParam(name = "p_id") @Min(value = 1, message = "O campo não pode ser negativo") Long idProduto,
                                                           @RequestParam(name = "c_id") @Min(value = 1, message = "O campo não pode ser negativo") Long idCliente,
                                                           @RequestParam(name = "data_inicio", required = false, defaultValue = "01/01/2015") Date dataAvaliacaoInicio,
                                                           @RequestParam(name = "data_fim", required = false, defaultValue = "#{new java.util.Date()}") Date dataAvaliacaoFim) {
        return AvaliacaoProdutoDTO.convert(this.avaliacaoService.
                findAllByProdutoAndClienteAndDataAvaliacaoBetweenOrderByDataAvaliacaoDesc(
                        this.produtoService.findById(idProduto), this.clienteService.findById(idCliente),
                        dataAvaliacaoInicio, dataAvaliacaoFim, pageable));
    }

}
