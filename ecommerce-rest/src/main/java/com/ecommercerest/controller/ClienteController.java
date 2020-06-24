package com.ecommercerest.controller;

import com.ecommercerest.controller.dto.ClienteDTO;
import com.ecommercerest.model.Sexo;
import com.ecommercerest.model.TipoEndereco;
import com.ecommercerest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/endereco")
    public Page<ClienteDTO> clientesPorEnderecoPrincipal(@PageableDefault(sort = "email", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable,
                                                         @RequestParam(required = false) Optional<TipoEndereco> tipoEndereco,
                                                         @RequestParam Optional<String> localidade, @RequestParam(required = false) Optional<String> bairro) {
        return ClienteDTO.convert(this.clienteService.findDistinctByEnderecoPrincipal_TipoEnderecoOrEnderecoPrincipalCepLocalidadeOrEnderecoPrincipalCepBairro(tipoEndereco, localidade, bairro, pageable));
    }

    @GetMapping("/detalhes")
    public Page<ClienteDTO> clientesPorUfESexo(@PageableDefault(sort = "email", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable,
                                               @RequestParam String localidade, @RequestParam Sexo sexo) {
        return ClienteDTO.convert(this.clienteService.findDistinctByEnderecoPrincipal_CepUfAndSexo(sexo, localidade, pageable));
    }

}
