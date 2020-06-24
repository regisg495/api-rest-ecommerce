package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.EnderecoDTO;
import com.ecommercerest.service.ClienteService;
import com.ecommercerest.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}/enderecos")
    public List<EnderecoDTO> enderecos(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return EnderecoDTO.convert(this.clienteService.findById(id).getEnderecos());
    }

    @GetMapping(value = "/enderecos/{id}")
    public EnderecoDTO endereco(@PathVariable @Min(value = 1, message = "O campo não pode ser negativo") Long id) {
        return new EnderecoDTO(this.enderecoService.findById(id));
    }

}
