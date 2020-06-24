package com.ecommercerest.service;

import com.ecommercerest.config.cache.GrupoCache;
import com.ecommercerest.controller.form.GrupoForm;
import com.ecommercerest.error.FieldValueAlreadyExistsException;
import com.ecommercerest.error.ParentRowDeleteException;
import com.ecommercerest.model.Grupo;
import com.ecommercerest.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo findByNome(String nome) {
        Optional<Grupo> grupo = this.grupoRepository.findByNome(nome);
        if (!grupo.isPresent()) throw new EntityNotFoundException("Grupo inexistente");
        return grupo.get();
    }

    public List<Grupo> findAll() {
        return this.grupoRepository.findAll();
    }

    public Page<Grupo> findAll(Pageable pageable) {
        return this.grupoRepository.findAll(pageable);
    }

    @Cacheable(value = GrupoCache.SINGLE_GRUPO, key = "#id", unless = "#result instanceof T(java.lang.Exception)")
    public Grupo findById(Short id) {
        Optional<Grupo> grupo = this.grupoRepository.findById(id);
        if (!grupo.isPresent()) throw new EntityNotFoundException("Grupo Inexistente");
        return grupo.get();
    }

    @Transactional
    @CacheEvict(value = GrupoCache.SINGLE_GRUPO, key = "#id")
    public void deleteById(Short id) {
        Grupo grupo = this.findById(id);
        if (!grupo.getSubGrupos().isEmpty()) throw new ParentRowDeleteException("Este grupo tem subgrupos cadastrados");
        this.grupoRepository.deleteById(grupo.getId());
    }

    @Transactional
    @CacheEvict(value = GrupoCache.SINGLE_GRUPO, allEntries = true, condition = "!(#result instanceof T(java.lang.Exception))")
    public Grupo save(GrupoForm grupoForm) {
        Grupo grupo = grupoForm.convert();
        if (this.grupoRepository.existsByNome(grupo.getNome()))
            throw new FieldValueAlreadyExistsException("Já existe um grupo com esse nome: " + grupo.getNome());
        return this.grupoRepository.save(grupo);
    }

    @Transactional
    @CachePut(value = GrupoCache.SINGLE_GRUPO, key = "#id", unless = "#result instanceof T(java.lang.Exception)")
    public Grupo edit(Short id, GrupoForm grupoForm) {
        Grupo grupo = this.findById(id);
        Optional<Grupo> grupoOptional = this.grupoRepository.findByNome(grupoForm.getNome());
        if (grupoOptional.isPresent() && grupoOptional.get().getId() != grupo.getId())
            throw new FieldValueAlreadyExistsException("Já existe um grupo cadastrado com esse nome: " + grupo.getNome());
        grupo.setNome(grupoForm.getNome());
        grupo.setDetalhes(grupoForm.getDetalhes());
        return grupo;
    }


}
