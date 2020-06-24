package com.ecommercerest.repository;

import com.ecommercerest.model.Endereco;
import com.ecommercerest.model.TipoEndereco;
import com.ecommercerest.model.UF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

    @Override
    public List<Endereco> findAll();

    public Page<Endereco> findAll(Pageable pageable);

    public Page<Endereco> findAllByTipoEnderecoAndCep_Uf(TipoEndereco tipoEndereco, UF uf, Pageable pageable);

}

