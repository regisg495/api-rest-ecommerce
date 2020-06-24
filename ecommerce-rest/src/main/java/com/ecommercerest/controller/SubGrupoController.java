package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.ProdutoDTO;
import com.ecommercerest.controller.dto.SubGrupoDTO;
import com.ecommercerest.controller.form.SubGrupoForm;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.service.ProdutoService;
import com.ecommercerest.service.SubGrupoService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;


@RestController
@RequestMapping("/subgrupos")
public class SubGrupoController {

    @Autowired
    private SubGrupoService subGrupoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{nome}/produtos")
    public Page<ProdutoDTO> getProdutos(@PathVariable String nome, @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable) {
        SubGrupo subGrupo = this.subGrupoService.findByNome(nome);
        return ProdutoDTO.convert(this.produtoService.findAllBySubgrupo(subGrupo, pageable));
    }

    @GetMapping(value = "/{id}")
    public SubGrupoDTO subgrupo(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo")
                                        Short id) {
        return new SubGrupoDTO(this.subGrupoService.findById(id));
    }

    @GetMapping
    public Page<SubGrupoDTO> subgrupos(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        return SubGrupoDTO.convert(this.subGrupoService.findAll(pageable));
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo")
                                             Short id) {
        this.subGrupoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<SubGrupoDTO> cadastrar(@RequestBody @Valid SubGrupoForm subGrupoForm,
                                                 UriComponentsBuilder uriComponentsBuilder) {

        SubGrupo subGrupo = subGrupoService.save(subGrupoForm);
        URI uri = uriComponentsBuilder.path("/subgrupos/{id}").buildAndExpand(subGrupo.getId()).toUri();
        return ResponseEntity.created(uri).body(new SubGrupoDTO(subGrupo));
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<SubGrupoDTO> editar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo")
                                                      Short id, @RequestBody @Valid SubGrupoForm subGrupoForm) {
        SubGrupo subGrupo = subGrupoService.edit(id, subGrupoForm);
        return ResponseEntity.ok(new SubGrupoDTO(subGrupo));
    }
}
