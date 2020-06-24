package com.ecommercerest.repository;

import com.ecommercerest.model.FichaTecnicaProduto;
import com.ecommercerest.model.SubGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FichaTecnicaProdutoRepository extends CrudRepository<FichaTecnicaProduto, Long> {

    public Page<FichaTecnicaProduto> findAll(Pageable pageable);

    public Boolean existsByProdutoSubgrupo(SubGrupo subGrupo);
}
