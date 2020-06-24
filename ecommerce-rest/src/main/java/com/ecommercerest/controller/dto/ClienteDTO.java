package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private Long id;

    private String email;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.email = cliente.getEmail();
    }

    public static List<ClienteDTO> convert(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public static Page<ClienteDTO> convert(Page<Cliente> clientes) {
        return clientes.map(ClienteDTO::new);
    }

}
