package com.ecommercerest.repository;

import com.ecommercerest.model.Grupo;
import com.ecommercerest.model.SubGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubGrupoRepository extends CrudRepository<SubGrupo, Short> {

    @Override
    public List<SubGrupo> findAll();

    public Page<SubGrupo> findAll(Pageable pageable);

    public List<SubGrupo> findAllByGrupo(Grupo grupo);

    public Optional<SubGrupo> findByNome(String nome);

    public Boolean existsByGrupo(Grupo grupo);

    public Boolean existsByNome(String nome);

}
