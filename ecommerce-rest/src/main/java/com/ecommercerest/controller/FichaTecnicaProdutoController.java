package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.FichaTecnicaCampoDTO;
import com.ecommercerest.controller.dto.FichaTecnicaProdutoDTO;
import com.ecommercerest.controller.form.FichaTecnicaProdutoForm;
import com.ecommercerest.model.FichaTecnicaCampo;
import com.ecommercerest.model.FichaTecnicaProduto;
import com.ecommercerest.service.FichaTecnicaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import java.util.Map;

@RestController
@RequestMapping(value = "/produtos/fichatecnica")
public class FichaTecnicaProdutoController {

    @Autowired
    private FichaTecnicaProdutoService fichaTecnicaProdutoService;

    @GetMapping(value = "/{id}")
    public Map<String, String> findById(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) throws Exception {
        FichaTecnicaProduto fichaTecnicaProduto = this.fichaTecnicaProdutoService.findById(id);
        FichaTecnicaCampo fichaTecnicaCampo = fichaTecnicaProduto.getProduto().getSubgrupo().getFichaTecnicaCampo();

        return FichaTecnicaProdutoDTO.convertToMap(
                new FichaTecnicaCampoDTO(fichaTecnicaCampo).convertToStringList(),
                new FichaTecnicaProdutoDTO(fichaTecnicaProduto).convertToStringList()
        );
    }

    @GetMapping
    public Page<Map<String, String>> findAll(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<FichaTecnicaProduto> fichaTecnicaProdutos = this.fichaTecnicaProdutoService.findAll(pageable);
        return FichaTecnicaProdutoDTO.convert(fichaTecnicaProdutos);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Map<String, String>> cadastrar(@RequestBody @Valid FichaTecnicaProdutoForm fichaTecnicaProdutoForm,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        FichaTecnicaProduto fichaTecnicaProduto = this.fichaTecnicaProdutoService.save(fichaTecnicaProdutoForm);
        URI uri = uriComponentsBuilder.path("/produtos/fichatecnica/{id}").buildAndExpand(fichaTecnicaProduto.getId()).toUri();
        FichaTecnicaCampo fichaTecnicaCampo = fichaTecnicaProduto.getProduto().getSubgrupo().getFichaTecnicaCampo();

        return ResponseEntity.created(uri).body(FichaTecnicaProdutoDTO.convertToMap(
                new FichaTecnicaCampoDTO(fichaTecnicaCampo).convertToStringList(),
                new FichaTecnicaProdutoDTO(fichaTecnicaProduto).convertToStringList())
        );
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        this.fichaTecnicaProdutoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Map<String, String>> editar(@RequestBody @Valid FichaTecnicaProdutoForm fichaTecnicaProdutoForm) {
        FichaTecnicaProduto fichaTecnicaProduto = this.fichaTecnicaProdutoService.edit(fichaTecnicaProdutoForm);
        FichaTecnicaCampo fichaTecnicaCampo = fichaTecnicaProduto.getProduto().getSubgrupo().getFichaTecnicaCampo();

        return ResponseEntity.ok(
                FichaTecnicaProdutoDTO.convertToMap(
                        new FichaTecnicaCampoDTO(fichaTecnicaCampo).convertToStringList(),
                        new FichaTecnicaProdutoDTO(fichaTecnicaProduto).convertToStringList()
                ));
    }

}
