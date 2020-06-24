package com.ecommercerest.repository;

import com.ecommercerest.model.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GrupoRepository extends CrudRepository<Grupo, Short> {

    @Override
    public List<Grupo> findAll();

    Page<Grupo> findAll(Pageable pageable);

    public Optional<Grupo> findByNome(String nome);

    public Boolean existsByNome(String nome);

}
