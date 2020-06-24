package com.ecommercerest.service;

import com.ecommercerest.model.Produto;
import com.ecommercerest.model.ProdutoImagem;
import com.ecommercerest.repository.ProdutoImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoImagemService {

    @Autowired
    private ProdutoImagemRepository produtoImagemRepository;

    public List<ProdutoImagem> findAll() {
        return this.produtoImagemRepository.findAll();
    }

    public ProdutoImagem findById(String url) {
        Optional<ProdutoImagem> produtoImagem = this.produtoImagemRepository.findById(url);
        if (!produtoImagem.isPresent()) throw new EntityNotFoundException("Produto inexistente");
        return produtoImagem.get();
    }

    @Transactional
    public void deleteById(String url) {
        ProdutoImagem produtoImagem = this.findById(url);
        this.produtoImagemRepository.deleteById(produtoImagem.getUrl());
    }

    @Transactional
    public ProdutoImagem save(ProdutoImagem produtoImagem) {
        return this.produtoImagemRepository.save(produtoImagem);
    }

    @Transactional
    public List<ProdutoImagem> saveAll(List<ProdutoImagem> imagens, Produto produto) {

        List<ProdutoImagem> produtoImagems = imagens.stream().filter(i -> i != null).collect(Collectors.toList());

        produtoImagems.forEach(pi -> {
            pi.setProduto(produto);
            this.produtoImagemRepository.save(pi);
        });

        return produtoImagems;
    }

    public void deleteAll(List<ProdutoImagem> toDelete) {
        this.produtoImagemRepository.deleteAll(toDelete);
    }

}
