package com.ecommercerest.service;

import com.ecommercerest.controller.form.ProdutoForm;
import com.ecommercerest.error.FieldValueAlreadyExistsException;
import com.ecommercerest.model.Produto;
import com.ecommercerest.model.ProdutoImagem;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.repository.ProdutoRepository;
import com.ecommercerest.service.storage.ProdutoImagemFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoImagemService produtoImagemService;

    @Autowired
    private SubGrupoService subGrupoService;

    public Page<Produto> findAllBySubgrupo(SubGrupo subGrupo, Pageable pageable) {
        return this.produtoRepository.findAllBySubgrupo(subGrupo, pageable);
    }

    public List<Produto> findAllBySubgrupo(SubGrupo subGrupo) {
        return this.produtoRepository.findAllBySubgrupo(subGrupo);
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    public Page<Produto> findAll(Pageable pageable) {
        return this.produtoRepository.findAll(pageable);
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (!produto.isPresent()) throw new EntityNotFoundException("Produto inexistente");
        return produto.get();
    }

    @Transactional
    public void deleteById(Long id) {
        Produto produto = this.findById(id);
        this.produtoRepository.deleteById(produto.getId());
        ProdutoImagemFileService produtoImagemFileService = new ProdutoImagemFileService("/produtos/", produto);
        produtoImagemFileService.deleteDirectory();
    }

    @Transactional(rollbackOn = {Exception.class})
    public Produto save(ProdutoForm produtoForm) {

        if (this.produtoRepository.existsByNome(produtoForm.getNome()))
            throw new FieldValueAlreadyExistsException("Já existe um produto com esse nome: " + produtoForm.getNome());

        Produto produto = produtoForm.convert(this.subGrupoService);
        produto = this.produtoRepository.save(produto);

        ProdutoImagemFileService produtoImagemFileService = new ProdutoImagemFileService("/produtos/", produto);
        produtoImagemFileService.createDirectory();
        List<ProdutoImagem> produtoImagens = produtoImagemFileService.storeAll(produtoForm.getImagens());
        this.produtoImagemService.saveAll(produtoImagens, produto);
        produto.setImagens(produtoImagens);
        return produto;
    }

    @Transactional(rollbackOn = Exception.class)
    public Produto edit(Long id, ProdutoForm produtoForm) {
        Produto produto = this.findById(id);
        SubGrupo subGrupo = this.subGrupoService.findById(produtoForm.getId_subgrupo());

        Optional<Produto> optionalProduto = this.produtoRepository.findByNome(produtoForm.getNome());
        if (optionalProduto.isPresent() && optionalProduto.get().getId() != produto.getId())
            throw new FieldValueAlreadyExistsException("Já existe um produto com esse nome");

        List<ProdutoImagem> antigas = produto.getImagens();
        ProdutoImagemFileService produtoImagemFileService = new ProdutoImagemFileService("/produtos/", produto);
        List<ProdutoImagem> novas = produtoImagemFileService.storeAll(produtoForm.getImagens());

        this.produtoImagemService.saveAll(novas, produto);

        if (antigas.size() > novas.size()) {
            Map<Path, ProdutoImagem> toDelete = this.difference(antigas, novas);
            produtoImagemFileService.deleteAll(new ArrayList<>(toDelete.keySet()));
            this.produtoImagemService.deleteAll(new ArrayList<>(toDelete.values()));
        }

        produto.setImagens(novas);
        produto.setNome(produtoForm.getNome());
        produto.setSubgrupo(subGrupo);
        produto.setDetalhes(produtoForm.getDetalhes());
        produto.setPreco(produtoForm.getPreco());

        return produto;
    }


    public Map<Path, ProdutoImagem> difference(List<ProdutoImagem> antigas, List<ProdutoImagem> novas) {
        final Map<Path, ProdutoImagem> produtoImagemHashMap = new HashMap<>();
        for (ProdutoImagem antiga : antigas) {
            if (!novas.contains(antiga)) {
                produtoImagemHashMap.put(Paths.get(antiga.getUrl() + "." + String.valueOf(antiga.getTipoImagem())), antiga);
            }
        }
        return produtoImagemHashMap;
    }
}
