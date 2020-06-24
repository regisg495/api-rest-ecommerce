package com.ecommercerest.repository;

import com.ecommercerest.model.Produto;
import com.ecommercerest.model.ProdutoImagem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoImagemRepository extends CrudRepository<ProdutoImagem, String> {

    @Override
    public List<ProdutoImagem> findAll();

    public void deleteDistinctByProduto(Produto produto);

}
