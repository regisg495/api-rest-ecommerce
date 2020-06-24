package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public UsuarioDTO convert(Usuario usuario) {
        return new UsuarioDTO(usuario);
    }

    public static List<UsuarioDTO> convert(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public static Page<UsuarioDTO> convert(Page<Usuario> usuarios) {
        return usuarios.map(UsuarioDTO::new);
    }

}
