package com.ecommercerest.repository;

import com.ecommercerest.model.FichaTecnicaCampo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FichaTecnicaCampoRepository extends CrudRepository<FichaTecnicaCampo, Short> {

    public Page<FichaTecnicaCampo> findAll(Pageable pageable);
}
