package com.ecommercerest.controller.dto;

import com.ecommercerest.model.CEP;
import com.ecommercerest.model.Endereco;
import com.ecommercerest.model.TipoEndereco;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDTO {

    private TipoEndereco tipoEndereco;

    private String nomeDestinatario;

    private String numero;

    private String complemento;

    private String informacoesReferencia;

    private CEP cep;

    public EnderecoDTO(Endereco endereco) {
        this.nomeDestinatario = endereco.getNomeDestinatario();
        this.tipoEndereco = endereco.getTipoEndereco();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.informacoesReferencia = endereco.getInformacoesReferencia();
        this.cep = endereco.getCep();
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getInformacoesReferencia() {
        return informacoesReferencia;
    }

    public CEP getCep() {
        return cep;
    }

    public static List<EnderecoDTO> convert(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    public static Page<EnderecoDTO> convert(Page<Endereco> enderecos) {
        return enderecos.map(EnderecoDTO::new);
    }
}
