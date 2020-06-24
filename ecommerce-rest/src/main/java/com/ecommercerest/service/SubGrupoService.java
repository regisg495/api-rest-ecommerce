package com.ecommercerest.service;

import com.ecommercerest.config.cache.SubGrupoCache;
import com.ecommercerest.controller.form.SubGrupoForm;
import com.ecommercerest.error.FieldValueAlreadyExistsException;
import com.ecommercerest.error.ParentRowDeleteException;
import com.ecommercerest.model.Grupo;
import com.ecommercerest.model.SubGrupo;
import com.ecommercerest.repository.SubGrupoRepository;
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
public class SubGrupoService {

    @Autowired
    private SubGrupoRepository subGrupoRepository;

    @Autowired
    private GrupoService grupoService;

    public List<SubGrupo> findAllByGrupo(Grupo grupo) {
        return this.subGrupoRepository.findAllByGrupo(grupo);
    }

    public List<SubGrupo> findAll() {
        return this.subGrupoRepository.findAll();
    }

    public Page<SubGrupo> findAll(Pageable pageable) {
        return this.subGrupoRepository.findAll(pageable);
    }

    public SubGrupo findByNome(String nome) {
        Optional<SubGrupo> subGrupo = this.subGrupoRepository.findByNome(nome);
        if (!subGrupo.isPresent()) throw new EntityNotFoundException("Subgrupo inexistente");
        return subGrupo.get();
    }

    @Cacheable(value = SubGrupoCache.SINGLE_SUBGRUPO, key = "#id", unless = "#result instanceof T(java.lang.Exception)")
    public SubGrupo findById(Short id) {
        Optional<SubGrupo> subGrupo = this.subGrupoRepository.findById(id);
        if (!subGrupo.isPresent()) throw new EntityNotFoundException("Subgrupo inexistente");
        return subGrupo.get();
    }

    @Transactional
    @CacheEvict(value = SubGrupoCache.SINGLE_SUBGRUPO, key = "#id")
    public void deleteById(Short id) {
        SubGrupo subGrupo = this.findById(id);
        if (!subGrupo.getProdutos().isEmpty())
            throw new ParentRowDeleteException("Este subgrupo tem produtos cadastrados");
        this.subGrupoRepository.deleteById(subGrupo.getId());
    }

    @Transactional
    @CacheEvict(value = SubGrupoCache.SINGLE_SUBGRUPO, allEntries = true, condition = "!(#result instanceof T(java.lang.Exception))")
    public SubGrupo save(SubGrupoForm subGrupoForm) {
        SubGrupo subGrupo = subGrupoForm.convert(this.grupoService);
        if (subGrupoRepository.existsByNome(subGrupo.getNome()))
            throw new FieldValueAlreadyExistsException("Já existe um subgrupo cadastrado com esse nome: " + subGrupo.getNome());
        return this.subGrupoRepository.save(subGrupo);
    }

    @Transactional
    @CachePut(value = SubGrupoCache.SINGLE_SUBGRUPO, key = "#id", unless = "#result instanceof T(java.lang.Exception)")
    public SubGrupo edit(Short id, SubGrupoForm subGrupoForm) {
        SubGrupo subGrupo = this.findById(id);
        Optional<SubGrupo> subGrupoOptional = this.subGrupoRepository.findByNome(subGrupoForm.getNome());

        if (subGrupoOptional.isPresent() && subGrupoOptional.get().getId() != subGrupo.getId()) {
            throw new FieldValueAlreadyExistsException("Já existe um subgrupo cadastrado com esse nome: " + subGrupo.getNome());
        }

        Grupo grupo = this.grupoService.findById(subGrupoForm.getId_grupo());
        subGrupo.setGrupo(grupo);
        subGrupo.setNome(subGrupoForm.getNome());
        subGrupo.setDetalhes(subGrupoForm.getDetalhes());

        return subGrupo;
    }
}
