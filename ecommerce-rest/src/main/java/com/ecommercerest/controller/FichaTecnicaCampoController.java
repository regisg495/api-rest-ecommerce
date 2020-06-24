package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.FichaTecnicaCampoDTO;
import com.ecommercerest.controller.form.FichaTecnicaCampoForm;
import com.ecommercerest.model.FichaTecnicaCampo;
import com.ecommercerest.service.FichaTecnicaCampoService;
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
@RequestMapping(value = "/subgrupos/fichatecnica")
public class FichaTecnicaCampoController {

    @Autowired
    private FichaTecnicaCampoService fichaTecnicaCampoService;

    @GetMapping(value = "/{id}")
    public FichaTecnicaCampoDTO fichaTecnicaCampo(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Short id) {
        return new FichaTecnicaCampoDTO(this.fichaTecnicaCampoService.findById(id));
    }

    @GetMapping
    public Page<FichaTecnicaCampoDTO> fichaTecnicaCampos(@PageableDefault(sort = "subgrupo.nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        return FichaTecnicaCampoDTO.convert(this.fichaTecnicaCampoService.findAll(pageable));
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<FichaTecnicaCampoDTO> cadastrar(@RequestBody @Valid FichaTecnicaCampoForm fichaTecnicaCampoForm,
                                                          UriComponentsBuilder uriComponentsBuilder) {
        FichaTecnicaCampo fichaTecnicaCampo = this.fichaTecnicaCampoService.save(fichaTecnicaCampoForm);
        URI uri = uriComponentsBuilder.path("/subgrupos/fichatecnica/{id}").buildAndExpand(fichaTecnicaCampo.getId()).toUri();
        return ResponseEntity.created(uri).body(new FichaTecnicaCampoDTO(fichaTecnicaCampo));
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Short id) {
        this.fichaTecnicaCampoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<FichaTecnicaCampoDTO> editar(@RequestBody @Valid FichaTecnicaCampoForm fichaTecnicaCampoForm) {
        FichaTecnicaCampo fichaTecnicaCampo = this.fichaTecnicaCampoService.edit(fichaTecnicaCampoForm);
        return ResponseEntity.ok(new FichaTecnicaCampoDTO(fichaTecnicaCampo));
    }

}
