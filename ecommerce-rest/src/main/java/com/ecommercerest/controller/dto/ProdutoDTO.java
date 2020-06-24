package com.ecommercerest.controller.dto;

import com.ecommercerest.model.Produto;
import com.ecommercerest.model.ProdutoImagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String detalhes;
    private Double preco;
    private String nome_subgrupo;
    private String nome_grupo;
    private List<String> imagens = new ArrayList<>();
    private Double avaliacoes;

    public ProdutoDTO() {

    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.detalhes = produto.getDetalhes();
        this.preco = produto.getPreco();
        this.nome_subgrupo = produto.getSubgrupo().getNome();
        this.nome_grupo = produto.getSubgrupo().getGrupo().getNome();
        this.imagens = produto.getImagens().stream().map(imagem -> imagem.getUrl() + "." + imagem.getTipoImagem()).collect(Collectors.toList());
        this.avaliacoes = produto.getMediaAvaliacoes();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public Double getPreco() {
        return preco;
    }

    public String getNome_subgrupo() {
        return nome_subgrupo;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public Double getAvaliacoes() {
        return avaliacoes;
    }

    private List<ProdutoDTO> convertInOrder(List<Produto> produtos) {
        produtos.sort(Comparator.comparing(
                Produto::getMediaAvaliacoes).
                reversed());

        return convert(produtos);
    }

    private List<ProdutoDTO> toSubList(List<ProdutoDTO> produtoDTOS, Pageable pageable) {
        Long inicio = pageable.getOffset();
        Long fim = (inicio + pageable.getPageSize()) > produtoDTOS.size() ? produtoDTOS.size() : (inicio + pageable.getPageSize());

        return produtoDTOS.subList(inicio.intValue(), fim.intValue());
    }

    public Page<ProdutoDTO> toValidPage(List<Produto> produtos, Pageable pageable) {
        List<ProdutoDTO> produtoDTOS = this.toSubList(convertInOrder(produtos), pageable);
        return new PageImpl<>(produtoDTOS, pageable, produtoDTOS.size());
    }

    public static List<ProdutoDTO> convert(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public static Page<ProdutoDTO> convert(Page<Produto> produtos) {
        return produtos.map(ProdutoDTO::new);
    }
}
