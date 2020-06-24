package com.ecommercerest.controller.form;

import com.ecommercerest.model.Permissao;
import com.ecommercerest.service.PermissaoService;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PermissaoUsuarioForm {

    @NotEmpty(message = "Você deve preencher com ao menos uma permissão")
    private List<String> permissoes = new ArrayList<>();

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }

    public List<Permissao> convert(PermissaoService permissaoService) {
        return this.permissoes.stream().map(Permissao::new).
                filter(permissao -> permissaoService.existsById(permissao.getNome()))
                .distinct()
                .collect(Collectors.toList());
    }
}
