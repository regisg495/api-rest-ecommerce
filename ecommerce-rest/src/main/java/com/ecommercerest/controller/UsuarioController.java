package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.UsuarioDTO;
import com.ecommercerest.controller.form.PermissaoUsuarioForm;
import com.ecommercerest.controller.form.UsuarioForm;
import com.ecommercerest.model.Usuario;
import com.ecommercerest.service.UsuarioService;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public UsuarioDTO usuario(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return new UsuarioDTO(this.usuarioService.findById(id));
    }

    @GetMapping
    public Page<UsuarioDTO> usuarios(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        return UsuarioDTO.convert(this.usuarioService.findAll(pageable));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        this.usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = this.usuarioService.save(usuarioForm);
        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<UsuarioDTO> editar(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id,
                                             @RequestBody @Valid UsuarioForm usuarioForm) {
        Usuario usuario = this.usuarioService.edit(id, usuarioForm);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @PutMapping("/{id}/permissoes/editar")
    public ResponseEntity<UsuarioDTO> editarPermissoes(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id,
                                                       @RequestBody @Valid PermissaoUsuarioForm permissaoUsuarioForm) {
        Usuario usuario = this.usuarioService.editPermissoes(id, permissaoUsuarioForm);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

}
