package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Avaliacao;
import org.springframework.data.domain.Page;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoClienteDTO {

    private Byte estrelas;

    private Calendar dataAvaliacao;

    private String comentario;

    private String emailCliente;


    public AvaliacaoClienteDTO(Avaliacao avaliacao) {
        this.estrelas = avaliacao.getEstrelas();
        this.dataAvaliacao = avaliacao.getDataAvaliacao();
        this.comentario = avaliacao.getComentario();
        this.emailCliente = avaliacao.getCliente().getEmail();
    }

    public Byte getEstrelas() {
        return estrelas;
    }

    public Calendar getDataAvaliacao() {
        return dataAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public String getEmailCliente() {
        return emailCliente;
    }


    public static List<AvaliacaoClienteDTO> convert(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream().map(AvaliacaoClienteDTO::new).collect(Collectors.toList());
    }

    public static Page<AvaliacaoClienteDTO> convert(Page<Avaliacao> avaliacoes) {
        return avaliacoes.map(AvaliacaoClienteDTO::new);
    }
}
