package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.GrupoDTO;
import com.ecommercerest.controller.form.GrupoForm;
import com.ecommercerest.model.Grupo;
import com.ecommercerest.service.GrupoService;
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
@RequestMapping(value = "/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/{id}")
    public GrupoDTO grupo(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Short id) {
        return new GrupoDTO(grupoService.findById(id));
    }

    @GetMapping
    public Page<GrupoDTO> grupos(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable) {
        return GrupoDTO.convert(this.grupoService.findAll(pageable));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Short id) {
        this.grupoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<GrupoDTO> cadastrar(@RequestBody @Valid GrupoForm grupoForm,
                                              UriComponentsBuilder uriComponentsBuilder) {
        Grupo grupo = this.grupoService.save(grupoForm);
        URI uri = uriComponentsBuilder.path("/grupos/{id}").buildAndExpand(grupo.getId()).toUri();
        return ResponseEntity.created(uri).body(new GrupoDTO(grupo));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<GrupoDTO> editar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Short id,
                                           @RequestBody @Valid GrupoForm grupoForm) {
        Grupo grupo = this.grupoService.edit(id, grupoForm);
        return ResponseEntity.ok(new GrupoDTO(grupo));
    }
}
