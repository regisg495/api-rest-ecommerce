package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.ProdutoDTO;
import com.ecommercerest.controller.form.ProdutoForm;
import com.ecommercerest.model.Produto;
import com.ecommercerest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ProdutoDTO produto(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return new ProdutoDTO(this.produtoService.findById(id));
    }

    @GetMapping
    public Page<ProdutoDTO> produtos(@PageableDefault(sort = "subgrupo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable) {
        return ProdutoDTO.convert(this.produtoService.findAll(pageable));
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        this.produtoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@Valid ProdutoForm produtoForm, UriComponentsBuilder uriComponentsBuilder) {
        Produto produto = this.produtoService.save(produtoForm);
        URI uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<ProdutoDTO> editar(@PathVariable @Min(value = 1, message = "O campo ID não pode ser negativo") Long id,
                                             @Valid ProdutoForm produtoForm) {
        Produto produto = this.produtoService.edit(id, produtoForm);
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }
}
