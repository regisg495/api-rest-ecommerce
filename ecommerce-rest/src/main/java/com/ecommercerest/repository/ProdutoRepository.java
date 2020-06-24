package com.ecommercerest.repository;

import com.ecommercerest.model.Produto;
import com.ecommercerest.model.SubGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Override
    public List<Produto> findAll();

    public Page<Produto> findAll(Pageable pageable);

    public Page<Produto> findAllBySubgrupo(SubGrupo subGrupo, Pageable pageable);

    public List<Produto> findAllBySubgrupo(SubGrupo subGrupo);

    public Optional<Produto> findByNome(String nome);

    public Boolean existsByNome(String nome);
}
