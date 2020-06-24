package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Avaliacao;
import org.springframework.data.domain.Page;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoProdutoDTO {

    private Byte estrelas;

    private Calendar dataAvaliacao;

    private String nomeProduto;

    public AvaliacaoProdutoDTO(Avaliacao avaliacao) {
        this.estrelas = avaliacao.getEstrelas();
        this.dataAvaliacao = avaliacao.getDataAvaliacao();
        this.nomeProduto = avaliacao.getProduto().getNome();
    }

    public Byte getEstrelas() {
        return estrelas;
    }

    public Calendar getDataAvaliacao() {
        return dataAvaliacao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public static List<AvaliacaoProdutoDTO> convert(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream().map(AvaliacaoProdutoDTO::new).collect(Collectors.toList());
    }

    public static Page<AvaliacaoProdutoDTO> convert(Page<Avaliacao> avaliacoes) {
        return avaliacoes.map(AvaliacaoProdutoDTO::new);
    }

}
